package com.esports.vishal.esportsscoreapplication.CSGO;

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
public class CsGoAdapter extends RecyclerView.Adapter<CsGoAdapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<CsGoItem> csGoItemArrayList;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TAG = "csgoAdapter";
    public  String date;




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

        void onItemClick(int clickedItemIndex , String date);
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
    public void onBindViewHolder(final CsGoAdapter.ItemHolder holder, int position) {


        CsGoItem csGoItem = csGoItemArrayList.get(position);


        holder.twitterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int id = holder.getAdapterPosition();
                Log.d(TAG, "id is>>>>>>>"+id);
                String tname = csGoItemArrayList.get(id).getSeason_name();
                tname = tname.replaceAll("[^a-zA-Z0-9]","");
                String url = "https://twitter.com/hashtag/"+tname+"?src=hash";
                Log.d(TAG, "url is>>>>>>"+url);
                //openWebPage(url);
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                v.getContext().startActivity(intent);
            }
        });

//        try {
//            Date publishedDate = dateFormat.parse(csGoItem.getDateandtimeofgame());
////            holder.dateandtimeofgame.setText("Time : " +publishedDate.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        holder.seasonname.setText(csGoItem.getSeason_name());
        //   holder.team_1_name.setText(csGoItem.getTeam_1_name());
        //   holder.team_2_name.setText(csGoItem.getTeam_2_name());
        //    holder.tournament_type.setText(csGoItem.getTournament_type());
        holder.team_1_abbreviation.setText(csGoItem.getTeam_1_abbreviation());
        holder.team_2_abbreviation.setText(csGoItem.getTeam_2_abbreviation());
///        holder.team_1_country_code.setText(csGoItem.getTeam_1_country_code());
        ///       holder.team_2_country_code.setText(csGoItem.getTeam_2_country_code());
//        holder.home_score.setText("Home score:" +csGoItem.getHome_score());
        ///   holder.away_score.setText("Away score:" +csGoItem.getAway_score());
        holder.team_1_home_score_period.setText(csGoItem.getTeam_1_home_score_period());
        holder.team_2_home_score_period.setText(csGoItem.getTeam_2_home_score_period());

        holder.team_1_qualifier.setText(csGoItem.getTeam_1_qualifier());
        holder.team_2_qualifier.setText(csGoItem.getTeam_2_qualifier());

        //       holder.printDate.setText(date);
        //    holder.team_1_home_score.setText(csGoItem.getTeam_1_home_score());
        //    holder.team_2_home_score.setText(csGoItem.getTeam_2_home_score());

    }


    @Override
    public int getItemCount() {
        return csGoItemArrayList.size();
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
        public TextView team_1_qualifier;
        public TextView team_2_qualifier;
        public  TextView team_1_country_code;
        public  TextView team_2_country_code;
        public TextView team_1_home_score;
        public TextView team_2_home_score;
        public TextView team_1_home_score_period;
        public TextView team_2_home_score_period;
        public ImageButton twitterButton;


        TextView printDate;


        public ItemHolder(final View itemView) {
            super(itemView);

            //   dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);
            seasonname = (TextView) itemView.findViewById(R.id.seasonname);
            //     team_1_name = (TextView) itemView.findViewById(R.id.team_1_name);
            //     team_2_name = (TextView) itemView.findViewById(R.id.team_2_name);
            //      tournament_type = (TextView) itemView.findViewById(R.id.tournament_round_type);
            team_1_qualifier = (TextView) itemView.findViewById(R.id.team_1_qualifier);
            team_2_qualifier = (TextView) itemView.findViewById(R.id.team_2_qualifier);
            team_1_abbreviation = (TextView) itemView.findViewById(R.id.team_1_abbreviation);
            team_2_abbreviation = (TextView) itemView.findViewById(R.id.team_2_abbreviation);
            twitterButton = (ImageButton) itemView.findViewById(R.id.tweeter_button) ;
            //     printDate = (TextView) itemView.findViewById(R.id.date);
            //    home_score = (TextView) itemView.findViewById(R.id.home_score);
            //    away_score = (TextView) itemView.findViewById(R.id.away_score);
            //    button = (Button) itemView.findViewById(R.id.button) ;
            //    team_1_country_code = (TextView) itemView.findViewById(R.id.team_1_country_code);
            ///    team_2_country_code = (TextView) itemView.findViewById(R.id.team_2_country_code);

            team_1_home_score_period = (TextView) itemView.findViewById(R.id.team_1_home_score_period);
            team_2_home_score_period = (TextView) itemView.findViewById(R.id.team_2_home_score_period);


            //    team_1_home_score = (TextView) itemView.findViewById(R.id.team_1_home_score);
            //     team_2_home_score = (TextView) itemView.findViewById(R.id.team_2_home_score);

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position,date);
        }
    }




}
