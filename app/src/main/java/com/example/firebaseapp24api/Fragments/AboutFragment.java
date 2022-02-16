package com.example.firebaseapp24api.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseapp24api.Clients.Clients;
import com.example.firebaseapp24api.Clients.DAOClients;
import com.example.firebaseapp24api.Products.DAOProducts;
import com.example.firebaseapp24api.Products.Products;
import com.example.firebaseapp24api.R;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.net.URI;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    ImageButton imageButton, addBTN;
    EditText name,price,gender,material;
    private static final int SELECT_PHOTO = 1;
    URI imageURI = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        name = view.findViewById(R.id.editTextProdName);
        price = view.findViewById(R.id.editTextPrice);
        gender = view.findViewById(R.id.editTextGender);
        material = view.findViewById(R.id.editTextMaterial);
        addBTN = view.findViewById(R.id.imageButtonAddProd);
        imageButton = view.findViewById(R.id.imageAddProduct);



        DAOProducts dao = new DAOProducts();

        addBTN.setOnClickListener(v -> {

            Products products = new Products(name.getText().toString() , price.getText().toString() , gender.getText().toString(), material.getText().toString());
            dao.add(products).addOnSuccessListener(suc ->
            {
                Toast.makeText(getActivity(),"Client Inserted ",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(getActivity(), "Inserted Failed ",Toast.LENGTH_LONG).show();
            });

        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if (!requestCode == SELECT_PHOTO && requestCode)
    }
}











