package id.haweje.covid19v1.ui.statistic.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.model.provinsi.Attributes;
import id.haweje.covid19v1.ui.statistic.adapter.recyclerview.ListProvinsiAdapter;
import id.haweje.covid19v1.viewmodel.ProvinsiViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDataIndoFragment extends Fragment {

    private ListProvinsiAdapter listProvinsiAdapter;
    private ProvinsiViewModel provinsiViewModel;


    public SearchDataIndoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_data_indo, container, false);

        //RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.list_rv_indo);
        listProvinsiAdapter = new ListProvinsiAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listProvinsiAdapter);

        //setViewModel to Fragment
        provinsiViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ProvinsiViewModel.class);
        provinsiViewModel.getProvinsiData().observe(getViewLifecycleOwner(), getTodayData);
        provinsiViewModel.SetProvinsiData();

        return view;
    }

    private Observer<ArrayList<Attributes>> getTodayData = new Observer<ArrayList<Attributes>>() {
        @Override
        public void onChanged(ArrayList<Attributes> provinsiModels) {
            if (provinsiModels != null){
                listProvinsiAdapter.setProvinsiModels(provinsiModels);
            }
        }
    };

}
