package com.example.tripsplit.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsplit.Model.ItemModel;
import com.example.tripsplit.R;
import com.example.tripsplit.View.TripView_Activity;

import java.util.List;

/**
 * An adapter class for my recycler view
 * for mainly, Trip List Activity,
 */

public class tripListAdapter extends RecyclerView.Adapter<tripListAdapter.MyViewHolder> {
    //Private Var for list of items
    private List<ItemModel> listItems;
    private Context context;

    //Constructor for item list
    public tripListAdapter (List<ItemModel> itemList, Context context) {
        this.listItems = itemList;
        this.context = context;
    }

    //Creates new Views
    @NonNull
    @Override
    public tripListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    //After ViewHolder is created, binds data to View
    @Override
    public void onBindViewHolder(@NonNull tripListAdapter.MyViewHolder holder, int position) {
        //Current
        final ItemModel currentList = listItems.get(position);
        final int pos = holder.getAdapterPosition();

        //Set Text to Views
        holder.tvTripName.setText(currentList.getTripName());
        holder.tvUserTotal.setText(currentList.getUserTotal());
        holder.tvTripDesc.setText(currentList.getTripDescription());

        //Set on click listener for button clicks
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make intent for moving screens
                Intent intent = new Intent(context, TripView_Activity.class);
                intent.putExtra("TripID_Extra", currentList.getTripCode());
                intent.putExtra("TripNum_Extra", currentList.getUserTotal());
                //Switches screen
                context.startActivity(intent);
            }
        });
    }

    //Get amount of elements in list
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    //Custom ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Two Fields in item
        public TextView tvTripName;
        public TextView tvUserTotal;
        public TextView tvTripDesc;
        public LinearLayout linearLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            //Connect TextFields within items themselves
            tvTripName = (TextView) itemView.findViewById(R.id.textViewTripName);
            tvUserTotal = (TextView) itemView.findViewById(R.id.textViewUserTotal);
            tvTripDesc = (TextView) itemView.findViewById(R.id.textViewTripDesc);

            //Connect LinearLayout for button presses
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutID);

        }
    }
}
