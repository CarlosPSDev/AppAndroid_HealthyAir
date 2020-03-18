package com.riluca.healthyair.ui.logOut;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.riluca.healthyair.MainActivity;
import com.riluca.healthyair.R;

public class LogOutFragment extends Fragment {

    FirebaseAuth fba;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle(R.string.msg_salida)
                .setMessage(R.string.pregunta_salida)
                .setPositiveButton(R.string.salida_si, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                        fba = FirebaseAuth.getInstance();

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent);

                    }
                })
                .setNegativeButton(R.string.salida_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent i = new Intent(getContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
        dialog.show();

        return null;
    }
}