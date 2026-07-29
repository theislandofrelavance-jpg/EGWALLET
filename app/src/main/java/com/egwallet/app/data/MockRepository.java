package com.egwallet.app.data;

import com.egwallet.app.model.Account;
import com.egwallet.app.model.Beneficiary;
import com.egwallet.app.model.Card;
import com.egwallet.app.model.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * MockRepository (merged) — extend with beneficiaries helpers used by Beneficiaries module.
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

    public boolean isUserLoggedIn() { return loggedIn; }
    public void setUserLoggedIn(boolean value) { this.loggedIn = value; }
    public boolean isOnboardingSeen() { return onboardingSeen; }
    public void setOnboardingSeen(boolean seen) { this.onboardingSeen = seen; }

    // Auth mocks
    public boolean login(String email, String password) { setUserLoggedIn(true); return true; }
    public boolean register(String name, String email, String password) { setUserLoggedIn(true); return true; }
    public void sendPasswordReset(String email) { }
    public boolean verifyOtp(String otp) { return otp != null && otp.length() >= 4; }

    // Dashboard helpers
    public double getBalance() { return 1245.67; }
    public List<Transaction> getRecentTransactions() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("t1", "Paiement - Café", "Bistrot Central", -3.50, "2026-07-28"));
        list.add(new Transaction("t2", "Salaire", "Entreprise XYZ", 2500.00, "2026-07-27"));
        return list;
    }

    // Wallet helpers
    public List<Account> getAccounts() {
        List<Account> list = new ArrayList<>();
        list.add(new Account("a1", "Compte courant", 1245.67, "EUR"));
        list.add(new Account("a2", "Épargne", 5400.00, "EUR"));
        return list;
    }

    public List<Card> getCards() {
        List<Card> list = new ArrayList<>();
        list.add(new Card("c1", "Visa", "1234", "J. Dupont"));
        list.add(new Card("c2", "Mastercard", "5678", "J. Dupont"));
        return list;
    }

    public Card getCardById(String id) {
        for (Card c : getCards()) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    // Transactions module data
    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("t1", "Paiement - Café", "Bistrot Central", -3.50, "2026-07-28"));
        list.add(new Transaction("t2", "Salaire", "Entreprise XYZ", 2500.00, "2026-07-27"));
        list.add(new Transaction("t3", "Abonnement", "Streaming", -9.99, "2026-07-25"));
        list.add(new Transaction("t4", "Transfert reçu", "Alice", 50.00, "2026-07-24"));
        list.add(new Transaction("t5", "Grocery", "Supermarket", -45.23, "2026-07-23"));
        list.add(new Transaction("t6", "Cadeau", "Pierre", -20.00, "2026-07-22"));
        return list;
    }

    // Beneficiaries helpers
    public List<Beneficiary> getBeneficiaries() {
        List<Beneficiary> list = new ArrayList<>();
        list.add(new Beneficiary("b1", "Alice Martin", "FR76 3000 6000 0112 3456 7890"));
        list.add(new Beneficiary("b2", "Bob Durand", "+33 6 12 34 56 78"));
        return list;
    }

    public Beneficiary getBeneficiaryById(String id) {
        for (Beneficiary b : getBeneficiaries()) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public Beneficiary addBeneficiary(String name, String details) {
        String id = UUID.randomUUID().toString();
        Beneficiary b = new Beneficiary(id, name, details);
        // In a real repo we'd persist; in mock we return created instance (not stored persistently)
        return b;
    }

    public boolean removeBeneficiary(String id) {
        // Mock: not persisted across calls; return true as if removed
        return true;
    }
}
