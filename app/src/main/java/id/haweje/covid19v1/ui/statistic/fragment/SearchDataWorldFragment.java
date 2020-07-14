package id.haweje.covid19v1.ui.statistic.fragment;


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
import id.haweje.covid19v1.model.negara.AttributesNegara;
import id.haweje.covid19v1.ui.statistic.adapter.recyclerview.ListNationAdapter;
import id.haweje.covid19v1.viewmodel.NegaraViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDataWorldFragment extends Fragment {

    private ListNationAdapter adapter;
    private NegaraViewModel negaraViewModel;
    private ArrayList<AttributesNegara> nationModels;
    public SearchDataWorldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_data_world, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list_rv_world);
        adapter = new ListNationAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        negaraViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NegaraViewModel.class);
        negaraViewModel.getNationListData().observe(getViewLifecycleOwner(), getTodayData);
        negaraViewModel.setNationData();

        return view;
    }

    private Observer<ArrayList<AttributesNegara>> getTodayData = new Observer<ArrayList<AttributesNegara>>() {
        @Override
        public void onChanged(ArrayList<AttributesNegara> negaraModels) {
            if (negaraModels != null){
                adapter.setNationsModels(negaraModels);
            }
        }
    };

}
