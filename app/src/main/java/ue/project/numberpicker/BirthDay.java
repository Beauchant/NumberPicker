package ue.project.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class BirthDay extends AppCompatActivity {

    TextView tvBirthDay;

    NumberPicker dayPicker;
    NumberPicker monthPicker;
    NumberPicker yearPicker;

    Button btnBirthDay;

    String[] months;
    String day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_day);

        tvBirthDay = findViewById(R.id.tvBirthDay);

        dayPicker = findViewById(R.id.dayPicker);
        monthPicker = findViewById(R.id.monthPicker);
        yearPicker = findViewById(R.id.yearPicker);

        btnBirthDay = findViewById(R.id.btnBirthDay);

        // Setup month picker
        months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        monthPicker.setMinValue(0);
        monthPicker.setMaxValue(11);
        monthPicker.setValue(0);
        monthPicker.setDisplayedValues(months);
        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                month = months[i1];
            }
        });

        // Setup day picker
        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(31);
        dayPicker.setValue(15);
        dayPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                day = String.valueOf(i1);
            }
        });

        // Setup year picker
        yearPicker.setMinValue(1900);
        yearPicker.setMaxValue(2022);
        yearPicker.setValue(2010);
        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                year = String.valueOf(i1);
            }
        });

        btnBirthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";

                if(day == null || month == null || year == null){
                    text = "User's birthday: " + dayPicker.getValue() + " " + months[monthPicker.getValue()] + " " + yearPicker.getValue();
                    tvBirthDay.setText(text);
                }
                else {
                    text = "User's birthday: " + day + " " + month + " " + year;
                    tvBirthDay.setText(text);
                }
            }
        });
    }
}
