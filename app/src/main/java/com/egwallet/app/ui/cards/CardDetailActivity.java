package com.egwallet.app.ui.cards;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.egwallet.app.databinding.ActivityCardDetailBinding;
import com.egwallet.app.model.Card;
import com.egwallet.app.data.MockRepository;

/**
 * CardDetailActivity: shows details of a selected card. Uses MockRepository to fetch card by id.
 */
public class CardDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CARD_ID = "extra_card_id";

    private ActivityCardDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String cardId = getIntent().getStringExtra(EXTRA_CARD_ID);
        Card card = MockRepository.getInstance().getCardById(cardId);
        if (card == null) {
            Toast.makeText(this, "Carte introuvable", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        binding.tvCardNameDetail.setText(card.getName());
        binding.tvCardNumberDetail.setText("**** " + card.getLast4());
        binding.tvCardHolderDetail.setText(card.getHolder());

        binding.btnBlockCard.setOnClickListener(v -> {
            // Placeholder action: block card (mock)
            Toast.makeText(this, "Carte bloquée (mock)", Toast.LENGTH_SHORT).show();
        });

        binding.btnUnblockCard.setOnClickListener(v -> {
            Toast.makeText(this, "Carte débloquée (mock)", Toast.LENGTH_SHORT).show();
        });
    }
}
