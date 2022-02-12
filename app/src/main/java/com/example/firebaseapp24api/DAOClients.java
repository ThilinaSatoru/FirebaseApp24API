package com.example.firebaseapp24api;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOClients {
    private final DatabaseReference databaseReference;

    public  DAOClients(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Clients.class.getSimpleName());
    }
    public Task<Void> add(Clients clients){
        return  databaseReference.push().setValue(clients);
    }
    public Task<Void> update(String key, HashMap<String , Object> hashMap){
        return databaseReference.child(key).setValue(hashMap);
    }
}
