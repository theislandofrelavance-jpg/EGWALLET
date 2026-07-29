package com.egwallet.app.ui.cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.egwallet.app.databinding.FragmentCardsBinding;
import com.egwallet.app.model.Card;

import java.util.List;

/**
 * Cards module: list of user cards with add action and card detail navigation.
 */
public class CardsFragment extends Fragment implements CardListAdapter.CardClickListener {

    private FragmentCardsBinding binding;
    private CardsViewModel viewModel;
    private CardListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCardsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(CardsViewModel.class);

        adapter = new CardListAdapter(this);
        binding.rvCardsList.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvCardsList.setAdapter(adapter);

        viewModel.getCards().observe(getViewLifecycleOwner(), new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.submitList(cards);
            }
        });

        binding.fabAddCard.setOnClickListener(v -> {
            // placeholder: open AddCardActivity (not yet implemented) or show mock dialog
            startActivity(new Intent(requireContext(), AddCardActivity.class));
        });
    }

    @Override
    public void onCardClicked(Card card) {
        Intent i = new Intent(requireContext(), CardDetailActivity.class);
        i.putExtra(CardDetailActivity.EXTRA_CARD_ID, card.getId());
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
