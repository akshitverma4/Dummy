package com.example.Dummy.ui.loyalty_rewards;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Dummy.R;

public class LoyaltyRewards extends Fragment {

    private LoyaltyRewardsViewModel mViewModel;

    public static LoyaltyRewards newInstance() {
        return new LoyaltyRewards();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loyalty_rewards_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoyaltyRewardsViewModel.class);
        // TODO: Use the ViewModel
    }

}