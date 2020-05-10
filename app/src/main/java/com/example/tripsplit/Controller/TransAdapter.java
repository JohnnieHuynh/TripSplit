package com.example.tripsplit.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsplit.Model.TransModel;
import com.example.tripsplit.Model.UserOpModel;
import com.example.tripsplit.R;
import com.example.tripsplit.View.TripView_Activity;

import java.util.List;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.MyViewHolder>{
    //Private Var for list of items
    private List<TransModel> listItems;
    private Context context;


    //Constructor for item list
    public TransAdapter (List<TransModel> itemList, Context context) {
        this.listItems = itemList;
        this.context = context;
    }

    //Creates new Views
    @NonNull
    public TransAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_transaction, parent, false);
        TransAdapter.MyViewHolder vh = new TransAdapter.MyViewHolder(v);
        return vh;
    }

    //After ViewHolder is created, binds data to View
    public void onBindViewHolder(@NonNull TransAdapter.MyViewHolder holder, int position) {
        //Current
        final TransModel currentList = listItems.get(position);
        final int pos = holder.getAdapterPosition();

        //Set Text to Views
        holder.tvDate.setText(currentList.getDate());
        holder.tvAmount.setText(currentList.getAmount());
        holder.tvDescription.setText(currentList.getDescription());
        holder.tvPersonLink.setText(currentList.getPersonLink());
        //Set on click listener for button clicks
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 //Make intent for moving screens

                 Intent intent2 = ((Activity) context).getIntent();
                 String eventNum = intent2.getStringExtra("TripNum_Extra");
                ((Activity) context).finish();
                Intent intent = new Intent(context, TripView_Activity.class);
                intent.putExtra("TripID_Extra", currentList.getEventCode());
                intent.putExtra("TripNum_Extra",eventNum);
                intent.putExtra("TransID_Extra", currentList.getTransKey());
                 //Switches screen
                 context.startActivity(intent);

            }
        });
    }

    //Get amount of elements in list
    public int getItemCount() {
        return listItems.size();
    }

    //Custom ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Two Fields in item
        public TextView tvDate;
        public TextView tvAmount;
        public TextView tvDescription;
        public TextView tvPersonLink;
        public LinearLayout linearLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            //Connect TextFields within items themselves
            tvDate = (TextView) itemView.findViewById(R.id.tv_trans_date);
            tvAmount = (TextView) itemView.findViewById(R.id.tv_trans_amount);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_trans_desc);
            tvPersonLink = (TextView) itemView.findViewById(R.id.tv_trans_personlink);

            //Connect LinearLayout for button presses
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutID3);

        }
    }
}
