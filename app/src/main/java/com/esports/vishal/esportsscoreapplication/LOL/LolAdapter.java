package com.esports.vishal.esportsscoreapplication.LOL;

/**
 * Created by sagar on 8/4/17.
 */


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

import android.content.Context;
import android.content.Intent;

public class LolAdapter extends RecyclerView.Adapter<LolAdapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<LolItem> lolItemArrayList;
    private String[] mainloldata;

    public LolAdapter(ArrayList<LolItem> lolItemArrayList, ItemClickListener listener)
    {
        this.lolItemArrayList = lolItemArrayList;
        this.listener = listener;
    }

    public LolAdapter(ArrayList<LolItem> lolItemArrayList) {
        this.lolItemArrayList = lolItemArrayList;
        // cs = new CsGoScoreActivity();
    }

    public interface ItemClickListener {

        void onItemClick(int clickedItemIndex);
    }
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.csgo_rows, parent, shouldAttachToParentImmediately);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(LolAdapter.ItemHolder holder, int position) {


        LolItem lolItem = lolItemArrayList.get(position);

        holder.l_dateandtimeofgame.setText("Time : " +lolItem.getL_dateandtimeofgame());
        holder.l_season_name.setText("Season : "+lolItem.getL_season_name());
        holder.l_team_1_abbreviation.setText("Team : "+lolItem.getL_team_1_abbreviation());
    }
    @Override
    public int getItemCount() {
        return lolItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView l_dateandtimeofgame;
        public TextView l_season_name;
        public TextView l_team_1_abbreviation;
        public ItemHolder(View itemView) {
            super(itemView);

            l_dateandtimeofgame = (TextView) itemView.findViewById(R.id.l_dateandtimeofgame);
            l_season_name=(TextView)itemView.findViewById(R.id.l_seasonname);
            l_team_1_abbreviation=(TextView)itemView.findViewById(R.id.l_team_1_abbreviation);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }

    }

}

