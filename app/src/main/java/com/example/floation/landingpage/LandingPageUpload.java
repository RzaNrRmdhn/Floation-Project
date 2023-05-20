package com.example.floation.landingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.floation.login.LoginPage;
import com.example.floation.R;

public class LandingPageUpload extends AppCompatActivity {

    Button btnNext, btnSkip;
    Intent moveIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_upload);

        btnNext = findViewById(R.id.buttonContinue);
        btnSkip = findViewById(R.id.buttonSkip);

        btnNext.setOnClickListener(clickContinue);
        btnSkip.setOnClickListener(clickContinue);
    }
    View.OnClickListener clickContinue = onClick -> {
        if(onClick.getId() == R.id.buttonContinue){
            moveIntent = new Intent (this, LandingPageAttendance.class);
        }else if(onClick.getId() == R.id.buttonSkip){
            moveIntent = new Intent (this, LoginPage.class);
        }
        startActivity(moveIntent);
    };
}