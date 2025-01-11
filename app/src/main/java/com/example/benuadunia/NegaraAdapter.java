package com.example.benuadunia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class NegaraAdapter extends RecyclerView.Adapter<NegaraAdapter.ViewHolder> {

    private final List<Map<String, String>> data;
    private final OnItemClickListener onItemClickListener;

    // Constructor
    public NegaraAdapter(List<Map<String, String>> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    // Interface for click listener
    public interface OnItemClickListener {
        void onItemClick(Map<String, String> negara);
    }

    @NonNull
    @Override
    public NegaraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_negara, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NegaraAdapter.ViewHolder holder, int position) {
        Map<String, String> negara = data.get(position);

        // Set nama negara
        String namaNegara = negara.get("nama") != null ? negara.get("nama") : "Nama tidak tersedia";
        holder.namaNegara.setText(namaNegara);

        // Set ibukota
        String ibukota = negara.get("ibukota") != null ? negara.get("ibukota") : "Ibukota tidak tersedia";
        holder.ibukota.setText(ibukota);

        // Set image resource
        String imageName = negara.get("img");
        if (imageName != null && !imageName.isEmpty()) {
            int imageResId = holder.itemView.getContext().getResources().getIdentifier(imageName, "drawable", holder.itemView.getContext().getPackageName());
            if (imageResId != 0) {
                holder.imgBendera.setImageResource(imageResId);
            } else {
                holder.imgBendera.setImageResource(R.drawable.ic_indonesia); // Default image
            }
        } else {
            holder.imgBendera.setImageResource(R.drawable.ic_indonesia); // Default image
        }
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(negara);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaNegara, ibukota;
        ImageView imgBendera;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaNegara = itemView.findViewById(R.id.namanegara);
            ibukota = itemView.findViewById(R.id.ibukota);
            imgBendera = itemView.findViewById(R.id.imgBendera);
        }
    }
}
