package com.egwallet.app.ui.beneficiaries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;
import com.egwallet.app.model.Beneficiary;

import java.util.List;

public class BeneficiariesViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();
    private final MutableLiveData<List<Beneficiary>> beneficiaries = new MutableLiveData<>();

    public BeneficiariesViewModel() { load(); }

    private void load() { beneficiaries.setValue(repo.getBeneficiaries()); }

    public LiveData<List<Beneficiary>> getBeneficiaries() { return beneficiaries; }
}
