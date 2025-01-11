package com.example.benuadunia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class BenuaAdapter extends RecyclerView.Adapter<BenuaAdapter.ViewHolder> {

    private final List<Map<String, String>> data;
    private final OnItemClickListener onItemClickListener;

    public BenuaAdapter(List<Map<String, String>> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Map<String, String> d);
    }

    @NonNull
    @Override
    public BenuaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_benua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BenuaAdapter.ViewHolder holder, int position) {
        Map<String, String> benua = data.get(position);

        String namaBenua = benua.get("nama") != null ? benua.get("nama") : "Nama tidak tersedia";
        holder.namaBenua.setText(namaBenua);
        String imageName = benua.get("img");
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = holder.itemView.getContext().getResources().getIdentifier(imageName, "drawable", holder.itemView.getContext().getPackageName());
            if (imageResId != 0) {
                holder.imgBenua.setImageResource(imageResId);
            } else {
                holder.imgBenua.setImageResource(R.drawable.benua_afrika);
            }
        } else {
            holder.imgBenua.setImageResource(R.drawable.benua_afrika);
        }
        holder.btnLihat.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(data.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaBenua;
        ImageView imgBenua;
        Button btnLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaBenua = itemView.findViewById(R.id.namaBenua);
            imgBenua = itemView.findViewById(R.id.imgBenua);
            btnLihat = itemView.findViewById(R.id.btnLihat);
        }
    }
}
