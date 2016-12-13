package com.matsem.pripomienkovac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
    AlertDialog.Builder dialog;
    AlertDialog diag;
    Button btnOk;
    int taken;
    private int take1_count;
    private int take2_count;
    private int take3_count;
    private int take4_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_take_pills);

        // making notification bar transparent
        changeStatusBarColor();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            dialog = new AlertDialog.Builder(this);
        }
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
        btnOk = (Button) findViewById(R.id.btn_ok);
        taken = 0;
        take1_count = 0;
        take2_count = 0;
        take3_count = 0;
        take4_count = 0;

        take1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take1_all.setAlpha((float) 0.1);
                take1_all.setBackgroundColor(0x000000);
                clicked(take1);
            }
        });

        take2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take2_all.setAlpha((float) 0.1);
                take2_all.setBackgroundColor(0x000000);
                clicked(take2);
            }
        });

        take3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take3_all.setAlpha((float) 0.1);
                take3_all.setBackgroundColor(0x000000);
                clicked(take3);
            }
        });

        take4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                take4_all.setAlpha((float) 0.1);
                take4_all.setBackgroundColor(0x000000);
                clicked(take4);
            }
        });

        take1_cam.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                showPhoto(dialog, R.drawable.no_pill, "Žiadna fotografia");
            }
        });

        take2_cam.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                showPhoto(dialog, R.mipmap.paralen, "Paralen");
            }
        });

        take3_cam.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                showPhoto(dialog, R.drawable.no_pill, "Žiadna fotografia");
            }
        });

        take4_cam.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                showPhoto(dialog, R.mipmap.maltofer, "Maltofer Fol");
            }
        });
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void viewBeforeMeal(View view) {
        Toast toast = Toast.makeText(TakePillsActivity.this, "Požívajte pred jedlom.", Toast.LENGTH_LONG);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(33);
        toast.show();
    }

    public void viewWithMeal(View view) {
        Toast toast = Toast.makeText(TakePillsActivity.this, "Požívajte s jedlom.", Toast.LENGTH_LONG);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(33);
        toast.show();
    }

    public void viewAfterMeal(View view) {
        Toast toast = Toast.makeText(TakePillsActivity.this, "Požívajte po jedle.", Toast.LENGTH_LONG);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(33);
        toast.show();
    }

    public void hideDialog(View view) {
        diag.dismiss();
    }

    public void showPhoto(AlertDialog.Builder dialog, int image, String name) {
        dialog.setView(R.layout.show_photo)
                .setTitle(name)
                .create();
        diag = dialog.show();
        ImageView photo = (ImageView) diag.findViewById(R.id.photo);
        photo.setImageResource(image);
    }

    public void clicked(LinearLayout take) {
        if (take == take1 && take1_count < 1) {
            taken++;
            take1_count++;
        } else if (take == take2 && take2_count < 1) {
            taken++;
            take2_count++;
        } else if (take == take3 && take3_count < 1) {
            taken++;
            take3_count++;
        } else if (take == take4 && take4_count < 1) {
            taken++;
            take4_count++;
        }

        if (taken == 4) {
            Toast toast = Toast.makeText(TakePillsActivity.this, "Užili ste všetky lieky!\nLen tak ďalej!", Toast.LENGTH_LONG);
            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(31);
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

}
