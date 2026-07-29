package com.egwallet.app.ui.auth;

import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;

public class OtpViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();

    public boolean verify(String code) {
        // Accept any 4+ digit code in mock
        if (code == null) return false;
        return code.length() >= 4;
    }
}
