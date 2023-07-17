package com.example.sananismayilov.onlinedictionary.RecylerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sananismayilov.onlinedictionary.Activity.DetailsActivity;
import com.example.sananismayilov.onlinedictionary.databinding.GorunumBinding;

import java.util.ArrayList;
import java.util.List;

public class Adaptertorecylerview extends RecyclerView.Adapter<Adaptertorecylerview.Holdertorecylerview> {

List<Dictionary> conteynerToWordArrayList;
    String[] colors = {"#EB3710","#12C868","#1111BE","#11A2CA","#B8DC06","#DC7B06","#DC065A","#52AA34","#000000"};

    public Adaptertorecylerview(List<Dictionary> conteynerToWordArrayList) {
        this.conteynerToWordArrayList = conteynerToWordArrayList;
    }

    @NonNull
    @Override
    public Holdertorecylerview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GorunumBinding binding = GorunumBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new  Holdertorecylerview(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holdertorecylerview holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.textaz.setText(conteynerToWordArrayList.get(position).getTextAz());
        holder.binding.texten.setText(conteynerToWordArrayList.get(position).getTextEn());
        holder.binding.textaz.setTextColor(Color.parseColor(colors[position%colors.length]));
        if(position == colors.length-1){
            holder.binding.texten.setTextColor(Color.parseColor(colors[position%colors.length]));
        } else{
            holder.binding.texten.setTextColor(Color.parseColor(colors[(position%colors.length)+1]));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("sentDictionaryAz", conteynerToWordArrayList.get(position).getTextAz());
                intent.putExtra("sentDictionaryEn", conteynerToWordArrayList.get(position).getTextEn());
                intent.putExtra("Color",colors[position%colors.length]);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return conteynerToWordArrayList.size();
    }

    public class Holdertorecylerview extends RecyclerView.ViewHolder{
        GorunumBinding binding;
        public Holdertorecylerview(@NonNull GorunumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
