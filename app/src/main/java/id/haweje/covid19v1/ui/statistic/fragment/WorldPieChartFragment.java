package id.haweje.covid19v1.ui.statistic.fragment;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.viewmodel.WorldViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorldPieChartFragment extends Fragment {


    public WorldPieChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_world_pie_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Set ProgressDialog
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang Menampilkan Data");
        progressDialog.show();

        final PieChart pieChart = view.findViewById(R.id.worldwidePieChart);
        WorldViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(WorldViewModel.class);
        viewModel.setSummaryWorld();
        viewModel.getSummaryWorld().observe(getViewLifecycleOwner(), world -> {
            progressDialog.dismiss();
            //Add data to Piechart
            List<PieEntry> pieEntries = new ArrayList<>();
            pieEntries.add(new PieEntry(world.getWorldConfirmed().getValue(),"Positif"));
            pieEntries.add(new PieEntry(world.getWorldRecovered().getValue(),"Sembuh"));
            pieEntries.add(new PieEntry(world.getWorldDeaths().getValue(),"Meninggal"));

            //Set Color for PieChart
            PieDataSet pieDataSet = new PieDataSet(pieEntries,"Dari Covid-19");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(14);

            //set Description for LastUpdate
            Description description = new Description();
            description.setText("Update Terakhir" + " : " + world.getLastUpdate());
            description.setTextColor(Color.WHITE);

            //Set Legend PieChart
            Legend legend = pieChart.getLegend();
            legend.setTextColor(Color.WHITE);
            legend.setTextSize(12);
            legend.setForm(Legend.LegendForm.SQUARE);

            //Set Data at PieChart
            PieData pieData = new PieData(pieDataSet);
            pieChart.setVisibility(View.VISIBLE);
            pieChart.animateXY(2000,2000);
            pieChart.setDescription(description);
            pieChart.setHoleRadius(60);
            pieChart.setRotationAngle(130);
            pieChart.setHoleColor(Color.TRANSPARENT);
            pieChart.setData(pieData);
        });

    }
}
