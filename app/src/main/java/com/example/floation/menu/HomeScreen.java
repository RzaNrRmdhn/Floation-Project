package com.example.floation.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.floation.R;
import com.example.floation.asdosMenu.DashBoardAsdosFragment;
import com.example.floation.asdosMenu.ModulAsdosFragment;
import com.example.floation.asdosMenu.PresensiAsdosFragment;
import com.example.floation.asdosMenu.SettingsAsdosScreen;
import com.example.floation.databinding.ActivityHomeScreenBinding;
import com.example.floation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeScreen extends AppCompatActivity {

    ActivityHomeScreenBinding binding;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtTitle = findViewById(R.id.textTitle);

        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DashBoardAsdosFragment());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(onMove);

        binding.fab.setOnClickListener(onShow);
    }

    @SuppressLint("NonConstantResourceId")
    NavigationBarView.OnItemSelectedListener onMove = item -> {
        switch (item.getItemId()) {
            case R.id.homeAsdos:
                replaceFragment(new DashBoardAsdosFragment());
                break;
            case R.id.presensiAsdos:
                replaceFragment(new PresensiAsdosFragment());
                break;
            case R.id.modulAsdos:
                replaceFragment(new ModulAsdosFragment());
                break;
            case R.id.settings:
                Intent moveScreen = new Intent(this, SettingsAsdosScreen.class);
                startActivity(moveScreen);
        }
        return true;
    };

    View.OnClickListener onShow = OnClick -> {
        showBottomDialog();
    };


    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomdialog);

        LinearLayout fileLayout = dialog.findViewById(R.id.layoutFile);
        LinearLayout cancelLayout = dialog.findViewById(R.id.layoutCancel);

        fileLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(HomeScreen.this,"Upload a File is clicked",Toast.LENGTH_SHORT).show();
        });

        cancelLayout.setOnClickListener(v -> dialog.dismiss());


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}