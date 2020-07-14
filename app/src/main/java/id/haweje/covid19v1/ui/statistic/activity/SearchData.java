package id.haweje.covid19v1.ui.statistic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.model.negara.AttributesNegara;
import id.haweje.covid19v1.model.provinsi.Attributes;
import id.haweje.covid19v1.ui.statistic.adapter.ViewPagerAdapter;
import id.haweje.covid19v1.ui.statistic.adapter.recyclerview.ListNationAdapter;

import id.haweje.covid19v1.ui.statistic.fragment.SearchDataIndoFragment;
import id.haweje.covid19v1.ui.statistic.fragment.SearchDataWorldFragment;

public class SearchData extends AppCompatActivity {

    //Variable for TabLayout
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    //Fragment
    SearchDataIndoFragment searchDataIndoFragment;
    SearchDataWorldFragment searchDataWorldFragment;

    ListNationAdapter adapter = new ListNationAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        setToolbar();
        setTabLayout();
    }

    //this function for setting the toolbar
    private void setToolbar(){
        toolbar = findViewById(R.id.toolbarSearch);
        toolbar.setTitle(getString(R.string.search_data));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    //this function for setting the tablayout and add the tab
    private void setTabLayout() {
        tabLayout = findViewById(R.id.tabLayoutSearch);
        viewPager = findViewById(R.id.view_pagerSearch);
        searchDataWorldFragment = new SearchDataWorldFragment();
        searchDataIndoFragment = new SearchDataIndoFragment();

        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(searchDataWorldFragment, "Dunia");
        viewPagerAdapter.addFragment(searchDataIndoFragment, "Indonesia");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setBackgroundColor(Color.WHITE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
