package com.esports.vishal.esportsscoreapplication.LOL;

/**
 * Created by sagar on 8/6/17.
 */
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

public class LolNetworkUtility {

    static ArrayList<LolItem> lolItems = new ArrayList<LolItem>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date());

    String formatter = new SimpleDateFormat().toString();

    private static String LOL_BASE_URL = "https://api.sportradar.us/lol-t1/us/schedules/2017-08-03/results.json";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_KEY = "47fe38ypxypt6d2s9snt9n7m";

    public static URL makeURL(){

        Uri uri = Uri.parse(LOL_BASE_URL).buildUpon()
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

    public static ArrayList<LolItem> parseJSON(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        //JSONArray jsonA=jsonObject.getJSONArray("sport_event").getJSONArray("competitor");
        //     Log.d("Array length: ", String.valueOf(jsonArray.length()));
        for(int i=0; i <= jsonArray.length()-1; i++)
        {
            JSONObject mainObject = jsonArray.getJSONObject(i);

            String l_dateandtimeofgame = mainObject.getJSONObject("sport_event").getString("scheduled");
            String l_season_name=mainObject.getJSONObject("sport_event").getJSONObject("tournament").getString("name");
            //  for(int j=0;j<=jsonA.length()-1;j++)

            JSONArray l_team_1_abbreviations = mainObject.getJSONObject("sport_event").getJSONArray("competitors");
            JSONObject jobj = l_team_1_abbreviations.getJSONObject(1);
            String l_team_1_abbreviation = jobj.getString("name");


            //   String team_1_abbreviation = (String) mainObject.getJSONObject("sport_event").getJSONObject("competitors").get("name");
            LolItem lolItem = new LolItem(l_dateandtimeofgame,l_season_name, l_team_1_abbreviation);
            lolItems.add(lolItem);
            //    Log.d("got it",dateandtimeofgame);
        }
        return lolItems;
    }

}