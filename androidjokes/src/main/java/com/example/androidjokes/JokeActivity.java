package com.example.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "JOKE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke;
        Intent intent = getIntent();
        if (intent.hasExtra(JOKE_EXTRA)) {
            joke = intent.getStringExtra(JOKE_EXTRA);
        } else {
            joke = getString(R.string.sorry_no_joke);
        }

        TextView jokeText = findViewById(R.id.jokeText);
        jokeText.setText(joke);
    }
}
