package com.example.firebaseapp24api.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.firebaseapp24api.Clients.Clients;
import com.example.firebaseapp24api.Clients.DAOClients;
import com.example.firebaseapp24api.LoginActivity;
import com.example.firebaseapp24api.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    TextView name,email;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        //////////////////////////////////////////////////////////////////////////////////////////
        mAuth = FirebaseAuth.getInstance();
        name = view.findViewById(R.id.name1);
        email = view.findViewById(R.id.email2);
        EditText mobile = view.findViewById(R.id.editTextTextMobile);
        ImageView imgProfilePic = view.findViewById(R.id.imgProfilePic);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(getContext());
        if(signInAccount!=null){

            name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
            String personPhotoUrl = signInAccount.getPhotoUrl().toString();
            Glide.with(getActivity().getApplicationContext()).load(personPhotoUrl)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfilePic);
        }
        ///////////////////////////////////////



        ImageButton addBTN = view.findViewById(R.id.imageButtonAdd);
        DAOClients dao = new DAOClients();

        addBTN.setOnClickListener(v -> {

            Clients clients = new Clients(name.getText().toString() , email.getText().toString() , mobile.getText().toString());
            dao.add(clients).addOnSuccessListener(suc ->
            {
                Toast.makeText(getActivity(),"Client Inserted ",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(getActivity(), "Inserted Failed ",Toast.LENGTH_LONG).show();
            });

        });

        /////////////////////////////////////////////
        view.findViewById(R.id.logout).setOnClickListener(v -> {
            mAuth.signOut();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        //////////////////////////////////////////////////////////////////////////////////////////
        return view;
    }


}