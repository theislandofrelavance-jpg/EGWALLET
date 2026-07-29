package com.egwallet.app.ui.auth;

import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;

public class RegisterViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();

    public boolean register(String name, String email, String password) {
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) return false;
        // Store minimal mock state
        repo.setUserLoggedIn(true);
        return true;
    }
}
