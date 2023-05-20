package com.example.floation.asdosMenu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.floation.R;

public class PresensiAsdosFragment extends Fragment {

    TextView txtTitle;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presensi_asdos, container, false);
        txtTitle = view.findViewById(R.id.textTitle);

        txtTitle.setText("Attendance");

        return view;
    }
}