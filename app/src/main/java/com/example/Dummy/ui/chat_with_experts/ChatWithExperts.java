package com.example.Dummy.ui.chat_with_experts;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Dummy.R;
import com.example.Dummy.ui.book_service.BookServiceViewAll;
import com.example.Dummy.ui.home.HomeFragment;

public class ChatWithExperts extends Fragment {

    private ChatWithExpertsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getContext(), BookServiceViewAll.class);
        intent.putExtra("id", 1);
        startActivity(intent);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        HomeFragment fragment2 = new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_frag, fragment2);
        fragmentTransaction.commit();
    }
}