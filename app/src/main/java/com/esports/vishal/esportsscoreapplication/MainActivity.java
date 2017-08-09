package com.esports.vishal.esportsscoreapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.esports.vishal.esportsscoreapplication.CSGO.CsGoScoreActivity;
import com.esports.vishal.esportsscoreapplication.DOTA2.Dota2ScoreActivity;
import com.esports.vishal.esportsscoreapplication.LOL.LolScoreActivity;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView = (CardView) findViewById(R.id.cardview_cs);
        CardView cardViewLol = (CardView) findViewById(R.id.cardview_lol) ;
        CardView cardviewdota = (CardView) findViewById(R.id.cardview_dota);
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
                Intent intent = new Intent(MainActivity.this, LolScoreActivity.class);
                startActivity(intent);
            }
        });

        cardviewdota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Dota2ScoreActivity.class);
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