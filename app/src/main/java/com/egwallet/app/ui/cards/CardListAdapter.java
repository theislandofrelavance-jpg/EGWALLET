package com.egwallet.app.ui.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.egwallet.app.databinding.ItemCardListBinding;
import com.egwallet.app.model.Card;

public class CardListAdapter extends ListAdapter<Card, CardListAdapter.VH> {

    public interface CardClickListener { void onCardClicked(Card card); }

    private final CardClickListener listener;

    protected CardListAdapter(CardClickListener listener) {
        super(DIFF);
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCardListBinding b = ItemCardListBinding.inflate(inflater, parent, false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Card c = getItem(position);
        holder.binding.tvCardNameItem.setText(c.getName());
        holder.binding.tvCardLast4Item.setText("**** " + c.getLast4());
        holder.binding.getRoot().setOnClickListener(v -> listener.onCardClicked(c));
    }

    static class VH extends RecyclerView.ViewHolder {
        final ItemCardListBinding binding;
        VH(ItemCardListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static final DiffUtil.ItemCallback<Card> DIFF = new DiffUtil.ItemCallback<Card>() {
        @Override
        public boolean areItemsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem.getLast4().equals(newItem.getLast4()) && oldItem.getName().equals(newItem.getName());
        }
    };
}
