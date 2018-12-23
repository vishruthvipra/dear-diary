package com.example.vishruthkrishnaprasad.deardiary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by vishruthkrishnaprasad on 1/2/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Entry> entries;

    RecyclerViewAdapter(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statusContainer = inflater.inflate(R.layout.row_item, parent, false);
        return new ProductViewHolder(statusContainer, context);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Entry status = entries.get(position);
        holder.bind(status);
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}




