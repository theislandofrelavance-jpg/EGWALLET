package com.egwallet.app.ui.transactions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;
import com.egwallet.app.model.Transaction;

import java.util.List;

public class TransactionsViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();
    private final MutableLiveData<List<Transaction>> allTransactions = new MutableLiveData<>();

    public TransactionsViewModel() {
        load();
    }

    private void load() {
        allTransactions.setValue(repo.getAllTransactions());
    }

    public LiveData<List<Transaction>> getAllTransactions() { return allTransactions; }
}
