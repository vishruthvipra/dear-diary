package com.example.vishruthkrishnaprasad.deardiary;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.vishruthkrishnaprasad.deardiary.databinding.RowItemBinding;

/**
 * Created by vishruthkrishnaprasad on 22/12/18.
 */

class ProductViewHolder extends RecyclerView.ViewHolder {
    private RowItemBinding binding;

    ProductViewHolder(View view, final Context context) {
        super(view);

        binding = DataBindingUtil.bind(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EntryActivity.class);
                context.startActivity(intent);
            }
        });
    }

    void bind(Entry result) {
        binding.setResult(result);
    }
}
