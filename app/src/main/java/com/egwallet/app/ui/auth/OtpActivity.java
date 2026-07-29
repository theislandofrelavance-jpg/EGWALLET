package com.egwallet.app.ui.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.egwallet.app.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    private ActivityOtpBinding binding;
    private OtpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(OtpViewModel.class);

        binding.btnVerify.setOnClickListener(v -> {
            String code = binding.etOtp.getText().toString().trim();
            if (TextUtils.isEmpty(code)) {
                Toast.makeText(this, "Veuillez entrer le code", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean ok = viewModel.verify(code);
            if (ok) {
                Toast.makeText(this, "Code vérifié (mock)", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Code invalide (mock)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
