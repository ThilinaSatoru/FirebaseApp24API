package com.example.firebaseapp24api.Products;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOProducts {
    private final DatabaseReference databaseReference;

    public  DAOProducts(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Products.class.getSimpleName());
    }

    public Task<Void> add(Products products){
        return  databaseReference.push().setValue(products);
    }
    public Task<Void> update(String key, HashMap<String , Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key){
        return  databaseReference.child(key).removeValue();
    }

    // firebase
    public Query get(){
        return databaseReference.orderByKey();
    }

}
