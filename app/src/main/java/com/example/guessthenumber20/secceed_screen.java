package com.example.guessthenumber20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class secceed_screen extends AppCompatActivity implements View.OnClickListener {
 Button RestartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secceed_screen);

        RestartButton = (Button) findViewById(R.id.RestartButton);
        RestartButton.setOnClickListener(this);


        SharedPreferences sharedp = getSharedPreferences("your_prefs", MODE_PRIVATE);
        int wincounter = sharedp.getInt("counter", 0);

        final TextView textView = findViewById(R.id.textView9);
        textView.setText(Integer.toString(wincounter));


    }

    @Override
    public void onClick(View v) {
        if (v == RestartButton)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Chose Range");
            builder.setMessage("What range of numbers you want to play in:");
            builder.setCancelable(true);



            builder.setNeutralButton("1-10", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(secceed_screen.this, MainActivity.class));

                }
            });
            builder.setNegativeButton("1-100", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(secceed_screen.this, OneToHundred.class));

                }
            });
            builder.setPositiveButton("1-1000", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(secceed_screen.this, OneToThousand.class));

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }


}



