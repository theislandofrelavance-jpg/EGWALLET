package com.egwallet.app.data;

/**
 * Lightweight MockRepository to provide minimal data contract for ViewModels during UI implementation.
 * Expanded with simple auth methods for frontend mock flows.
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
}
