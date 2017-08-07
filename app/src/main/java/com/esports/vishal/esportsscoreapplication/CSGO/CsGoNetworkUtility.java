package com.esports.vishal.esportsscoreapplication.CSGO;

import android.net.Uri;
import android.text.format.DateFormat;
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
 * Created by VISHAL on 7/24/2017.
 */

public class CsGoNetworkUtility {

    static ArrayList<CsGoItem> csGoItems = new ArrayList<CsGoItem>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date());

    Date d = new Date();
    CharSequence s = DateFormat.format("yyyy-MM-dd hh:mm:ss", d.getTime());

    String formatter = new SimpleDateFormat().toString();

    private static String CSGO_BASE_URL = "https://api.sportradar.us/csgo-t1/us/schedules/2017-08-03/results.json";
    private static final String API_KEY_PARAM = "api_key";
        private static final String API_KEY = "29qbv2sgm6pendyxuy9fmdkg";


    public static URL makeURL(){

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
        //JSONArray jsonA=jsonObject.getJSONArray("sport_event").getJSONArray("competitor");
   //     Log.d("Array length: ", String.valueOf(jsonArray.length()));
        for(int i=0; i <= jsonArray.length()-1; i++)
        {
            JSONObject mainObject = jsonArray.getJSONObject(i);

            String dateandtimeofgame = mainObject.getJSONObject("sport_event").getString("scheduled");
            String season_name=mainObject.getJSONObject("sport_event").getJSONObject("tournament").getString("name");
          //  for(int j=0;j<=jsonA.length()-1;j++)

            JSONArray team_1_abbreviations = mainObject.getJSONObject("sport_event").getJSONArray("competitors");
            JSONObject jobj = team_1_abbreviations.getJSONObject(1);
            String team_1_abbreviation = jobj.getString("name");


         //   String team_1_abbreviation = (String) mainObject.getJSONObject("sport_event").getJSONObject("competitors").get("name");
            CsGoItem csGoItem = new CsGoItem(dateandtimeofgame,season_name, team_1_abbreviation);
            csGoItems.add(csGoItem);
        //    Log.d("got it",dateandtimeofgame);
        }
        return csGoItems;
    }

}
// https://api.sportradar.us/csgo-t1/us/schedules/2016-06-05/results.json?api_key={your_api_key}