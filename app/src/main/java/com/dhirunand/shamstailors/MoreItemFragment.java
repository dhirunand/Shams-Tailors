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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class MoreItemFragment extends Fragment {
    Button addMoreButton;
    Button addMoreFinishButton;
    ListView moreItemListView;
    MoreItemFragmentArgs args;
    AddMoreItemCustomAdapter addMoreItemCustomAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        args = MoreItemFragmentArgs.fromBundle(getArguments());

        MainActivity.itemMeasurementContainerArrayList.add(args.getItem());

        addMoreItemCustomAdapter = new AddMoreItemCustomAdapter(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_item, container, false);

        addMoreButton = view.findViewById(R.id.add_more_button);
        addMoreFinishButton = view.findViewById(R.id.add_more_finish_button);
        moreItemListView = view.findViewById(R.id.more_item_list_view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moreItemListView.setAdapter(addMoreItemCustomAdapter);

        NavController moreItemFragmentNavController = Navigation.findNavController(view);

        addMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreItemFragmentNavController.navigate(MoreItemFragmentDirections.actionMoreItemFragmentToSelectItemFragment(args.getDeliveryDate()));
            }
        });

        addMoreFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreItemFragmentNavController.navigate(MoreItemFragmentDirections.actionMoreItemFragmentToFinishOrderFragment());
            }
        });

    }
}