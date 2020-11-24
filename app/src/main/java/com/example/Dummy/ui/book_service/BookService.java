package com.example.Dummy.ui.book_service;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Dummy.R;
import com.example.Dummy.SearchViewProviders;
import com.example.Dummy.adapter.RecyclerViewAdapterBook;
import com.example.Dummy.items.ServiceProviders;

import java.util.ArrayList;

public class BookService extends Fragment {

    private BookServiceViewModel mViewModel;
    public ArrayList<ServiceProviders> ProvidersList;
    private RecyclerView bookRecyclerView;
    private RecyclerViewAdapterBook mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout grooming;
    LinearLayout petDiagno;
    LinearLayout vetCare;
    LinearLayout transport;
    LinearLayout dayCare;
    public static BookService newInstance() {
        return new BookService();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.book_service_fragment, container, false);
        ProvidersList = new ArrayList<>();
        for(int i=0 ; i<2; i++) {
            ServiceProviders serviceProviders = new ServiceProviders();
            serviceProviders.setName("Provider "+i);
            ProvidersList.add(serviceProviders);
        }

        //SearchView
        TextView search = view.findViewById(R.id.searchViewBook);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("search", "onClick: ");
                startActivity(new Intent(getContext(), SearchViewProviders.class));
            }
        });
        //view all button
        TextView viewAll = view.findViewById(R.id.viewAllBook);
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });

        grooming = view.findViewById(R.id.grooming_layout);
        petDiagno = view.findViewById(R.id.diagno_layout);
        vetCare = view.findViewById(R.id.vet_care_layout);
        transport = view.findViewById(R.id.transport_layout);
        dayCare = view.findViewById(R.id.day_care_layout);

        grooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });
        petDiagno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });
        vetCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });
        dayCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), BookServiceViewAll.class);
                startActivity(intent);
            }
        });

        buildRecyclerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BookServiceViewModel.class);
        // TODO: Use the ViewModel
    }

    public void buildRecyclerView(View view) {

        bookRecyclerView = view.findViewById(R.id.recyclerViewBook);
        bookRecyclerView.setHasFixedSize(true);
        mLayoutManager =new LinearLayoutManager(view.getContext());
        mAdapter = new RecyclerViewAdapterBook(ProvidersList, view.getContext(), getActivity());
        bookRecyclerView.setLayoutManager(mLayoutManager);
        bookRecyclerView.setAdapter(mAdapter);

    }

}