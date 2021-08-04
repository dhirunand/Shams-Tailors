package com.dhirunand.shamstailors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    public static ArrayList<ItemMeasurementContainer> itemMeasurementContainerArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemMeasurementContainerArrayList = new ArrayList<>();

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        // Passing each menu ID as a set of Ids because each menu is the top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.orderFragment, R.id.deliveredFragment, R.id.profileFragment)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottom_nav, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}