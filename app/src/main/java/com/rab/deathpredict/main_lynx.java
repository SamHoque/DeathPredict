package com.rab.deathpredict;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.squareup.picasso.Picasso;


public class main_lynx extends AppCompatActivity {
   // private AdView mAdView;
    ImageView Iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lynx);
      //  mAdView = findViewById(R.id.adView);
       // AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);
        Iv = findViewById(R.id.v);
        int uri = R.drawable.a;
        Picasso.with(this)
                .load(uri)
                .fit()
                .into(Iv);
        TextView tv = findViewById(R.id.a);
        Typeface tf = Typeface.createFromAsset(getAssets(),"a.ttf");
        tv.setTypeface(tf,Typeface.BOLD);
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askName(0);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askName(1);
            }
        });

    }
    public void askName(int i){
        final int q = i;
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Predict Death")
                .positiveColor(Color.parseColor("#F44336"))
                .dividerColor(Color.parseColor("#F44336"))
                .theme(Theme.DARK)
                .positiveText("Ok")
                .inputRange(1, 50, Color.parseColor("#F44336"))
                .input("Enter your name", null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        switch (q) {
                            case 0:
                                which(String.valueOf(input), 0);
                                break;
                            case 1:
                                which(String.valueOf(input), 1);
                                break;
                        }
                    }
                }).show();
    }
    @Override
    public void onPause() {
//        if (mAdView != null) {
//            mAdView.pause();
//        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (mAdView != null) {
//            mAdView.resume();
//        }
    }

    @Override
    public void onDestroy() {
//        if (mAdView != null) {
//            mAdView.destroy();
//        }
        super.onDestroy();
    }
    public void which(String str, int i){
        Intent myIntent = new Intent(main_lynx.this, which.class);
        myIntent.putExtra("key", str);
        myIntent.putExtra("boolly", i);
        main_lynx.this.startActivity(myIntent);
    }
}