package com.example.floation.guestMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.floation.R;

public class GuestScreen extends AppCompatActivity {

    Button btnGoo;
    Intent goIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_screen);

        btnGoo = findViewById(R.id.btnGo);
        btnGoo.setOnClickListener(onGo);
    }

    View.OnClickListener onGo = onCLick -> {
        if(onCLick.getId() == R.id.btnGo){
            goIntent = new Intent(this, GuestHomeScreen.class);
            startActivity(goIntent);
        }
    };
}