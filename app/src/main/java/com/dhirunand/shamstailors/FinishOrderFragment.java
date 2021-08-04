package com.dhirunand.shamstailors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FinishOrderFragment extends Fragment {
    ListView moreItemListView;
    AddMoreItemCustomAdapter addMoreItemCustomAdapter;
    Button finishOrderButton;

    public FinishOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addMoreItemCustomAdapter = new AddMoreItemCustomAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finish_order, container, false);

        finishOrderButton = view.findViewById(R.id.finish_order_button);

        moreItemListView = view.findViewById(R.id.items_list_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moreItemListView.setAdapter(addMoreItemCustomAdapter);
        finishOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadT0DataBase();
            }
        });

    }

    private void uploadT0DataBase() {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("customers");
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("customers");

        myRef.setValue("Hello, World!");
    }
}