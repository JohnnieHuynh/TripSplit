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
import com.example.tripsplit.Model.UserOpModel;
import com.example.tripsplit.R;
import com.example.tripsplit.View.TripView_Activity;

import java.util.List;

public class tripViewAdapter extends RecyclerView.Adapter<tripViewAdapter.MyViewHolder>{
    //Private Var for list of items
    private List<UserOpModel> listItems;
    private Context context;

    //Constructor for item list
    public tripViewAdapter (List<UserOpModel> itemList, Context context) {
        this.listItems = itemList;
        this.context = context;
    }

    //Creates new Views
    @NonNull
    public tripViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_trans_target, parent, false);
        tripViewAdapter.MyViewHolder vh = new tripViewAdapter.MyViewHolder(v);
        return vh;
    }

    //After ViewHolder is created, binds data to View
    public void onBindViewHolder(@NonNull tripViewAdapter.MyViewHolder holder, int position) {
        //Current
        final UserOpModel currentList = listItems.get(position);
        final int pos = holder.getAdapterPosition();

        //Set Text to Views
        holder.tvSender.setText(currentList.getSender());
        holder.tvOperation.setText(currentList.getOperationMSG());
        holder.tvRecipent.setText(currentList.getRecipent());

        //Set on click listener for button clicks
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                //Make intent for moving screens
                Intent intent = new Intent(context, TripView_Activity.class);
                intent.putExtra("TripID_Extra", currentList.getTripCode());

                //Switches screen
                context.startActivity(intent);
                 */
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
        public TextView tvSender;
        public TextView tvOperation;
        public TextView tvRecipent;
        public LinearLayout linearLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            //Connect TextFields within items themselves
            tvSender = (TextView) itemView.findViewById(R.id.TV_trans_sender);
            tvOperation = (TextView) itemView.findViewById(R.id.TV_trans_operation_msg);
            tvRecipent = (TextView) itemView.findViewById(R.id.TV_trans_recipent);

            //Connect LinearLayout for button presses
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutID2);

        }
    }
}
