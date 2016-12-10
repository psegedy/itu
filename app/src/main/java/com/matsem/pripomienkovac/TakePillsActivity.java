package com.matsem.pripomienkovac;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TakePillsActivity extends AppCompatActivity {

    LinearLayout take1;
    LinearLayout take1_all;
    ImageView take1_cam;
    LinearLayout take2;
    LinearLayout take2_all;
    ImageView take2_cam;
    LinearLayout take3;
    LinearLayout take3_all;
    ImageView take3_cam;
    LinearLayout take4;
    LinearLayout take4_all;
    ImageView take4_cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_take_pills);

        take1 = (LinearLayout) findViewById(R.id.take1);
        take1_all = (LinearLayout) findViewById(R.id.take1_all);
        take1_cam = (ImageView) findViewById(R.id.take1_cam);
        take2 = (LinearLayout) findViewById(R.id.take2);
        take2_all = (LinearLayout) findViewById(R.id.take2_all);
        take2_cam = (ImageView) findViewById(R.id.take2_cam);
        take3 = (LinearLayout) findViewById(R.id.take3);
        take3_all = (LinearLayout) findViewById(R.id.take3_all);
        take3_cam = (ImageView) findViewById(R.id.take3_cam);
        take4 = (LinearLayout) findViewById(R.id.take4);
        take4_all = (LinearLayout) findViewById(R.id.take4_all);
        take4_cam = (ImageView) findViewById(R.id.take4_cam);

        take1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take1_all.setAlpha((float) 0.1);
                take1_all.setBackgroundColor(0x000000);
            }
        });

        take2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take2_all.setAlpha((float) 0.1);
                take2_all.setBackgroundColor(0x000000);
            }
        });

        take3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take3_all.setAlpha((float) 0.1);
                take3_all.setBackgroundColor(0x000000);
            }
        });

        take4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take4_all.setAlpha((float) 0.1);
                take4_all.setBackgroundColor(0x000000);
            }
        });
    }

    public PendingIntent getNotificationIntent() {
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(new Intent(this, MainActivity.class));

        return stackBuilder.getPendingIntent(9, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void viewBeforeMeal(View view){
        Toast.makeText(TakePillsActivity.this, "Tento liek požívajte pred jedlom.", Toast.LENGTH_LONG).show();
    }

    public void viewWithMeal(View view){
        Toast.makeText(TakePillsActivity.this, "Tento liek požívajte s jedlom.", Toast.LENGTH_LONG).show();
    }

    public void viewAfterMeal(View view){
        Toast.makeText(TakePillsActivity.this, "Tento liek požívajte po jedle.", Toast.LENGTH_LONG).show();
    }

}
