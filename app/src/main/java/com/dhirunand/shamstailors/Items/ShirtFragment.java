package com.dhirunand.shamstailors.Items;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhirunand.shamstailors.ItemMeasurementContainer;
import com.dhirunand.shamstailors.R;

public class ShirtFragment extends Fragment {
    public static String itemName = "Shirt";
    Button saveShirtButton;
    Button clickShirtPicButton;

    private EditText lengthEditText, neckEditText, shoulderEditText, chestEditText, waistEditText, seatEditText, sleevesEditText, sleeveCircumEditText;
    ImageView showShirtPicImgView;
    TextView showShirtImageErrorTextView;

    private String length;
    private String neck;
    private String shoulder;
    private String chest;
    private String waist;
    private String seat;
    private String sleeves;
    private String sleeveCircum;
    private Bitmap imageBitmap;

    private static final int CAMERA_PIC_REQUEST = 101;
    ShirtFragmentArgs args;

    public ShirtFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        args = ShirtFragmentArgs.fromBundle(getArguments());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shirt, container, false);

        saveShirtButton = view.findViewById(R.id.save_shirt_continue);
        clickShirtPicButton = view.findViewById(R.id.button_choose_image);

        lengthEditText = view.findViewById(R.id.length_editText);
        neckEditText = view.findViewById(R.id.neck_editText);
        shoulderEditText = view.findViewById(R.id.shoulder_editText);
        chestEditText = view.findViewById(R.id.chest_editText);
        waistEditText = view.findViewById(R.id.waist_editText);
        seatEditText = view.findViewById(R.id.seat_editText);
        sleevesEditText = view.findViewById(R.id.sleeves_editText);
        sleeveCircumEditText = view.findViewById(R.id.sleeve_circum_editText);
        showShirtPicImgView = view.findViewById(R.id.show_shirt_ImageView);
        showShirtImageErrorTextView = view.findViewById(R.id.show_shirt_Image_error_textView);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        length = lengthEditText.getText().toString().trim();
        neck = neckEditText.getText().toString().trim();
        shoulder = shoulderEditText.getText().toString().trim();
        chest = chestEditText.getText().toString().trim();
        waist = waistEditText.getText().toString().trim();
        seat = seatEditText.getText().toString().trim();
        sleeves = sleevesEditText.getText().toString().trim();
        sleeveCircum = sleeveCircumEditText.getText().toString().trim();

        imageBitmap = null;


        clickShirtPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShirtImageErrorTextView.setVisibility(View.INVISIBLE);
                showShirtPicImgView.setVisibility(View.VISIBLE);

                Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });



        saveShirtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(lengthEditText.getText())) {  //For validating EditText use EditText#setError method for show error and for checking empty or null value use inbuilt android class TextUtils.isEmpty(strVar) which return true if strVar is null or zero length
                    lengthEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(neckEditText.getText())) {
                    neckEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(shoulderEditText.getText())) {
                    shoulderEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(chestEditText.getText())) {
                    chestEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(waistEditText.getText())) {
                    waistEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(seatEditText.getText())) {
                    seatEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(sleevesEditText.getText())) {
                    sleevesEditText.setError("Invalid input");
                } else if (TextUtils.isEmpty(sleeveCircumEditText.getText())) {
                    sleeveCircumEditText.setError("Invalid input");
                } else if (imageBitmap == null) {

                    showShirtPicImgView.setVisibility(View.INVISIBLE);
                    showShirtImageErrorTextView.setVisibility(View.VISIBLE);
                    showShirtImageErrorTextView.setError("Select Image");
                } else {

                    ItemMeasurementContainer itemMeasurementContainer1 = new ItemMeasurementContainer(itemName, args.getDeliveryDate(), length, neck, shoulder, chest, waist, seat, sleeves, sleeveCircum, imageBitmap);

                    NavController shirtFragmentSaveNavController = Navigation.findNavController(view);
                    shirtFragmentSaveNavController.navigate(ShirtFragmentDirections.actionShirtFragmentToMoreItemFragment(itemMeasurementContainer1, args.getDeliveryDate()));
                }

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_PIC_REQUEST) {
            assert data != null;
            imageBitmap = (Bitmap) data.getExtras().get("data");
            showShirtPicImgView.setImageBitmap(imageBitmap);
        }
    }
}