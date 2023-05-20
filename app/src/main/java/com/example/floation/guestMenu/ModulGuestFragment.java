package com.example.floation.guestMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.floation.R;


public class ModulGuestFragment extends Fragment {

    TextView txtTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_modul_guest, container, false);
        txtTitle = view.findViewById(R.id.txtTitle);

        txtTitle.setText("Modul Materi");
        return view;
    }
}