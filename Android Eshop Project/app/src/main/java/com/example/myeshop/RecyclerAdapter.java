package com.example.myeshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<String> List;
    private OnItemListener onItemListener;

    public RecyclerAdapter(List<String> list, OnItemListener onItemListener){
        List=list;
        this.onItemListener=onItemListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_layout, parent,false);// kanw ena textview me sigekrimeno layout
        MyViewHolder myViewHolder = new MyViewHolder(textView, onItemListener);//to pernaw mazi me to on Item listener pou eftiaksa
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemName.setText(List.get(position));//vazw to text pou 8a emfanizei me auto pou tou exei do8ei apo to array simfona me to position
    }


    @Override
    public int getItemCount() {
        return List.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;
        OnItemListener onItemListener;
        public MyViewHolder(TextView itemView, OnItemListener onItemListener){
            super(itemView);
            itemName = itemView;
            this.onItemListener=onItemListener;
        itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.OnItemClick(getAdapterPosition()); // kalw to onitemlistener me to position pou egine clicked
        }
    }

    public interface OnItemListener // ftiaxnw ena interface OnItemListener wste na kanw energies otan kati ginete clicked
    {
        void OnItemClick(int position);
    }
}
