package com.esports.vishal.esportsscoreapplication.DOTA2;

/**
 * Created by sagar on 8/8/17.
 */


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.esports.vishal.esportsscoreapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by VISHAL on 8/4/2017.
 */

public class Dota2Adapter extends RecyclerView.Adapter<Dota2Adapter.ItemHolder> {

    com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemClickListener listener;
    private ArrayList<Dota2Item> dota2ItemArrayList;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TAG = "dota2Adapter";

    public  String date;



    public Dota2Adapter(ArrayList<Dota2Item> dota2ItemArrayList, Dota2Adapter.ItemClickListener listener)
    {
        this.dota2ItemArrayList = dota2ItemArrayList;
        this.listener = listener;
    }

    public Dota2Adapter(ArrayList<Dota2Item> dota2ItemArrayList) {
        this.dota2ItemArrayList = dota2ItemArrayList;
        // cs = new CsGoScoreActivity();
    }

    public interface ItemClickListener {

        void onItemClick(int clickedItemIndex);
    }

    @Override
    public com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.dota2_rows, parent, shouldAttachToParentImmediately);
        com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemHolder holder = new com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final Dota2Adapter.ItemHolder holder, int position) {


        Dota2Item dota2Item = dota2ItemArrayList.get(position);



        holder.twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = holder.getAdapterPosition();
                Log.d(TAG, "id is>>>>>>>" + id);
                String tname = dota2ItemArrayList.get(id).getSeason_name();
                tname = tname.replaceAll("[^a-zA-Z0-9]", "");
                String url = "https://twitter.com/hashtag/" + tname + "?src=hash";
                Log.d(TAG, "url is>>>>>>" + url);
                //openWebPage(url);
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                v.getContext().startActivity(intent);
            }
        });


        //String tname = csGoItemArrayList.get(id).getSeason_name();
        holder.seasonname.setText(dota2Item.getSeason_name());
//        holder.team_1_name.setText(dota2Item.getTeam_1_name());
  //      holder.team_2_name.setText(dota2Item.getTeam_2_name());
        //   holder.tournament_type.setText("tournament name:" +dota2Item.getTournament_type());
        holder.team_1_abbreviation.setText(dota2Item.getTeam_1_abbreviation());
        holder.team_2_abbreviation.setText(dota2Item.getTeam_2_abbreviation());

        holder.team_1_home_score_period.setText(dota2Item.getTeam_1_home_score_period());
        holder.team_2_home_score_period.setText(dota2Item.getTeam_2_home_score_period());

        holder.team_1_qualifier.setText(dota2Item.getTeam_1_qualifier());
        holder.team_2_qualifier.setText(dota2Item.getTeam_2_qualifier());
      //  holder.team_1_home_score.setText(dota2Item.getTeam_1_home_score());
      // holder.team_2_home_score.setText(dota2Item.getTeam_2_home_score());


    }

    @Override
    public int getItemCount() {
        return dota2ItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView dateandtimeofgame;
        public TextView seasonname;
        public TextView team_1_name;
        public TextView team_2_name;
        public TextView tournament_type;
        public TextView team_1_abbreviation;
        public TextView team_2_abbreviation;
        public TextView home_score;
        public TextView away_score;
        public Button button;
        public  TextView team_1_country_code;
        public  TextView team_2_country_code;
        public TextView team_1_home_score;
        public TextView team_2_home_score;
        public TextView team_1_home_score_period;
        public TextView team_2_home_score_period;
        public TextView team_1_qualifier;
        public TextView team_2_qualifier;


        public ImageButton twitterButton;
        public  ItemHolder(final View itemView) {
            super(itemView);

            TextView printDate;


            //   dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);
            seasonname = (TextView) itemView.findViewById(R.id.seasonname);
        //    team_1_name = (TextView) itemView.findViewById(R.id.team_1_name);//   tournament_type = (TextView) itemView.findViewById(R.id.tournament_type);
            team_1_qualifier = (TextView) itemView.findViewById(R.id.team_1_qualifier);
            team_2_qualifier = (TextView) itemView.findViewById(R.id.team_2_qualifier);
            team_1_abbreviation = (TextView) itemView.findViewById(R.id.team_1_abbreviation);
            team_2_abbreviation = (TextView) itemView.findViewById(R.id.team_2_abbreviation);
            twitterButton = (ImageButton) itemView.findViewById(R.id.tweeter_button) ;
            team_1_home_score_period = (TextView) itemView.findViewById(R.id.team_1_home_score_period);
            team_2_home_score_period = (TextView) itemView.findViewById(R.id.team_2_home_score_period);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }
    }
}
