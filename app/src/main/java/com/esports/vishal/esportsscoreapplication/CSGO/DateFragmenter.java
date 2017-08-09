package com.esports.vishal.esportsscoreapplication.CSGO;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.esports.vishal.esportsscoreapplication.R;

import java.util.Calendar;

/**
 * Created by sagar on 8/4/17.
 */

public class DateFragmenter extends DialogFragment {
    private EditText toDo;
    private DatePicker dp;
    private Button add;




    private ArrayAdapter<CharSequence> spinnerAdapter;
    private final String TAG = "addtodofragment";

    public DateFragmenter() {
    }



    public interface OnDialogCloseListener {
        void closeDialog(int year, int month, int day, String description, String category);

        void closeDialog(int year, int month, int dayOfMonth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datepick, container, false);

      //  toDo = (EditText) view.findViewById(R.id.toDo);

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

                activity.closeDialog(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());

                Log.d(TAG, String.valueOf(dp.getYear()));
                DateFragmenter.this.dismiss();

            }
        });

        return view;
    }
}
