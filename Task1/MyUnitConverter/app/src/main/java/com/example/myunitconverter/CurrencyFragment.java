package com.example.myunitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CurrencyFragment extends Fragment {

    Spinner spinnerFrom,spinnerTo;
    public static CurrencyFragment newInstance(String param1, String param2) {
        CurrencyFragment fragment = new CurrencyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_weight,container, false);
        spinnerFrom = (Spinner)view.findViewById(R.id.spinner_from);
        spinnerTo = (Spinner)view.findViewById(R.id.spinner_to);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(requireActivity().getBaseContext(), R.array.Currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
        return view;
    }
}