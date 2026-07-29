package com.egwallet.app.ui.transactions;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.egwallet.app.R;

/**
 * Simple placeholder Filter dialog used during frontend development to avoid blocking.
 */
public class TransactionFilterDialogFragment extends DialogFragment {

    public static TransactionFilterDialogFragment newInstance() { return new TransactionFilterDialogFragment(); }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        androidx.appcompat.app.AlertDialog.Builder b = new androidx.appcompat.app.AlertDialog.Builder(requireContext());
        b.setTitle("Filtrer");
        b.setMessage("Fonction de filtrage temporaire (mock)");
        b.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        return b.create();
    }
}
