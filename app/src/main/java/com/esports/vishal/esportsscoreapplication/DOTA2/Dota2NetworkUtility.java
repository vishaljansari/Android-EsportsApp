package com.esports.vishal.esportsscoreapplication.DOTA2;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by sagar on 8/8/17.
 */

public class Dota2NetworkUtility {

    private final static String TAG= "dota2net";

    static ArrayList<Dota2Item> dota2Items = new ArrayList<Dota2Item>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date());

    String formatter = new SimpleDateFormat().toString();

    private static String DOTA2_BASE_URL = "https://api.sportradar.us/dota2-t1/us/schedules/2017-08-07/results.json";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_KEY = "rqu5v6psgjgmx3ekxgffmwu8";


    public static URL makeURL(){
        Uri uri = Uri.parse(DOTA2_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARAM,API_KEY)
                .build();


        URL url = null;
        try{
            url = new URL(uri.toString());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        try{
            InputStream in = urlConnection.getInputStream();
            Scanner input = new Scanner(in);

            input.useDelimiter("\\A");
            return (input.hasNext())? input.next():null;

        }finally{
            urlConnection.disconnect();
        }
    }

    public static ArrayList<Dota2Item> parseJSON(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        Log.d("Array length: ", String.valueOf(jsonArray.length()));
        for(int i=0; i < jsonArray.length() ; i++)
        {
            JSONObject mainObject = jsonArray.getJSONObject(i);

            String dateandtimeofgame = mainObject.getJSONObject("sport_event").getString("scheduled");

            String season_name = mainObject.getJSONObject("sport_event").getJSONObject("tournament").getString("name");

            JSONArray competitors = mainObject.getJSONObject("sport_event").getJSONArray("competitors");
            JSONObject team_1 = competitors.getJSONObject(0);
            String team_1_name = team_1.getString("name");
            JSONObject team_2 = competitors.getJSONObject(1);
            String team_2_name = team_2.getString("name");

            String team_1_abbreviation = team_1.getString("abbreviation");
            String team_2_abbreviation = team_2.getString("abbreviation");

            String tournament_type = mainObject.getJSONObject("sport_event").getJSONObject("tournament_round").getString("type");
            String tournament_name = mainObject.getJSONObject("sport_event").getJSONObject("tournament").getString("name");

            String team_1_qualifier = team_1.getString("qualifier");
            String team_2_qualifier = team_2.getString("qualifier");

//            String team_1_country_code = team_1.getString("country_code");
//            String team_2_country_code = team_2.getString("country_code");

            String sport_event_status = mainObject.getJSONObject("sport_event_status").getString("match_status");

            String team_1_home_score = "N/A";
            String team_2_home_score = "N/A";
            String team_1_home_score_period = "N/A";
            String team_2_home_score_period = "N/A";

            if(sport_event_status.equals("ended")){
                team_1_home_score = mainObject.getJSONObject("sport_event_status").getString("home_score");
                team_2_home_score = mainObject.getJSONObject("sport_event_status").getString("away_score");

                JSONArray period_score = mainObject.getJSONObject("sport_event_status").getJSONArray("period_scores");
                JSONObject period_obj = period_score.getJSONObject(0);
                team_1_home_score_period = period_obj.getString("home_score");
                team_2_home_score_period = period_obj.getString("away_score");
            }

            Dota2Item dota2Item = new Dota2Item(dateandtimeofgame,season_name,team_1_name,team_2_name,tournament_type,tournament_name,team_1_abbreviation,team_2_abbreviation,team_1_qualifier,team_2_qualifier,team_1_home_score,team_2_home_score,team_1_home_score_period,team_2_home_score_period);
            dota2Items.add(dota2Item);
            //    Log.d("got it",dateandtimeofgame);
        }
        return dota2Items;
    }

}


