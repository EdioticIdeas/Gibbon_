package com.ideotic.edioticideas.gibbon;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Student_Attandence extends Fragment {

    private PieChart pieChart;
    TextView pr,ab,ho;
    View view;
    ServerDatabase database;

    public Fragment_Student_Attandence() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =  inflater.inflate(R.layout.fragment_fragment__student__attandence, container, false);

        database = new ServerDatabase();
        database.getPieData();
        pieChart = (PieChart)view.findViewById(R.id.student_pie_attendance);
        createPieChart();
        init();
        return view;
    }

    public void createPieChart(){
        DashboardActivity act = new DashboardActivity();
        PieData data = act.getPieData();
        pieChart.setData(data);
        // configure pie chart
        pieChart.animateXY(3000,3000);
        pieChart.setCenterText("Your Attendance");
        pieChart.setDescriptionColor(Color.parseColor("#2a363b"));
        pieChart.setCenterTextColor(Color.parseColor("#ffffff"));
        pieChart.setHoleColor(Color.parseColor("#2a363b"));
        pieChart.getLegend().setEnabled(false);
        pieChart.setUsePercentValues(true);
        pieChart.setHoleRadius(80);
        pieChart.invalidate();
    }

    public void init(){
        ab = (TextView)view.findViewById(R.id.textView_absent_attendance);
        pr = (TextView)view.findViewById(R.id.textView_present_attendance);
        ho = (TextView)view.findViewById(R.id.textView_holidays);
        ab.setText(String.valueOf(database.absent));
        pr.setText(String.valueOf(database.present));
        ho.setText(String.valueOf(database.holidays));
    }

}
