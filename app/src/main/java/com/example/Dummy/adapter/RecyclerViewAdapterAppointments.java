package com.example.Dummy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.items.AppointmentItems;
import com.example.Dummy.ui.appointments.BookedAppointmentDetails;

import java.util.ArrayList;


public class RecyclerViewAdapterAppointments extends RecyclerView.Adapter<RecyclerViewAdapterAppointments.ExampleViewHolder> {
    private final ArrayList<AppointmentItems> mExampleList;
    private Context mContext;
    private Activity mActivity;

    private RecyclerViewAdapterAppointments.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView cost;
        public TextView time;
        public TextView duration;

        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterAppointments.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.appointment_name);
                cost = itemView.findViewById(R.id.appointment_cost);
                time = itemView.findViewById(R.id.appointment_time);
                duration = itemView.findViewById(R.id.appointment_duration);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), BookedAppointmentDetails.class);
                    itemView.getContext().startActivity(intent);


                }
            });


        }
    }

    public RecyclerViewAdapterAppointments(ArrayList<AppointmentItems> exampleList, Context context, Activity activity) {
        mExampleList = exampleList;
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_booked_appointments, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        AppointmentItems currentItem = mExampleList.get(position);
       // holder.name.setText(currentItem.getName());
        holder.cost.setText(currentItem.getCost());
        holder.duration.setText(currentItem.getDuration());
        holder.time.setText(currentItem.getTime());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}