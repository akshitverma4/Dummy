package com.example.Dummy.ui.orders;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Dummy.Dialog.CustomDialogClassOrders;
import com.example.Dummy.R;
import com.example.Dummy.adapter.RecyclerViewAdapterOrders;
import com.example.Dummy.items.OrdersItem;

import java.util.ArrayList;

public class Orders extends Fragment {

    private OrdersViewModel mViewModel;
    private ArrayList<OrdersItem> OrdersList;
    private RecyclerView productRecyclerView;
    RecyclerViewAdapterOrders mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Orders newInstance() {
        return new Orders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.orders_fragment, container, false);


        OrdersList = new ArrayList<>();
        for (int i = 24; i < 28; i++) {
            OrdersItem orders = new OrdersItem();
            orders.setName("Dog healthy food , large, " + i + "Inch");
            if (i % 2 == 0)
                orders.setImage(R.drawable.dog_food);
            else if (i % 3 == 0)
                orders.setImage(R.drawable.dog_food2);
            else
                orders.setImage(R.drawable.dog_food3);
            OrdersList.add(orders);
        }



        TextView filter = view.findViewById(R.id.order_filter);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogClassOrders cdd = new CustomDialogClassOrders(getActivity());
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });

        buildRecyclerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);
        // TODO: Use the ViewModel
    }


    public void buildRecyclerView(View view) {
      //  Drawable horizontalDivider = ContextCompat.getDrawable(this.getContext(), R.drawable.line_divider);
        productRecyclerView = view.findViewById(R.id.recyclerView_orders);
        productRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new RecyclerViewAdapterOrders(OrdersList, getContext(), getActivity());
        productRecyclerView.setLayoutManager(mLayoutManager);
        productRecyclerView.setAdapter(mAdapter);

    }
}