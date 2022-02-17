package com.example.firebaseapp24api.RV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseapp24api.Products.Products;
import com.example.firebaseapp24api.Products.ProductsVH;
import com.example.firebaseapp24api.R;

import java.util.ArrayList;

public class RVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Products> list = new ArrayList<>();
    public RVadapter(Context ctx) {
        this.context = ctx;
    }
    public void setProducts(ArrayList<Products> prod){
        list.addAll(prod);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_products,parent,false);

        return new ProductsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductsVH vh = (ProductsVH) holder;
        Products prod = list.get(position);
        //vh.image.setImageBitmap(prod.getImageUrl());
        vh.txt_name.setText(prod.getName());
        vh.txt_price.setText(prod.getPrice());
        vh.txt_material.setText(prod.getMaterial());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
