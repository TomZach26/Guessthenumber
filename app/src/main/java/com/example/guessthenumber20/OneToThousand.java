package com.example.guessthenumber20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;
//random number generate
public class OneToThousand extends AppCompatActivity {
    Random random = new Random();
    int rnd = random.nextInt(1001 - 1);

    EditText userguess;
    Button okbutton;
    int usernumber;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    SharedPreferences sharedp;
    int wincounter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_thousand);
        SharedPreferences sharedp = getSharedPreferences("your_prefs", MODE_PRIVATE);

        userguess = findViewById(R.id.numberinput);
        okbutton = findViewById(R.id.okbutton);
        usernumber = 0;
        wincounter = sharedp.getInt("counter", 0);


        sp = getSharedPreferences("your_prefs", MODE_PRIVATE);
        editor = sp.edit();
        editor.commit();

        // usernumber = Integer.parseInt(userguess.getText().toString());
//menu create

        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernumber = Integer.parseInt(userguess.getText().toString());
                if (usernumber == rnd)
                {
                    wincounter++;
                    editor.putInt("counter", wincounter);
                    editor.apply();



                    opensecceed();

                }
                else if(usernumber>rnd)
                { Context context = getApplicationContext();
                    CharSequence text = "The number you are looking for is lower";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(usernumber<rnd)
                { Context context = getApplicationContext();
                    CharSequence text = "The number you are looking for is higher";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }
    public void opensecceed()
    {
        Intent intent = new Intent(this, secceed_screen.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.onetoten) {
           Toast.makeText(this, "you selected 1-10", Toast.LENGTH_SHORT).show();


            startActivity(new Intent(OneToThousand.this, MainActivity.class));

        } else if (R.id.onetohundred == id) {
            Toast.makeText(this, "you selected 1-100", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(OneToThousand.this, OneToHundred.class));

        } else if (R.id.onetothousand == id) {
            Toast.makeText(this, "you selected 1-1000", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


}
