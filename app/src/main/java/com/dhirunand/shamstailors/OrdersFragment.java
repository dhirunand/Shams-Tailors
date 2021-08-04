package com.dhirunand.shamstailors;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OrdersFragment extends Fragment {
    Button newOrderButton;


    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newOrderButton = view.findViewById(R.id.newOrderButtonView);

        newOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavController order_navController = Navigation.findNavController(view);
//                order_navController.navigate(OrdersFragmentDirections.actionOrderFragmentToNewOrderNav());

                Intent intent = new Intent(view.getContext(), NewOrderActivity.class);
                startActivity(intent);
            }
        });


    }
}