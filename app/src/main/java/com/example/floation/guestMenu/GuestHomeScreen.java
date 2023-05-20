package com.example.floation.guestMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.floation.R;
import com.example.floation.asdosMenu.DashBoardAsdosFragment;
import com.example.floation.databinding.ActivityGuestHomeScreenBinding;
import com.google.android.material.navigation.NavigationBarView;

public class GuestHomeScreen extends AppCompatActivity {

    ActivityGuestHomeScreenBinding binding;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtTitle = findViewById(R.id.textTitle);

        binding = ActivityGuestHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DashBoardGuestFragment());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(onMove);

    }

    @SuppressLint("NonConstantResourceId")
    NavigationBarView.OnItemSelectedListener onMove = item -> {
        switch (item.getItemId()) {
            case R.id.homeGuest:
                replaceFragment(new DashBoardGuestFragment());
                break;
            case R.id.modulGuest:
                replaceFragment(new ModulGuestFragment());
                break;
            case R.id.settings:
                Intent moveScreen = new Intent(this, SettingGuestScreen.class);
                startActivity(moveScreen);
        }
        return true;
    };


    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}