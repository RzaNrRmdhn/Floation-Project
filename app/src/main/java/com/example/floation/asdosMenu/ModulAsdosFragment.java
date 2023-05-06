package com.example.floation.asdosMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.floation.R;

public class ModulAsdosFragment extends Fragment {

    TextView txTitle;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_modul_asdos, container, false);
        txTitle = view.findViewById(R.id.txtTitle);
        txTitle.setText("Modul Asdos");

        return view;
    }
}