package com.esports.vishal.esportsscoreapplication.CSGO;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esports.vishal.esportsscoreapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by VISHAL on 8/4/2017.
 */
import android.content.Context;
import android.content.Intent;

public class CsGoAdapter extends RecyclerView.Adapter<CsGoAdapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<CsGoItem> csGoItemArrayList;
    private String[] maincsgodata;

    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");

    String currentDateandTime = format.format(new Date());




    public CsGoAdapter(ArrayList<CsGoItem> csGoItemArrayList, ItemClickListener listener)
    {
        this.csGoItemArrayList = csGoItemArrayList;
        this.listener = listener;
    }

    public CsGoAdapter(ArrayList<CsGoItem> csGoItemArrayList) {
        this.csGoItemArrayList = csGoItemArrayList;
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
    public void onBindViewHolder(CsGoAdapter.ItemHolder holder, int position) {


        CsGoItem csGoItem = csGoItemArrayList.get(position);

      //  holder.dateandtimeofgame.setText("Time : " +csGoItem.getDateandtimeofgame());
        holder.season_name.setText(csGoItem.getSeason_name());
       // holder.team_1_abbreviation("Team : "+csGoItem.getTeam_1_abbreviation());
        holder.dateandtimeofgame.setText(currentDateandTime);
      //  holder.team_1_abbreviation("Team");
        holder.team_1_abbreviation.setText(csGoItem.getTeam_1_abbreviation());
    }
    @Override
    public int getItemCount() {
        return csGoItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView dateandtimeofgame;
        public TextView season_name;
        public TextView team_1_abbreviation;
        Date d = new Date();
        CharSequence s = DateFormat.format("MM-dd-yyyy", d.getTime()).toString();
        public ItemHolder(View itemView) {
            super(itemView);

      //      dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);
            season_name=(TextView)itemView.findViewById(R.id.season_name);
            team_1_abbreviation=(TextView)itemView.findViewById(R.id.team_1_abbreviation);
            dateandtimeofgame=(TextView)itemView.findViewById(R.id.current_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }


    }

    public void setCsGoData(String[] csGoData)
    {
        maincsgodata = csGoData;
        notifyDataSetChanged();
    }
}
