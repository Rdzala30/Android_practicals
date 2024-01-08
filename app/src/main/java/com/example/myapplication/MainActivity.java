package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button btnNext;
    private EditText edtTxtNumber;
    public TextView edtResultTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        edtTxtNumber = findViewById(R.id.edtTxtNumber);
        edtResultTxt = findViewById(R.id.edtResultText);

        //for set the result of multiplied number from second activity
        String newResult = getIntent().getStringExtra("newResult");
        edtResultTxt.setText(newResult);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number =edtTxtNumber.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                //to send number from main activity to second activity
                intent.putExtra("Number",number);
                startActivity(intent);
            }
        });
    }
}