package id.haweje.covid19v1.ui.home;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.ui.home.activity.ContactActivity;
import id.haweje.covid19v1.ui.home.activity.HospitalsActivity;
import id.haweje.covid19v1.viewmodel.IndonesiaViewModel;
import id.haweje.covid19v1.viewmodel.WorldViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    //Variable to put data in cardview World Covid19 Data
    private TextView tvConfirmedWorld, tvRecoveredWorld, tvDeathWorld;

    //Variable to put data in cardview Indonesia Covid19 Data
    private TextView tvConfirmedIndonesia, tvRecoveredIndonesia, tvDeathIndonesia;

    //Variable to make Cardview Clickable
    private CardView cvHospitals, cvContacs;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ProgressDialog
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang Menampilkan Data");
        progressDialog.show();

        //Show Covid Data for Indonesia Country
        tvConfirmedIndonesia = view.findViewById(R.id.last_confirmed);
        tvRecoveredIndonesia = view.findViewById(R.id.last_recover);
        tvDeathIndonesia = view.findViewById(R.id.last_death);
        final IndonesiaViewModel indonesiaViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(IndonesiaViewModel.class);
        indonesiaViewModel.setIndonesiaData();
        indonesiaViewModel.getIndonesiaData().observe(getViewLifecycleOwner(), indonesia -> {
            progressDialog.dismiss();
            tvConfirmedIndonesia.setText(String.valueOf(indonesia.getIdnConfirmed().getValue()));
            tvDeathIndonesia.setText(String.valueOf(indonesia.getIdnDeaths().getValue()));
            tvRecoveredIndonesia.setText(String.valueOf(indonesia.getIdnRecovered().getValue()));
        });

        //Show Covid Data for Worldwide
        tvConfirmedWorld = view.findViewById(R.id.last_confirmed_world);
        tvRecoveredWorld = view.findViewById(R.id.last_recover_world);
        tvDeathWorld = view.findViewById(R.id.last_death_world);
        final WorldViewModel worldViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(WorldViewModel.class);
        worldViewModel.setSummaryWorld();
        worldViewModel.getSummaryWorld().observe(getViewLifecycleOwner(), world -> {
            tvConfirmedWorld.setText(String.valueOf(world.getWorldConfirmed().getValue()));
            tvDeathWorld.setText(String.valueOf(world.getWorldDeaths().getValue()));
            tvRecoveredWorld.setText(String.valueOf(world.getWorldRecovered().getValue()));
        });

        //Make Button Cardview For 2 Cardview
        cvHospitals = view.findViewById(R.id.cvRumahSakitRujukan);
        cvHospitals.setOnClickListener(this);
        cvContacs = view.findViewById(R.id.cvKontakLayanan);
        cvContacs.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent moveToActivity;
        switch (v.getId()){
            case R.id.cvRumahSakitRujukan:
                moveToActivity = new Intent(getContext(), HospitalsActivity.class);
                startActivity(moveToActivity);
                break;
            case R.id.cvKontakLayanan:
                moveToActivity = new Intent(getContext(), ContactActivity.class);
                startActivity(moveToActivity);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
