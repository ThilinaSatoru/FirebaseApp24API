package com.example.firebaseapp24api;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.firebaseapp24api.Fragments.AboutFragment;
import com.example.firebaseapp24api.Fragments.AccountFragment;
import com.example.firebaseapp24api.Fragments.ProductsFragment;

public class HomeActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {

        return contextOfApplication;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        contextOfApplication = getApplicationContext();

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_about));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_account));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch(item.getId()){
                    case 1:
                        fragment = new AboutFragment();
                        break;
                    case 2:
                        fragment = new ProductsFragment();
                        break;
                    case 3:
                        fragment = new AccountFragment();
                        break;
                }
                loadFragment(fragment);

            }
        });
        //notifications
        bottomNavigation.setCount(1,"5");
        //
        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                // display toast
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}