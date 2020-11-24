package com.example.Dummy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_appointments, R.id.shop_now, R.id.nav_loyalty_rewards, R.id.nav_book_a_service, R.id.nav_settings, R.id.nav_chat_with_experts, R.id.help, R.id.nav_orders, R.id.nav_wishlist)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        View headerview = navigationView.getHeaderView(0);
        ConstraintLayout pet_header = headerview.findViewById(R.id.pet_header);
        pet_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawerActivity.this, MyPets.class);
                startActivity(intent);
            }
        });

        ConstraintLayout toProfile = headerview.findViewById(R.id.to_profile);
        toProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawerActivity.this, MyProfile.class));
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage("Do you want to close?")
//                    .setCancelable(false)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            //do finish
//                            DrawerActivity.this.finishAffinity();;
//                        }
//                    })
//                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            //do nothing
//                        }
//                    });
//            AlertDialog alert = builder.create();
//            alert.show();
//
//
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        int idHome = getSharedPreferences("homeId", MODE_PRIVATE).getInt("homeId", 1);
        if(idHome==1)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to close?")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do finish
                            DrawerActivity.this.finishAffinity();

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do nothing
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else
            this.finish();
    }

//    public Fragment getVisibleFragment(){
//        FragmentManager fragmentManager = DrawerActivity.this.getSupportFragmentManager();
//        List<Fragment> fragments = fragmentManager.getFragments();
//        if(fragments != null){
//            for(Fragment fragment : fragments){
//                if(fragment != null && fragment.isVisible())
//                    return fragment;
//            }
//        }
//        return null;
//    }



}