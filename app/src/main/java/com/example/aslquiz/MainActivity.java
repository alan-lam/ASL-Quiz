package com.example.aslquiz;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNewLetter();
    }

    public void checkInput(View view) {
        TextView textView = findViewById(R.id.text_view);
        ImageView imageView = findViewById(R.id.checkmark);
        String letter = textView.getText().toString();

        if (letter.equals(view.getTag().toString())) {
            textView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            delay(textView, imageView);
            showNewLetter();
        }
    }

    public void showNewLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Random r = new Random();
        int n = r.nextInt(26);

        TextView textView = findViewById(R.id.text_view);
        textView.setText(""+alphabet[n]);
    }

    /* https://stackoverflow.com/questions/15874117/how-to-set-delay-in-android */
    public void delay(final TextView textView, final ImageView imageView) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* what goes in run() will happen after 500 ms */
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
            }
        }, 500);
    }
}
