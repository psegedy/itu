package com.matsem.pripomienkovac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_games);

    }

    public void playHangman(View view){
        Intent intent = new Intent(this, HangmanActivity.class);
        startActivity(intent);
    }

    public void playPexeso(View view){
        Intent intent = new Intent(this, PexesoActivity.class);
        startActivity(intent);
    }

    public void playMelodies(View view){
        Intent intent = new Intent(this, MelodiesActivity.class);
        startActivity(intent);
    }
}
