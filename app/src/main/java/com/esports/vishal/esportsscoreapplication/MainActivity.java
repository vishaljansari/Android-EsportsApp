package com.esports.vishal.esportsscoreapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

     //   private static int SPLASH_TIMEOUT = 3000;
     //   private TextView textView;
      //  private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    textView = (TextView) findViewById(R.id.csgo_fetch_data);
     //   loading = (ProgressBar) findViewById(R.id.progressBar);
       // fetchURL();

        CardView cardView = (CardView) findViewById(R.id.cardview_cs);
        CardView cardViewLol = (CardView) findViewById(R.id.cardview_lol) ;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SportsScoreActivity.class);
                startActivity(intent);
            }
        });
        cardViewLol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("","Cardview lol called");
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageview_cs);
        ImageView imageViewlol = (ImageView) findViewById(R.id.imageview_lol);
        Picasso.with(imageView.getContext()).load(R.drawable.csgo).resize(dp2px(220),0).into(imageView);
        Picasso.with(imageViewlol.getContext()).load(R.drawable.lol).resize(dp2px(220), 0).into(imageViewlol);

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

    class EsportsDataTask extends AsyncTask<URL,Void,String> {

        @Override
         protected void onPreExecute()
            {
                super.onPreExecute();
             //   loading.setVisibility(View.VISIBLE);
            }

        @Override
        protected String doInBackground(URL... urls) {
            try {

                return NetworkUtils.getResponseFromHttpUrl(urls[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String value) {
            super.onPostExecute(value);
            //     textView.setText(value);
         //   loading.setVisibility(View.GONE);
        }



}