package com.egwallet.app.ui.beneficiaries;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.egwallet.app.databinding.ItemBeneficiaryBinding;
import com.egwallet.app.model.Beneficiary;

public class BeneficiaryAdapter extends ListAdapter<Beneficiary, BeneficiaryAdapter.VH> {

    public interface BeneficiaryClickListener { void onBeneficiaryClicked(Beneficiary b); }

    private final BeneficiaryClickListener listener;

    protected BeneficiaryAdapter(BeneficiaryClickListener listener) {
        super(DIFF);
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBeneficiaryBinding b = ItemBeneficiaryBinding.inflate(inflater, parent, false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Beneficiary item = getItem(position);
        holder.binding.tvBeneficiaryName.setText(item.getName());
        holder.binding.tvBeneficiaryDetail.setText(item.getDetails());
        holder.binding.getRoot().setOnClickListener(v -> listener.onBeneficiaryClicked(item));
    }

    static class VH extends RecyclerView.ViewHolder {
        final ItemBeneficiaryBinding binding;
        VH(ItemBeneficiaryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static final DiffUtil.ItemCallback<Beneficiary> DIFF = new DiffUtil.ItemCallback<Beneficiary>() {
        @Override
        public boolean areItemsTheSame(@NonNull Beneficiary oldItem, @NonNull Beneficiary newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Beneficiary oldItem, @NonNull Beneficiary newItem) {
            return oldItem.getName().equals(newItem.getName()) && oldItem.getDetails().equals(newItem.getDetails());
        }
    };
}
