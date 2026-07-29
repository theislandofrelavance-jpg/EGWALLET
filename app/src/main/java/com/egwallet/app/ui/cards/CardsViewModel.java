package com.egwallet.app.ui.cards;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.egwallet.app.data.MockRepository;
import com.egwallet.app.model.Card;

import java.util.List;

public class CardsViewModel extends ViewModel {

    private final MockRepository repo = MockRepository.getInstance();
    private final MutableLiveData<List<Card>> cards = new MutableLiveData<>();

    public CardsViewModel() { load(); }

    private void load() { cards.setValue(repo.getCards()); }

    public LiveData<List<Card>> getCards() { return cards; }
}
