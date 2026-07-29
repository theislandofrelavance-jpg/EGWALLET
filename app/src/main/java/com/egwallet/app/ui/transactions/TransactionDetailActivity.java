package com.egwallet.app.ui.transactions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.egwallet.app.databinding.ActivityTransactionDetailBinding;
import com.egwallet.app.model.Transaction;

/**
 * Simple TransactionDetailActivity showing transaction details passed via Intent extras.
 * For frontend mock, accepts extras: id, title, subtitle, amount, date
 */
public class TransactionDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_SUBTITLE = "extra_subtitle";
    public static final String EXTRA_AMOUNT = "extra_amount";
    public static final String EXTRA_DATE = "extra_date";

    private ActivityTransactionDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransactionDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        String title = i.getStringExtra(EXTRA_TITLE);
        String subtitle = i.getStringExtra(EXTRA_SUBTITLE);
        double amount = i.getDoubleExtra(EXTRA_AMOUNT, 0);
        String date = i.getStringExtra(EXTRA_DATE);

        binding.tvDetailTitleValue.setText(title != null ? title : "");
        binding.tvDetailMerchantValue.setText(subtitle != null ? subtitle : "");
        binding.tvDetailAmount.setText(String.format("%+.2f €", amount));
        binding.tvDetailDateValue.setText(date != null ? date : "");
    }
}
