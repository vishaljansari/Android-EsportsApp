package com.esports.vishal.esportsscoreapplication.CSGO;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.esports.vishal.esportsscoreapplication.R;

import java.util.Calendar;

/**
 * Created by sagar on 8/4/17.
 */

public class DateFragmenter extends DialogFragment {
    private DatePicker dp;
    private Button add;
    private final String TAG = "addtodofragment";

    public DateFragmenter() {
    }

    public interface OnDialogCloseListener {
        void closeDialog(int year, int month, int day);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datepick, container, false);


        dp = (DatePicker) view.findViewById(R.id.datePicker);

        add = (Button) view.findViewById(R.id.add);



        final Calendar c = Calendar.getInstance();

        final int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int day = c.get(Calendar.DAY_OF_MONTH);

        dp.updateDate(year, month, day);

        add.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                OnDialogCloseListener activity = (OnDialogCloseListener) getActivity();

                Log.d(TAG, ""+dp.getYear());
                String d = "";
                if(dp.getDayOfMonth()<=9){
                    d="0"+dp.getDayOfMonth();
                }
                else {
                    d=""+dp.getDayOfMonth();
                }
                String m = "";
                if(dp.getMonth()<=9){
                    m="0"+dp.getMonth();
                }
                else {
                    m=""+dp.getDayOfMonth();
                }
                String date = ""+dp.getYear()+"-"+m+"-"+d;
                Log.d(TAG, "Date is>>>>>>>>>>>>"+date);

                activity.closeDialog(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                DateFragmenter.this.dismiss();
                Intent intent = new Intent(getActivity(), CsGoScoreActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });

        return view;
    }
    }
