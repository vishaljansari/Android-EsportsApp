package com.esports.vishal.esportsscoreapplication.LOL;

/**
 * Created by sagar on 8/6/17.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.esports.vishal.esportsscoreapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by VISHAL on 8/4/2017.
 */

public class LolAdapter extends RecyclerView.Adapter<com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemHolder> {

    com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemClickListener listener;
    private ArrayList<LolItem> lolItemArrayList;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TAG = "lolAdapter";





    public LolAdapter(ArrayList<LolItem> lolItemArrayList, com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemClickListener listener)
    {
        this.lolItemArrayList = lolItemArrayList;
        this.listener = listener;
    }

    public LolAdapter(ArrayList<LolItem> lolItemArrayList) {
        this.lolItemArrayList = lolItemArrayList;

    }

    public interface ItemClickListener {

        void onItemClick(int clickedItemIndex);
    }

    @Override
    public com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.lol_rows, parent, shouldAttachToParentImmediately);
        com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemHolder holder = new com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(com.esports.vishal.esportsscoreapplication.LOL.LolAdapter.ItemHolder holder, int position) {


        LolItem lolItem = lolItemArrayList.get(position);

//        try {
//            Date publishedDate = dateFormat.parse(lolItem.getDateandtimeofgame());
////            holder.dateandtimeofgame.setText("Time : " +publishedDate.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        holder.seasonname.setText(lolItem.getSeason_name());
        holder.team_1_name.setText(lolItem.getTeam_1_name());
        holder.team_2_name.setText(lolItem.getTeam_2_name());
        //   holder.tournament_type.setText("tournament name:" +lolItem.getTournament_type());
        holder.team_1_abbreviation.setText(lolItem.getTeam_1_abbreviation());
        holder.team_2_abbreviation.setText(lolItem.getTeam_2_abbreviation());
///        holder.team_1_country_code.setText(lolItem.getTeam_1_country_code());
        ///       holder.team_2_country_code.setText(lolItem.getTeam_2_country_code());
//        holder.home_score.setText("Home score:" +lolItem.getHome_score());
        ///   holder.away_score.setText("Away score:" +lolItem.getAway_score());
        holder.team_1_home_score_period.setText(lolItem.getTeam_1_home_score_period());
        holder.team_2_home_score_period.setText(lolItem.getTeam_2_home_score_period());

        holder.team_1_home_score.setText(lolItem.getTeam_1_home_score());
        holder.team_2_home_score.setText(lolItem.getTeam_2_home_score());

    }

    @Override
    public int getItemCount() {
        return lolItemArrayList.size();
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


        public ItemHolder(View itemView) {
            super(itemView);

            //   dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);
            seasonname = (TextView) itemView.findViewById(R.id.seasonname);
            team_1_name = (TextView) itemView.findViewById(R.id.team_1_name);
            team_2_name = (TextView) itemView.findViewById(R.id.team_2_name);
            //   tournament_type = (TextView) itemView.findViewById(R.id.tournament_type);
            team_1_abbreviation = (TextView) itemView.findViewById(R.id.team_1_abbreviation);
            team_2_abbreviation = (TextView) itemView.findViewById(R.id.team_2_abbreviation);
            //    home_score = (TextView) itemView.findViewById(R.id.home_score);
            //    away_score = (TextView) itemView.findViewById(R.id.away_score);
            //    button = (Button) itemView.findViewById(R.id.button) ;
            //    team_1_country_code = (TextView) itemView.findViewById(R.id.team_1_country_code);
            ///    team_2_country_code = (TextView) itemView.findViewById(R.id.team_2_country_code);

            team_1_home_score_period = (TextView) itemView.findViewById(R.id.team_1_home_score_period);
            team_2_home_score_period = (TextView) itemView.findViewById(R.id.team_2_home_score_period);

            team_1_home_score = (TextView) itemView.findViewById(R.id.team_1_home_score);
            team_2_home_score = (TextView) itemView.findViewById(R.id.team_2_home_score);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }
    }
}
