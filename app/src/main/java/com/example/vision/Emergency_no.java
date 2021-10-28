package com.example.vision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class Emergency_no extends AppCompatActivity {

    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_no);
        getSupportActionBar().setTitle("Register Number");

        number = findViewById(R.id.numberEdit);
    }

    public void saveNumber(View view) {
        String numberString = number.getText().toString();
        if(numberString.length()==10){
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("ENUM", numberString);
            myEdit.apply();
            Emergency_no.this.finish();
        }else {
            Toast.makeText(this, "Enter Valid Number!", Toast.LENGTH_SHORT).show();
        }
    }
}