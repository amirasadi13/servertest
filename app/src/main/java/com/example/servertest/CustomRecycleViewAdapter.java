package com.example.servertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomRecycleViewAdapter extends RecyclerView.Adapter<CustomRecycleViewAdapter.MyViewHolder> {
    ArrayList person;
    Context context;

    public CustomRecycleViewAdapter(Context context, ArrayList person) {
        this.context = context;
        this.person = person;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        MyViewHolder recyclerView = new MyViewHolder(view);
        return recyclerView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText((CharSequence) person.get(position));

    }

    @Override
    public int getItemCount() {
        return person.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView family;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            family = (TextView) itemView.findViewById(R.id.tv_family);
        }
    }
}
