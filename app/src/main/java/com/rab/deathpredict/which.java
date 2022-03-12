package com.rab.deathpredict;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.squareup.picasso.Picasso;

import java.util.Random;

/**
 * Self Explainatory
 */

public class which extends AppCompatActivity {
   // private AdView mAdView;
    String name;
    int wat;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_lynx);
        //mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (isFirstTime()) {
            MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .title("Predict Death")
                    .content("This is in no way real! (If you haven't figured it out already)\nThis was made for fun to play around with when you are bored :) do not take this results serious in any way, you shouldn't worry about when you will die or how you will die. life is meant to be enjoyed and so is this app!")
                    .positiveColor(Color.parseColor("#F44336"))
                    .dividerColor(Color.parseColor("#F44336"))
                    .theme(Theme.DARK)
                    .positiveText("Ok")
                    .show();
        }
        final String[] Deaths = new String[] {"Alcohol", "Hypertension", "Alzheimer", "Smoking", "Vaping", "Slipping in the shower", "Mixing bleach and ammonia while cleaning", "Allergy attacks", "Car accident", "Plane crash", "Terrorist Attack", "Bomb blast", "Carbon monoxide poisoning", "Drowning", "Suicide", "Jumping out the window", "Taking selfies", "Overdosing", "Shaking snack machines", "Drinking too much water", "Falling off ladders", "Choking", "Wearing a really long scarf in a convertible", "BASE Jump", "Diving into the shallow end", "Not looking when you cross the street", "Brain aneurysms", "Stroke", "Starvation", "Dehydration", "Decapitation", "Lethal Injection", "Electric Chair", "Crucifixion", "Decompression", "Burning", "Radiation", "Scaphism"};
        int r = new Random().nextInt(Deaths.length);
        Intent intent = getIntent();
        name = intent.getStringExtra("key");
        wat = intent.getIntExtra("boolly", 2);
        String text3 = "Hello " + CapFirstyBaby(name) + "\n" + "I have been waiting for you...\n";
        int huaa = new Random().nextInt(100);
        String text4 = text3 + huaa + " will be the age of your death.";
        String text = "Hello " + CapFirstyBaby(name) + "\n" +
                "I have been waiting for you...\n";
        String text2 = text + Deaths[r] + " will be the cause of your death.";
        Spannable spannable2 = new SpannableString(text4);
        spannable2.setSpan(new ForegroundColorSpan(Color.RED), text3.length(), (text3 + String.valueOf(huaa)).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Spannable spannable = new SpannableString(text2);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), text.length(), (text + Deaths[r]).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        String how = "";
        String when = "";
        iv = findViewById(R.id.ImageView);
        int uri = R.drawable.reaper;
        Picasso.with(this)
                .load(uri)
                .fit()
                .into(iv);
        TextView tv = findViewById(R.id.result);
        tv.setText(wat == 1 ? spannable : spannable2, TextView.BufferType.SPANNABLE);
    }
    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }
    public static String CapFirstyBaby(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
