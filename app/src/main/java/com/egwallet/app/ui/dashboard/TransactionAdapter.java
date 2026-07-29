package com.egwallet.app.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.egwallet.app.databinding.ItemTransactionBinding;
import com.egwallet.app.model.Transaction;

import java.text.DecimalFormat;

public class TransactionAdapter extends ListAdapter<Transaction, TransactionAdapter.VH> {

    private final DecimalFormat fmt = new DecimalFormat("+#,##0.00;-#,##0.00");

    protected TransactionAdapter() {
        super(DIFF);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTransactionBinding b = ItemTransactionBinding.inflate(inflater, parent, false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Transaction t = getItem(position);
        holder.binding.tvTitle.setText(t.getTitle());
        holder.binding.tvSubtitle.setText(t.getSubtitle());
        holder.binding.tvAmount.setText(fmt.format(t.getAmount()) + " €");
        // icon placeholder already in layout
    }

    static class VH extends RecyclerView.ViewHolder {
        final ItemTransactionBinding binding;
        VH(ItemTransactionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static final DiffUtil.ItemCallback<Transaction> DIFF = new DiffUtil.ItemCallback<Transaction>() {
        @Override
        public boolean areItemsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return oldItem.getAmount() == newItem.getAmount() && oldItem.getTitle().equals(newItem.getTitle());
        }
    };
}
