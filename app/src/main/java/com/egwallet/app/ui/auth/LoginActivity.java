package com.egwallet.app.ui.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.egwallet.app.databinding.ActivityLoginBinding;
import com.egwallet.app.data.MockRepository;

/**
 * Simple LoginActivity using ViewBinding and LoginViewModel.
 * Uses MockRepository for authentication state during frontend development.
 */
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean ok = viewModel.login(email, password);
            if (ok) {
                Toast.makeText(this, "Connecté (mock)", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Échec de la connexion (mock)", Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvForgot.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, ForgotPasswordActivity.class));
        });

        binding.tvRegister.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, RegisterActivity.class));
        });
    }
}
