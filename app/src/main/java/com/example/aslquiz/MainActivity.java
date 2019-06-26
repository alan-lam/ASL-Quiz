package com.example.aslquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        String letter = textView.getText().toString();

        if (letter.equals(view.getTag().toString())) {
            showNewLetter();
        }
        else {
            Toast.makeText(getApplicationContext(), "Nope!", Toast.LENGTH_SHORT).show();
        }
    }

    public void showNewLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Random r = new Random();
        int n = r.nextInt(26);

        TextView textView = findViewById(R.id.text_view);
        textView.setText(""+alphabet[n]);
    }
}
