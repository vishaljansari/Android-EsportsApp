package com.esports.vishal.esportsscoreapplication.CSGO;

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
 * Created by VISHAL on 8/4/2017.
 */
import android.content.Context;
import android.content.Intent;

public class CsGoAdapter extends RecyclerView.Adapter<CsGoAdapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<CsGoItem> csGoItemArrayList;
    private String[] maincsgodata;


 //   ArrayList<CsGoItem> filelist =  (ArrayList<CsGoItem>)getIntent().getSerializableExtra("csArray");


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

        holder.dateandtimeofgame.setText("Time : " +csGoItem.getDateandtimeofgame());
    }

    @Override
    public int getItemCount() {
        return csGoItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView dateandtimeofgame;

        public ItemHolder(View itemView) {
            super(itemView);

            dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);

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
