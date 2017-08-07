package com.esports.vishal.esportsscoreapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.esports.vishal.esportsscoreapplication.CSGO.CsGoScoreActivity;
//import com.esports.vishal.esportsscoreapplication.DOTA2.CsGoScoreActivity;
import com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Activity;
import com.esports.vishal.esportsscoreapplication.LOL.LolActivity;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView = (CardView) findViewById(R.id.cardview_cs);
        CardView cardViewLol = (CardView) findViewById(R.id.cardview_lol) ;
        CardView cardview_dota_2 = (CardView) findViewById(R.id.cardview_dota2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CsGoScoreActivity.class);
                startActivity(intent);
            }
        });

        cardViewLol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LolActivity.class);
                startActivity(intent);
            }
        });

        cardview_dota_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dota2Activity.class);
                startActivity(intent);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageview_cs);
        ImageView imageViewlol = (ImageView) findViewById(R.id.imageview_lol);
        Picasso.with(imageView.getContext()).load(R.drawable.csgo).resize(dp2px(220),0).into(imageView);
        Picasso.with(imageViewlol.getContext()).load(R.drawable.lol).resize(dp2px(220),0).into(imageViewlol);
    }

    public int dp2px(int dp) {
        WindowManager wm = (WindowManager) this.getBaseContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int) (dp * displaymetrics.density + 0.5f);
    }
}