package id.haweje.covid19v1.ui.statistic;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.ui.statistic.activity.SearchData;
import id.haweje.covid19v1.ui.statistic.activity.ShowpieChart;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatistikFragment extends Fragment implements View.OnClickListener {

    //Variable To make Cardview Clickable
    CardView cvSearchData, cvshowPiechart;

    public StatistikFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistik, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Declare Cardview to make Clickable
        cvSearchData = view.findViewById(R.id.cvSearchData);
        cvSearchData.setOnClickListener(this);
        cvshowPiechart = view.findViewById(R.id.cvShowPieChart);
        cvshowPiechart.setOnClickListener(this);
    }


    //Cardview Button Function
    @Override
    public void onClick(View v) {
        Intent moveToActivity;

        switch (v.getId()){
            case R.id.cvSearchData:
                moveToActivity = new Intent(getContext(), SearchData.class);
                startActivity(moveToActivity);
                break;
            case R.id.cvShowPieChart:
                moveToActivity = new Intent(getContext(), ShowpieChart.class);
                startActivity(moveToActivity);
                break;
        }
    }
}
