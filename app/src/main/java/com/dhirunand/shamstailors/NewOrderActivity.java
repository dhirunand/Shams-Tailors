package com.dhirunand.shamstailors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import java.util.Objects;

public class NewOrderActivity extends AppCompatActivity {
    NavController newOrderNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        newOrderNavController = Navigation.findNavController(this, R.id.new_order_nav_host);

        NavigationUI.setupActionBarWithNavController(this, newOrderNavController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return newOrderNavController.navigateUp() || super.onSupportNavigateUp();
    }
}