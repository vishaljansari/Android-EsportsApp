package com.esports.vishal.esportsscoreapplication.DOTA2;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esports.vishal.esportsscoreapplication.R;

import java.util.ArrayList;

/**
 * Created by sagar on 8/4/17.
 */

public class Dota2Adapter extends RecyclerView.Adapter<Dota2Adapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<Dota2Item> dota2ItemArrayList;
    private String[] maindota2data;



    //getIntent().getSerializableExtra("dotaarray");
    public Dota2Adapter(ArrayList<Dota2Item>
                                dota2ItemArrayList, ItemClickListener listener)
    {
        this.dota2ItemArrayList = dota2ItemArrayList;
        this.listener = listener;
    }

    public Dota2Adapter(ArrayList<Dota2Item> dota2ItemArrayList) {
        this.dota2ItemArrayList = dota2ItemArrayList;
    }

    public interface ItemClickListener {

        void onItemClick(int clickedItemIndex);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.dota2_rows, parent, shouldAttachToParentImmediately);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(Dota2Adapter.ItemHolder holder, int position) {


        Dota2Item dota2Item = dota2ItemArrayList.get(position);

        holder.d_dateandtimeofgame.setText("Time : " +dota2Item.getD_dateandtimeofgame());

        holder.d_season_name.setText("Season : "+dota2Item.getD_season_name());
        // holder.team_1_abbreviation("Team : "+dota2Item.getTeam_1_abbreviation());

        //  holder.team_1_abbreviation("Team");
        holder.d_team_1_abbreviation.setText("Team : "+dota2Item.getD_team_1_abbreviation());
    }

    @Override
    public int getItemCount() {
        return dota2ItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView d_dateandtimeofgame;
        public TextView d_season_name;
        public TextView d_team_1_abbreviation;
        public ItemHolder(View itemView) {
            super(itemView);

            d_dateandtimeofgame = (TextView) itemView.findViewById(R.id.d_dateandtimeofgame);
            d_season_name=(TextView)itemView.findViewById(R.id.d_season_name);
            d_team_1_abbreviation=(TextView)itemView.findViewById(R.id.d_team_1_abbreviation);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }


    }

}
