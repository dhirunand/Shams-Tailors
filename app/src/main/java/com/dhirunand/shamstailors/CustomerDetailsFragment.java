package com.dhirunand.shamstailors;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.santalu.maskara.widget.MaskEditText;

import java.util.Calendar;


public class CustomerDetailsFragment extends Fragment {

    Button saveAndContinueButton;
    TextInputLayout textInputName;
    TextInputLayout textInputPhone;
    TextInputLayout textInputCurrentDate;
    TextInputLayout textInputDeliveryDate;

    private MaskEditText deliveryDateMaskEditText;

    public CustomerDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity.itemMeasurementContainerArrayList.clear();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_details, container, false);

        saveAndContinueButton = view.findViewById(R.id.save_and_continue_button);
        textInputName = view.findViewById(R.id.text_input_name);
        textInputPhone = view.findViewById(R.id.text_input_phone);
        textInputCurrentDate = view.findViewById(R.id.text_input_current_date_masked);
        textInputDeliveryDate = view.findViewById(R.id.text_input_delivery_date_masked);
        deliveryDateMaskEditText = view.findViewById(R.id.text_input_maskEditText_delivery_date_masked);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //textInputCurrentDate.getEditText().setText(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.YEAR));


        saveAndContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmInput()) {
                    NavController customerDetailsSaveNavController = Navigation.findNavController(view);
                    customerDetailsSaveNavController.navigate(CustomerDetailsFragmentDirections.actionCustomerDetailsFragmentToSelectItemFragment(deliveryDateMaskEditText.getMasked()));
                }
            }
        });


    }


    private boolean validateName() {
        String usernameInput = textInputName.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String userPhoneInput = textInputPhone.getEditText().getText().toString().trim();

        if (userPhoneInput.isEmpty()) {
            textInputPhone.setError("Field can't be empty");
            return false;
        } else if (userPhoneInput.length() != 10) {
            textInputPhone.setError("Invalid Number");
            return false;
        } else {
            textInputPhone.setError(null);
            return true;
        }
    }

    private boolean validateCurrentDate() {
        String currentDateInput = textInputCurrentDate.getEditText().getText().toString().trim();

        if (currentDateInput.isEmpty()) {
            textInputCurrentDate.setError("Field can't be empty");
            return false;
        } else if (currentDateInput.length() != 10) {
            textInputCurrentDate.setError("Invalid Date");
            return true;
        } else {
            textInputCurrentDate.setError(null);
            return true;
        }
    }

    private boolean validateDeliveryDate() {
        String deliveryDateInput = textInputDeliveryDate.getEditText().getText().toString().trim();

        if (deliveryDateInput.isEmpty()) {
            textInputDeliveryDate.setError("Field can't be empty");
            return false;
        } else if (deliveryDateInput.length() != 10) {
            textInputDeliveryDate.setError("Invalid Date");
            return true;
        } else {
            textInputDeliveryDate.setError(null);
            return true;
        }
    }

    public boolean confirmInput() {
        if (validateName() && validatePhone() && validateCurrentDate() && validateDeliveryDate()) {
            return true;
        }
        return false;
    }


    public void getDateInput(TextInputLayout textInputLayout) {

        int mYear, mMonth, mDay;

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        StringBuffer currentDate = new StringBuffer("");

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                currentDate.append(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                textInputLayout.getEditText().setText(currentDate);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }
}