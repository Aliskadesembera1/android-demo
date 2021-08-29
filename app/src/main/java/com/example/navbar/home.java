package com.example.navbar;

import android.os.Bundle;
import android.widget.LinearLayout;


import com.example.navbar.ui.slider.BannerSlider;
import com.example.navbar.ui.slider.FragmentSlider;
import com.example.navbar.ui.slider.SliderIndicator;
import com.example.navbar.ui.slider.SliderPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navbar.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;

    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DrawerLayout drawer = binding.drawerLayout;



        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavigationView Adrawer=(NavigationView) findViewById(R.id.navi_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
         appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
       // NavController navController1 = Navigation.findNavController(this, R.id.nav_host_fragment_content_menubar);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //panah
        //NavigationUI.setupActionBarWithNavController(this,navController,drawer);
        NavigationUI.setupWithNavController(binding.navView, navController);








    }
    public void setupSlider( BannerSlider bannerSlider,LinearLayout mLinearLayout ) {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://alfamart.co.id/storage/page/August2021/af9Fq2ivpa1ZZKeBtqsQ.jpg"));
        fragments.add(FragmentSlider.newInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSelT4L3Z6Uz5AHke3H5yH1dt2RjZ7YzMUvTu9fuQ35fIObgWyLRrUGRmkku5l74CFL6mQ&usqp=CAU"));
        fragments.add(FragmentSlider.newInstance("https://lapisbogor.co.id/wp-content/uploads/2021/05/Image-Banner-Promo-1920x650px.jpg"));
        fragments.add(FragmentSlider.newInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPuNivxdTl7diLpDzaxo0uV6G30GznC7gOz9t-2jHzCWm7W_2r23TrGu4pz-afNySFwMc&usqp=CAU"));





        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}