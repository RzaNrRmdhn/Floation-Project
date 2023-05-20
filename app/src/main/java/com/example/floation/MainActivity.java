package com.example.floation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.floation.databinding.ActivityMainBinding;
import com.example.floation.landingpage.LandingPageUpload;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent startIntent = new Intent(this, LandingPageUpload.class);
        startActivity(startIntent);

        finish();
    }
}