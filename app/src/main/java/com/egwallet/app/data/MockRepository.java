package com.egwallet.app.data;

import com.egwallet.app.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight MockRepository to provide minimal data contract for ViewModels during UI implementation.
 * Expanded with dashboard helpers to supply sample balance and transactions for frontend development.
 */
public class MockRepository {

    private static MockRepository instance;
    private boolean onboardingSeen = false;
    private boolean loggedIn = false;

    private MockRepository() {}

    public static synchronized MockRepository getInstance() {
        if (instance == null) instance = new MockRepository();
        return instance;
    }

    public boolean isUserLoggedIn() {
        return loggedIn;
    }

    public void setUserLoggedIn(boolean value) {
        this.loggedIn = value;
    }

    public boolean isOnboardingSeen() {
        return onboardingSeen;
    }

    public void setOnboardingSeen(boolean seen) {
        this.onboardingSeen = seen;
    }

    // Auth mock helpers
    public boolean login(String email, String password) {
        setUserLoggedIn(true);
        return true;
    }

    public boolean register(String name, String email, String password) {
        setUserLoggedIn(true);
        return true;
    }

    public void sendPasswordReset(String email) {
        // no-op mock
    }

    public boolean verifyOtp(String otp) {
        return otp != null && otp.length() >= 4;
    }

    // Dashboard sample data
    public double getBalance() {
        return 1245.67;
    }

    public List<Transaction> getRecentTransactions() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("t1", "Paiement - Café", "Bistrot Central", -3.50, "2026-07-28"));
        list.add(new Transaction("t2", "Salaire", "Entreprise XYZ", 2500.00, "2026-07-27"));
        list.add(new Transaction("t3", "Abonnement", "Streaming", -9.99, "2026-07-25"));
        list.add(new Transaction("t4", "Transfert reçu", "Alice", 50.00, "2026-07-24"));
        return list;
    }
}
