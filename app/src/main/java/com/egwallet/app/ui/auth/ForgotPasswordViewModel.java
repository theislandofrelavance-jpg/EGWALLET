package com.egwallet.app.ui.auth;

import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;

public class ForgotPasswordViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();

    public void sendReset(String email) {
        // Mock: no-op, in a real implementation call repository service
    }
}
