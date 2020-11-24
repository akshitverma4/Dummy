
package com.example.Dummy.ui.are_you_doctor;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Dummy.R;

public class AreYouDoctor extends Fragment {

    private AreYouDoctorViewModel mViewModel;

    public static AreYouDoctor newInstance() {
        return new AreYouDoctor();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.are_you_doctor_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AreYouDoctorViewModel.class);
        // TODO: Use the ViewModel
    }

}