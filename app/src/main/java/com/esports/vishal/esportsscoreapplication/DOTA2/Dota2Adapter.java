package com.esports.vishal.esportsscoreapplication.DOTA2;

/**
 * Created by sagar on 8/8/17.
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

public class Dota2Adapter extends RecyclerView.Adapter<com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemHolder> {

    com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemClickListener listener;
    private ArrayList<Dota2Item> Dota2ItemArrayList;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TAG = "dota2Adapter";





    public Dota2Adapter(ArrayList<Dota2Item> dota2ItemArrayList, com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemClickListener listener)
    {
        this.Dota2ItemArrayList = dota2ItemArrayList;
        this.listener = listener;
    }

    public Dota2Adapter(ArrayList<Dota2Item> dota2ItemArrayList) {
        this.Dota2ItemArrayList = dota2ItemArrayList;

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
    public void onBindViewHolder(com.esports.vishal.esportsscoreapplication.DOTA2.Dota2Adapter.ItemHolder holder, int position) {


        Dota2Item dota2Item = Dota2ItemArrayList.get(position);

//        try {
//            Date publishedDate = dateFormat.parse(dota2Item.getDateandtimeofgame());
////            holder.dateandtimeofgame.setText("Time : " +publishedDate.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        holder.seasonname.setText(dota2Item.getSeason_name());
        holder.team_1_name.setText(dota2Item.getTeam_1_name());
        holder.team_2_name.setText(dota2Item.getTeam_2_name());
        //   holder.tournament_type.setText("tournament name:" +dota2Item.getTournament_type());
        holder.team_1_abbreviation.setText(dota2Item.getTeam_1_abbreviation());
        holder.team_2_abbreviation.setText(dota2Item.getTeam_2_abbreviation());
///        holder.team_1_country_code.setText(dota2Item.getTeam_1_country_code());
        ///       holder.team_2_country_code.setText(dota2Item.getTeam_2_country_code());
//        holder.home_score.setText("Home score:" +dota2Item.getHome_score());
        ///   holder.away_score.setText("Away score:" +dota2Item.getAway_score());
        holder.team_1_home_score_period.setText(dota2Item.getTeam_1_home_score_period());
        holder.team_2_home_score_period.setText(dota2Item.getTeam_2_home_score_period());

        holder.team_1_home_score.setText(dota2Item.getTeam_1_home_score());
        holder.team_2_home_score.setText(dota2Item.getTeam_2_home_score());

    }

    @Override
    public int getItemCount() {
        return Dota2ItemArrayList.size();
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
