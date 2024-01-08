package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public Button btnBack ;
    private TextView edtReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtReceived = findViewById(R.id.edtReceived);

        //for set the number received from main activity
        String Number = getIntent().getStringExtra("Number");
        edtReceived.setText(Number);

        btnBack= findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Result = edtReceived.getText().toString();

                //convert string into integer
                int n = Integer.parseInt(Result);

                //multiply that number with 2
                int newN = n*2;

                //convert integer into string
                String  newResult = String.valueOf(newN);

                Intent intent = new Intent(SecondActivity.this ,MainActivity.class);

                //to send multiplied number from second activity to main activity
                intent.putExtra("newResult" , newResult);
                startActivity(intent);
            }
        });
    }
}