package com.egwallet.app.ui.beneficiaries;

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

import com.egwallet.app.databinding.FragmentBeneficiariesBinding;
import com.egwallet.app.model.Beneficiary;

import java.util.List;

/**
 * Beneficiaries list fragment. Uses MockRepository for data during frontend development.
 */
public class BeneficiariesFragment extends Fragment implements BeneficiaryAdapter.BeneficiaryClickListener {

    private FragmentBeneficiariesBinding binding;
    private BeneficiariesViewModel viewModel;
    private BeneficiaryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBeneficiariesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(BeneficiariesViewModel.class);

        adapter = new BeneficiaryAdapter(this);
        binding.rvBeneficiaries.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvBeneficiaries.setAdapter(adapter);

        viewModel.getBeneficiaries().observe(getViewLifecycleOwner(), new Observer<List<Beneficiary>>() {
            @Override
            public void onChanged(List<Beneficiary> beneficiaries) {
                adapter.submitList(beneficiaries);
            }
        });

        binding.btnAddBeneficiary.setOnClickListener(v -> {
            // open AddBeneficiaryActivity (placeholder)
            startActivity(new Intent(requireContext(), AddBeneficiaryActivity.class));
        });
    }

    @Override
    public void onBeneficiaryClicked(Beneficiary beneficiary) {
        Intent i = new Intent(requireContext(), BeneficiaryDetailActivity.class);
        i.putExtra(BeneficiaryDetailActivity.EXTRA_BEN_ID, beneficiary.getId());
        startActivity(i);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
