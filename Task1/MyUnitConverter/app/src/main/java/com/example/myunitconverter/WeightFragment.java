package com.example.myunitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class WeightFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinnerFrom,spinnerTo;

    public static String ErrorMsg = "Plz choose the correct options";
    Button convert;
    EditText input;
    TextView output;
    double inputvalue,outputvalue;
    String case1,case2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_weight,container, false);
        spinnerFrom = view.findViewById(R.id.spinner_from);
        spinnerTo = view.findViewById(R.id.spinner_to);
        convert = view.findViewById(R.id.button_convert);
        input = view.findViewById(R.id.editText_Input);
        output = view.findViewById(R.id.editText_output);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(requireActivity()
                .getBaseContext(),
                R.array.Weight,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);


        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);

        convert.setOnClickListener(v -> {
            case1 = String.valueOf(spinnerFrom.getSelectedItem());
            case2 = String.valueOf(spinnerTo.getSelectedItem());
            inputvalue = Double.parseDouble(input.getText().toString());
           switch (case1) {
                case "Kilograms (Kg)":
                    switch (case2){
                        case "Kilograms (Kg)":
                            outputvalue = inputvalue;
                            output.setText(String.format("%s Kg", outputvalue));
                            break;
                        case "Gram (g)":
                            outputvalue = inputvalue * 1000;
                            output.setText(String.format("%s g", outputvalue));
                            break;
                        case "Ton (T)":
                            outputvalue = inputvalue / 1000;
                            output.setText(String.format("%s T", outputvalue));
                            break;
                        default:
                            Toast.makeText(requireActivity().getBaseContext(), ErrorMsg+ case2, Toast.LENGTH_SHORT)
                                    .show();
                    }
                    break;
                case "Gram (g)":
                    switch (case2){
                        case "Kilograms (Kg)":
                            outputvalue = inputvalue / 1000;
                            output.setText(String.format("%s Kg", outputvalue));
                            break;
                        case "Gram (g)":
                            outputvalue = inputvalue;
                            output.setText(String.format("%s g", outputvalue));
                            break;
                        case "Ton (T)":
                            outputvalue = inputvalue / 1000000;
                            output.setText(String.format("%s T", outputvalue));
                            break;
                        default:
                            Toast.makeText(requireActivity().getBaseContext(), ErrorMsg+ case2, Toast.LENGTH_SHORT)
                                    .show();
                    }
                    break;
                case "Ton (T)":
                    switch (case2){
                        case "Kilograms (Kg)":
                            outputvalue = inputvalue * 1000;
                            output.setText(String.format("%s Kg", outputvalue));
                            break;
                        case "Gram (g)":
                            outputvalue = inputvalue * 1000000;
                            output.setText(String.format("%s g", outputvalue));
                            break;
                        case "Ton (T)":
                            outputvalue = inputvalue;
                            output.setText(String.format("%s T", outputvalue));
                            break;
                        default:
                        Toast.makeText(requireActivity().getBaseContext(), ErrorMsg+ case2, Toast.LENGTH_SHORT)
                                .show();
                    }
                    break;
                default:
                    Toast.makeText(requireActivity().getBaseContext(), ErrorMsg, Toast.LENGTH_SHORT)
                            .show();
            }
        });


        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();


    }
    public void onNothingSelected(AdapterView<?> parent) { }
}