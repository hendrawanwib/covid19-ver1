package id.haweje.covid19v1.ui.statistic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.ui.statistic.adapter.ViewPagerAdapter;
import id.haweje.covid19v1.ui.statistic.fragment.IndonesiaPiechartFragment;
import id.haweje.covid19v1.ui.statistic.fragment.WorldPieChartFragment;

public class ShowpieChart extends AppCompatActivity {

    //Tab Layout Variable
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    //Fragment
    private IndonesiaPiechartFragment indonesiaPiechartFragment;
    private WorldPieChartFragment worldPieChartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpie_chart);
        //call the function
        setToolbar();
        setTabLayout();
    }

    //this function for setting the toolbar
    private void setToolbar(){
        toolbar = findViewById(R.id.toolbarChart);
        toolbar.setTitle(getString(R.string.activity_piechart));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    //this function for setting the tablayout and add the tab
    private void setTabLayout() {
        tabLayout = findViewById(R.id.tabLayoutChart);
        viewPager = findViewById(R.id.view_pagerChart);
        worldPieChartFragment = new WorldPieChartFragment();
        indonesiaPiechartFragment = new IndonesiaPiechartFragment();

        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(worldPieChartFragment, "Dunia");
        viewPagerAdapter.addFragment(indonesiaPiechartFragment, "Indonesia");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
