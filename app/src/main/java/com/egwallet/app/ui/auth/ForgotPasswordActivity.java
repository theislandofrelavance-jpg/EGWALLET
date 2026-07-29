package com.egwallet.app.ui.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.egwallet.app.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
    private ForgotPasswordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);

        binding.btnSendReset.setOnClickListener(v -> {
            String email = binding.etEmailForgot.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Veuillez saisir votre email", Toast.LENGTH_SHORT).show();
                return;
            }
            viewModel.sendReset(email);
            Toast.makeText(this, "Email de réinitialisation envoyé (mock)", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
