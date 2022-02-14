package com.example.firebaseapp24api.Products;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseapp24api.R;

public class ProductsVH extends RecyclerView.ViewHolder {
    public TextView txt_name, txt_price;
    public ProductsVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_price = itemView.findViewById(R.id.txt_price);
    }
}
