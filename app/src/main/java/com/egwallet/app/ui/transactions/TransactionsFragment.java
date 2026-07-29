package com.egwallet.app.ui.transactions;

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

import com.egwallet.app.databinding.FragmentTransactionsBinding;
import com.egwallet.app.model.Transaction;

import java.util.List;

/**
 * Transactions list Fragment: shows all transactions with a filter button.
 */
public class TransactionsFragment extends Fragment {

    private FragmentTransactionsBinding binding;
    private TransactionsViewModel viewModel;
    private com.egwallet.app.ui.dashboard.TransactionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(TransactionsViewModel.class);

        adapter = new com.egwallet.app.ui.dashboard.TransactionAdapter();
        binding.rvAllTransactions.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvAllTransactions.setAdapter(adapter);

        viewModel.getAllTransactions().observe(getViewLifecycleOwner(), new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                adapter.submitList(transactions);
            }
        });

        binding.btnFilter.setOnClickListener(v -> {
            // show a simple filter dialog (placeholder) — in a real app provide filter UI
            TransactionFilterDialogFragment.newInstance().show(getChildFragmentManager(), "filter");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
