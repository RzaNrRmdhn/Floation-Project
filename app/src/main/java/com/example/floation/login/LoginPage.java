package com.example.floation.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.floation.R;
import com.example.floation.menu.HomeScreen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class LoginPage extends AppCompatActivity {
    String inputNpm, inputNama;
    Button btnLogin, btnGuest;
    EditText txtNpm, txtNama;
    Intent nextIntent;
    LoginSession sessionLogin = new LoginSession();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        btnLogin = findViewById(R.id.buttonLogin);
        txtNpm = findViewById(R.id.txtNPM);
        txtNama = findViewById(R.id.txtUser);

        btnLogin.setOnClickListener(onLogin);
    }

    View.OnClickListener onLogin = onClick -> {
        if (onClick.getId() == R.id.buttonLogin) {
            inputNama = txtNama.getText().toString();
            inputNpm = txtNpm.getText().toString().trim();

            if (checkInput(inputNama)) {
                txtNama.setError("Field Tidak Boleh Kosong!");
                Toast.makeText(this, "Gagal Login!", Toast.LENGTH_SHORT).show();

            } else if (checkInput(inputNpm)) {
                txtNpm.setError("Field Tidak Boleh Kosong!");
                Toast.makeText(this, "Gagal Login!", Toast.LENGTH_SHORT).show();

            }else{
                dbRef.child("Mahasiswa").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child(inputNpm).exists()){
                            if(Objects.equals(snapshot.child(inputNpm).child("User").getValue(String.class), inputNama)){
                                if(Objects.equals(snapshot.child(inputNpm).child("Roles").getValue(String.class), "Asdos")){
                                    sessionLogin.setDataLogin(LoginPage.this, true);
                                    nextIntent = new Intent(LoginPage.this, HomeScreen.class);
                                    Toast.makeText(LoginPage.this, "Berhasil login!", Toast.LENGTH_SHORT).show();
                                    startActivity(nextIntent);
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }
    };

    private boolean checkInput(String checkinput) {
        return TextUtils.isEmpty(checkinput);
    }
}