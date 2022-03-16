package com.xampweb.yourchats.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.xampweb.yourchats.Models.CallModel;
import com.xampweb.yourchats.Models.Users;
import com.xampweb.yourchats.R;

import java.util.ArrayList;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder>{

    ArrayList<CallModel> list;
    Context context;

    public CallAdapter(ArrayList<CallModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_call, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CallModel callModel = list.get(position);


        Picasso.get().load(callModel.getProfilePic()).placeholder(R.drawable.user).into(holder.image);
        holder.userName.setText(callModel.getUserName());
        holder.lastCall.setText(callModel.getPhone());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView userName, lastCall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            image =itemView.findViewById(R.id.call_profile_image);
            userName=itemView.findViewById(R.id.call_userNamelist);
            lastCall =itemView.findViewById(R.id.lastCall);
        }
    }
}
