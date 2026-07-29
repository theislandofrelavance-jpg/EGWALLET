package com.egwallet.app.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;
import com.egwallet.app.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Dashboard ViewModel - exposes balance and recent transactions using the MockRepository.
 */
public class DashboardViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();
    private final MutableLiveData<Double> balance = new MutableLiveData<>();
    private final MutableLiveData<List<Transaction>> recentTransactions = new MutableLiveData<>();

    public DashboardViewModel() {
        loadData();
    }

    private void loadData() {
        balance.setValue(repo.getBalance());
        recentTransactions.setValue(repo.getRecentTransactions());
    }

    public LiveData<Double> getBalance() { return balance; }
    public LiveData<List<Transaction>> getRecentTransactions() { return recentTransactions; }
}
