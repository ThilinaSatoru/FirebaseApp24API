package com.example.firebaseapp24api.Products;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseapp24api.R;

public class ProductsVH extends RecyclerView.ViewHolder {
    public TextView txt_name, txt_price, txt_material;
    public ImageView image;
    public ProductsVH(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img_product);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_price = itemView.findViewById(R.id.txt_price);
        txt_material = itemView.findViewById(R.id.txt_material);
    }
}
