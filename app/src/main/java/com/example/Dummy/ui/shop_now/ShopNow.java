package com.example.Dummy.ui.shop_now;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import com.example.Dummy.Cart;
import com.example.Dummy.R;
import com.example.Dummy.SearchViewShop;
import com.example.Dummy.ShopNowMain;
import com.example.Dummy.ShopNowResult;
import com.example.Dummy.adapter.ViewPagerAdapter;

public class ShopNow extends Fragment {

    private ShopNowViewModel mViewModel;
    String[] imageUrls = new String[]{
            "https://image.shutterstock.com/image-photo/web-banner-happy-cute-jack-260nw-1173028279.jpg",
            "https://www.revivalanimal.com/images/DR-banner1.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTjjgVuz708CP8mo8K50zjN2fiwL8UfAf97nQ&usqp=CAU",

    };

    public static ShopNow newInstance() {
        return new ShopNow();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_shop_now_home, container, false);
        // MaterialSearchView searchView;
        Toolbar toolbar;


        // toolbar = findViewById(R.id.toolbar);
        //    setSupportActionBar(toolbar);
        //    getSupportActionBar().setDisplayShowTitleEnabled(false);

        //      searchView();
        slideBanner(view);
        TextView search = view.findViewById(R.id.searchViewHome);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("search", "onClick: ");
                startActivity(new Intent(getContext(), SearchViewShop.class));
            }
        });

        ImageButton cart = view.findViewById(R.id.cart_home);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Cart.class));
            }
        });
        ImageView shopNowButton = view.findViewById(R.id.to_shopNowMain);
        shopNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowMain.class);
                startActivity(intent);
            }
        });

        ImageView food = view.findViewById(R.id.imageView_food);
        ImageView treats = view.findViewById(R.id.imageView_treats);
        ImageView supplements = view.findViewById(R.id.imageView_supplements);
        ImageView grooming = view.findViewById(R.id.imageView_grooming);
        ImageView accessories = view.findViewById(R.id.imageView_accessories);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowResult.class);
                startActivity(intent);
            }
        });
        treats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowResult.class);
                startActivity(intent);
            }
        });
        supplements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowResult.class);
                startActivity(intent);
            }
        });
        grooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowResult.class);
                startActivity(intent);
            }
        });
        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowResult.class);
                startActivity(intent);
            }
        });
        return view;

    }

    @Override
    public void onPause() {
        super.onPause();
        onDestroyView();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShopNowViewModel.class);

    }

    // Slide banner implementation
    public void slideBanner(final View view) {

        final ViewPager viewPager = view.findViewById(R.id.view_pager2);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(view.getContext(), imageUrls);
        viewPager.setAdapter(adapter);

        /*After setting the adapter use the timer */
        final int[] currentPage = {0};
        Timer timer;
        final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
        final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage[0] == adapter.getCount()) {
                    currentPage[0] = 0;
                }
                viewPager.setCurrentItem(currentPage[0]++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


        //Dots
        LinearLayout sliderDotspanel = view.findViewById(R.id.SliderDots2);
        final int dotscount = adapter.getCount();
        final ImageView[] dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(view.getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.inactive_dot_big));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.active_dot_big));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.inactive_dot_big));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.active_dot_big));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}