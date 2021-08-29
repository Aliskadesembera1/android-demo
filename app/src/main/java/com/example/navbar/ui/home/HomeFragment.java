package com.example.navbar.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;

import com.example.navbar.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbar.R;
import com.example.navbar.databinding.FragmentHomeBinding;
import com.example.navbar.ui.slider.BannerSlider;
import com.example.navbar.ui.slider.SliderIndicator;
import com.example.navbar.ui.slider.SliderPagerAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private BannerSlider bannerSlider;
    private LinearLayout mLinearLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bannerSlider = root.findViewById(R.id.sliderView);
        mLinearLayout = root.findViewById(R.id.pagesContainer);
        ((home)getActivity()).setupSlider(bannerSlider,mLinearLayout);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;

    }
    private void setupSlider() {

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}