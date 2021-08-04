package com.dhirunand.shamstailors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.inflate;

public class AddMoreItemCustomAdapter extends BaseAdapter {
    Context context;

    public AddMoreItemCustomAdapter(Context applicationContext) {
        context = applicationContext;
    }


    @Override
    public int getCount() {
        return MainActivity.itemMeasurementContainerArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return MainActivity.itemMeasurementContainerArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflate(context, R.layout.add_more_list_item, null);

        ImageView itemPicImageView = view.findViewById(R.id.item_pic_imageView);
        TextView itemNameTextView, itemPrice, deliveryDate;
        itemNameTextView = view.findViewById(R.id.item_name);
//        itemPrice = view.findViewById(R.id.item_price);
//        deliveryDate = view.findViewById(R.id.delivery_date);

        itemNameTextView.setText(MainActivity.itemMeasurementContainerArrayList.get(i).getItemName());//itemMeasurementContainer[i].getItemName());
//        itemPrice.setText(MainActivity.itemMeasurementContainerArrayList.get(i).getItemName());
//        deliveryDate.setText(MainActivity.itemMeasurementContainerArrayList.get(i).getDeliveryDate());
        itemPicImageView.setImageBitmap(MainActivity.itemMeasurementContainerArrayList.get(i).getItemImageBitmap());

        return view;
    }

}
