package com.social.apdn.nasne.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import com.social.apdn.nasne.dialogs.databinding.ActivityMainBinding;
import com.social.apdn.nasne.dialogs.databinding.DialogShowBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        binding.clickToViewDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean mode = true;
                processToShowDialog(mode);

            }
        });


        binding.clickToViewDia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean mode = false;
                processToShowDialog(mode);

            }
        });
    }

    private void processToShowDialog(boolean mode)
    {
        DialogShowBinding dialogBinding = DialogShowBinding.inflate(getLayoutInflater());
        android.app.AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setView(dialogBinding.getRoot())
                .setCancelable(mode)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialogBinding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}