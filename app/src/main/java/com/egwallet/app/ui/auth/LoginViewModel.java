package com.egwallet.app.ui.auth;

import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;

/**
 * Login ViewModel - lightweight logic for frontend wiring.
 */
public class LoginViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();

    public boolean login(String email, String password) {
        // For frontend development we accept any non-empty credentials and mark user logged in
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) return false;
        repo.setUserLoggedIn(true);
        return true;
    }
}
