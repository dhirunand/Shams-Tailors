package com.dhirunand.shamstailors;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SelectItemFragment extends Fragment {

    ListView listView;


    public SelectItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.item_listView);
        String[] itemArray = {"Shirt", "Pant", "Kurta", "Pajama", "Salwar", "Bandi", "Coat", "Sherwani", "Khan Suit", "Others(Specify)"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, itemArray);
        listView.setAdapter(adapter);

        SelectItemFragmentArgs args = SelectItemFragmentArgs.fromBundle(getArguments());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NavController customerDetailsSaveNavController = Navigation.findNavController(view);
                customerDetailsSaveNavController.navigate(SelectItemFragmentDirections.actionSelectItemFragmentToShirtFragment(args.getDeliverDate()));

            }
        });

    }
}