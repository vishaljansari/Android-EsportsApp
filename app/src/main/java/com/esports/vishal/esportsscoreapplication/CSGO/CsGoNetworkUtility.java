package com.esports.vishal.esportsscoreapplication.CSGO;

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
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by VISHAL on 7/24/2017.
 */

public class CsGoNetworkUtility {

    private final static String TAG= "csgonet";

    static ArrayList<CsGoItem> csGoItems = new ArrayList<CsGoItem>();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    static String currentDate = sdf.format(new Date());

    String formatter = new SimpleDateFormat().toString();

    private static String CSGO_BASE_URL = "";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_KEY = "huzmvbk8saf6brdfkwecc2ve";



    public static URL makeURL(String date){
        if(date==null)
            date = ""+"2017-08-08";
        CSGO_BASE_URL = "https://api.sportradar.us/csgo-t1/us/schedules/"+date+"/results.json";
        Uri uri = Uri.parse(CSGO_BASE_URL).buildUpon()
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

    public static ArrayList<CsGoItem> parseJSON(String json) throws JSONException {

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


            CsGoItem csGoItem = new CsGoItem(dateandtimeofgame,season_name,team_1_name,team_2_name,tournament_type,tournament_name,team_1_abbreviation,team_2_abbreviation,team_1_qualifier,team_2_qualifier,team_1_home_score,team_2_home_score,team_1_home_score_period,team_2_home_score_period);
            //csGoItem = null;
            csGoItems.add(csGoItem);
        }
        return csGoItems;
    }

}// https://api.sportradar.us/csgo-t1/us/schedules/2016-06-05/results.json?api_key={your_api_key}