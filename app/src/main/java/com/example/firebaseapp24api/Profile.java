package com.example.firebaseapp24api;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    TextView name,email;
    FirebaseAuth mAuth;
    //private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.name1);
        email = findViewById(R.id.email2);
        EditText mobile = findViewById(R.id.editTextTextMobile);
        ImageView imgProfilePic = findViewById(R.id.imgProfilePic);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null){

            name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
            String personPhotoUrl = signInAccount.getPhotoUrl().toString();
            Glide.with(getApplicationContext()).load(personPhotoUrl)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfilePic);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////



        ImageButton addBTN = findViewById(R.id.imageButtonAdd);
        DAOClients dao = new DAOClients();

        addBTN.setOnClickListener(view -> {

            Clients clients = new Clients(name.getText().toString() , email.getText().toString() , mobile.getText().toString());
            dao.add(clients);
            dao.add(clients).addOnSuccessListener(suc ->
            {
                Toast.makeText(Profile.this,"Client Inserted ",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(Profile.this, "Inserted Failed ",Toast.LENGTH_LONG).show();
            });

        });

        ////////////////////////////////////////////////////////////////////////////////////////////
        findViewById(R.id.logout).setOnClickListener(view -> {
            mAuth.signOut();

            Intent intent = new Intent(Profile.this,MainActivity.class);
            startActivity(intent);
            finish();
        });


    }
}