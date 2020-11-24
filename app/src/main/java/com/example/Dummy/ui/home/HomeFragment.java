package com.example.Dummy.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.Dummy.Cart;
import com.example.Dummy.R;
import com.example.Dummy.SearchViewShop;
import com.example.Dummy.ui.book_service.BookForm1;
import com.example.Dummy.ui.book_service.BookService;
import com.example.Dummy.ui.chat_with_experts.ChatWithExperts;
import com.example.Dummy.ui.shop_now.ShopNow;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d("callingOn", "onCreateView: called");

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        SharedPreferences.Editor editor = getContext().getSharedPreferences("homeId", MODE_PRIVATE).edit();
        editor.putInt("homeId", 1);
        editor.apply();

        final ImageButton btnHomeCart = view.findViewById(R.id.btnCartHomeFragmentScene);
        // final Button btnShopNow = view.findViewById(R.id.btn_home_shop_now);
        final ConstraintLayout l_lytShopNow = view.findViewById(R.id.goToShopNow);
        final ConstraintLayout l_lytBook = view.findViewById(R.id.goToBookAService);
        final ConstraintLayout l_lytChat = view.findViewById(R.id.goToChat);
        Button btn2 = view.findViewById(R.id.button2);
        final TextView textView = view.findViewById(R.id.text_home);

        TextView search = view.findViewById(R.id.search_view_home);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("search", "onClick: ");
                startActivity(new Intent(getContext(), SearchViewShop.class));
            }
        });

        btnHomeCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Cart.class);
                startActivity(i);
            }
        });

        Button button =view.findViewById(R.id.home_chat_now);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ChatWithExperts();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_frag, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        l_lytShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ShopNow();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_frag, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        l_lytBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new BookService();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_frag, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new BookService();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_frag, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        l_lytChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ChatWithExperts();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_frag, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button bookIt =view.findViewById(R.id.book_it);
        bookIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BookForm1.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("callingOn", "onResume: called");
        SharedPreferences.Editor editor = getContext().getSharedPreferences("homeId", MODE_PRIVATE).edit();
        editor.putInt("homeId", 1);
        editor.apply();

    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("callingOn", "onPause: called");
        SharedPreferences.Editor editor = getContext().getSharedPreferences("homeId", MODE_PRIVATE).edit();
        editor.putInt("homeId", 2);
        editor.apply();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("callingOn", "onDestroyView: called");
        SharedPreferences.Editor editor = getContext().getSharedPreferences("homeId", MODE_PRIVATE).edit();
        editor.putInt("homeId", 2);
        editor.apply();
    }
}