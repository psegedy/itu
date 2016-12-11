package com.matsem.pripomienkovac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;




public class GamesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//            // making notification bar transparent
//            changeStatusBarColor();
//        }

        setContentView(R.layout.activity_games);

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
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
