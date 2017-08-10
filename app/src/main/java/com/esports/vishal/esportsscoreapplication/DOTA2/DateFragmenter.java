package com.esports.vishal.esportsscoreapplication.DOTA2;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.esports.vishal.esportsscoreapplication.R;

import java.util.Calendar;

/**
 * Created by sagar on 8/9/17.
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
                com.esports.vishal.esportsscoreapplication.DOTA2.DateFragmenter.OnDialogCloseListener activity = (com.esports.vishal.esportsscoreapplication.DOTA2.DateFragmenter.OnDialogCloseListener) getActivity();

                activity.closeDialog(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                com.esports.vishal.esportsscoreapplication.DOTA2.DateFragmenter.this.dismiss();
            }
        });

        return view;
    }
}
