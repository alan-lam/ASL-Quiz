package com.example.aslquiz;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNewLetter();
    }

    public void checkInput(View view) {
        ImageView signImageView = findViewById(R.id.sign);
        ImageView checkImageView = findViewById(R.id.checkmark);
        String letter = signImageView.getTag().toString();

        if (letter.equals(view.getTag().toString())) {
            signImageView.setVisibility(View.GONE);
            checkImageView.setVisibility(View.VISIBLE);
            delay(signImageView, checkImageView);
            showNewLetter();
        }
    }

    public void showNewLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Random r = new Random();
        int n = r.nextInt(26);

        ImageView signImageView = findViewById(R.id.sign);
        int id = this.getResources().getIdentifier(""+alphabet[n], "drawable", this.getPackageName());
        signImageView.setImageResource(id);
        signImageView.setTag(""+alphabet[n]);
    }

    public void delay(final ImageView signImageView, final ImageView checkImageView) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* what goes in run() will happen after 500 ms */
                signImageView.setVisibility(View.VISIBLE);
                checkImageView.setVisibility(View.GONE);
            }
        }, 500);
    }
}
