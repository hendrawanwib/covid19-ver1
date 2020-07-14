package id.haweje.covid19v1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import id.haweje.covid19v1.ui.home.HomeFragment;
import id.haweje.covid19v1.ui.InfoFragment;
import id.haweje.covid19v1.R;
import id.haweje.covid19v1.ui.statistic.StatistikFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    //Variable
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare Bottom View
        bottomNav = findViewById(R.id.bottom_nav);

        //Function for set Main View in this Apps
        if (savedInstanceState == null){
            bottomNav.setItemSelected(R.id.nav_home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit();
        }

        //For make buttonNav can Selected Item
        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_statistik:
                        fragment = new StatistikFragment();
                        break;
                    case R.id.nav_info:
                        fragment = new InfoFragment();
                        break;
                }
                if (fragment!=null){

                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                }else {
                    Log.e(TAG, "Error in Creating Fragment");
                }
            }
        });
    }
}
