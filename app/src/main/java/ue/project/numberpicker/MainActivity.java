package ue.project.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNumberPicker;
    NumberPicker numberPicker1;
    Button btnActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumberPicker = findViewById(R.id.tvNumberPicker);
        numberPicker1 = findViewById(R.id.numberPicker1);
        btnActivity2 = findViewById(R.id.btnActivity2);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(10);
        tvNumberPicker.setText("User's number: " + numberPicker1.getValue());

        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                tvNumberPicker.setText("User's number: " + i1);
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity2 = new Intent(MainActivity.this, BirthDay.class);
                startActivity(activity2);
            }
        });
    }
}
