package com.example.floation.landingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.floation.login.LoginPage;
import com.example.floation.R;

public class LandingPageAttendance extends AppCompatActivity {

    Button btnNext, btnSkip;
    Intent moveIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_attendance);

        btnNext = findViewById(R.id.btnContinue);
        btnSkip = findViewById(R.id.buttonSkip);

        btnNext.setOnClickListener(onNext);
        btnSkip.setOnClickListener(onNext);
    }

    View.OnClickListener onNext = onClick -> {
        if(onClick.getId() == R.id.buttonContinue){
            moveIntent = new Intent (this, LoginPage.class);
        }else{
            moveIntent = new Intent (this, LoginPage.class);
        }
        startActivity(moveIntent);
        finish();
    };
}