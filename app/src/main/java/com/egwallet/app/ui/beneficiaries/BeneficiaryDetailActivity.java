package com.egwallet.app.ui.beneficiaries;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.egwallet.app.databinding.ActivityBeneficiaryDetailBinding;
import com.egwallet.app.model.Beneficiary;
import com.egwallet.app.data.MockRepository;

/**
 * Beneficiary detail activity – reads id from intent and displays details.
 */
public class BeneficiaryDetailActivity extends AppCompatActivity {

    public static final String EXTRA_BEN_ID = "extra_ben_id";
    private ActivityBeneficiaryDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBeneficiaryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String id = getIntent().getStringExtra(EXTRA_BEN_ID);
        Beneficiary b = MockRepository.getInstance().getBeneficiaryById(id);
        if (b == null) {
            Toast.makeText(this, "Bénéficiaire introuvable", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        binding.tvBenName.setText(b.getName());
        binding.tvBenDetails.setText(b.getDetails());

        binding.btnRemoveBen.setOnClickListener(v -> {
            MockRepository.getInstance().removeBeneficiary(id);
            Toast.makeText(this, "Bénéficiaire supprimé (mock)", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
