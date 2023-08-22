package com.example.mad_assignment2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class AddShoppingList extends AppCompatActivity {

    private EditText quantityEditText;
    private Button incrementButton;
    private Button decrementButton;
    private int currentQuantity = 0;

    private EditText dateEditText;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping_list);

        quantityEditText = findViewById(R.id.quantityEditText);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuantity++;
                quantityEditText.setText(String.valueOf(currentQuantity));
            }
        });
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuantity > 0) {
                    currentQuantity--;
                    quantityEditText.setText(String.valueOf(currentQuantity));
                }
            }
        });

        dateEditText = findViewById(R.id.dateEditText);
        calendar = Calendar.getInstance();

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddShoppingList.this,
                        dateSetListener,
                        year,
                        month,
                        day
                );
                datePickerDialog.show();
            }
        });
    }

    private final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // Here, you can handle the selected date
                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    dateEditText.setText(selectedDate);
                }
            };


    }