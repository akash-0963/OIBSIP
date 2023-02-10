package com.example.myunitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView weight,temp,angle,curr;
    String msg = null;
    TextView result;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight_image);
        temp = findViewById(R.id.temp_image);
        angle = findViewById(R.id.angle_image);
        curr = findViewById(R.id.curr_image);

        weight.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, WeightFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
            result.setText("Weight Converter");
        });

        temp.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, TempFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
            result.setText("Temperature Converter");
        });

        curr.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, CurrencyFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
            result.setText("Currency Converter");
        });

        angle.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, AngleFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
            result.setText("Angle Converter");
        });

        result = findViewById(R.id.title_panel);
        result.setText("Weight Converter");
    }

}