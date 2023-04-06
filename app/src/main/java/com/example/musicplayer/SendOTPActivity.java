package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendOTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otpactivity);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        Button buttonGetOTP = findViewById(R.id.buttonGetOTP);

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTPActivity.this,"Enter Mobile",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplication(), VerifyOTPActivity.class);
                intent.putExtra("mobile", inputMobile.getText().toString());
                startActivity(intent);
            }
        });
    }
}