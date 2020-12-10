package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;


import java.util.Timer;
import java.util.TimerTask;

import com.example.Dummy.adapter.ViewPagerAdapter;

public class ShopNowHome extends AppCompatActivity {


    Toolbar toolbar;
    private String[] imageUrls = new String[]{
            "https://image.shutterstock.com/image-photo/web-banner-happy-cute-jack-260nw-1173028279.jpg",
            "https://www.revivalanimal.com/images/DR-banner1.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTjjgVuz708CP8mo8K50zjN2fiwL8UfAf97nQ&usqp=CAU",


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_now_home);
        Log.d("search", "onClick: ");

        // Search View Button
        TextView search = findViewById(R.id.searchViewHome);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("search", "onClick: ");
                Intent intent = new Intent(ShopNowHome.this, SearchViewShop.class);
                startActivity(intent);
            }
        });
        ImageView shopNowButton = findViewById(R.id.to_shopNowMain);
        shopNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShopNowMain.class);
                startActivity(intent);
            }
        });

        //ImageView food = findViewById(R.id.imageView_food);
        //ImageView treats = findViewById(R.id.imageView_treats);
        //ImageView supplements = findViewById(R.id.imageView_supplements);
        //ImageView grooming = findViewById(R.id.imageView_grooming);
        //ImageView accessories = findViewById(R.id.imageView_accessories);

        /*food.setOnClickListener(new View.OnClickListener() {
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
        });*/

        ImageButton cart = findViewById(R.id.cart_home);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ShopNowHome.this, Cart.class);
                startActivity(intent);
            }
        });

        slideBanner();

    }


    // Slide banner implementation
    public void slideBanner() {

        final ViewPager viewPager = findViewById(R.id.view_pager2);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        /*After setting the adapter use the timer */
        final int[] currentPage = {0};
        Timer timer;
        final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
        final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage[0] == adapter.getCount() ) {
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
        LinearLayout sliderDotspanel = findViewById(R.id.SliderDots2);
        final int dotscount = adapter.getCount();
        final ImageView[] dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactive_dot_big));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot_big));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactive_dot_big));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot_big));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
