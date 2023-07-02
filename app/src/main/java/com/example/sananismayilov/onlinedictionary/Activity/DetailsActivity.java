package com.example.sananismayilov.onlinedictionary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sananismayilov.onlinedictionary.R;
import com.example.sananismayilov.onlinedictionary.RecylerView.ConteynerToWord;

public class DetailsActivity extends AppCompatActivity {
TextView textViewEn,textViewAz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textViewAz = findViewById(R.id.textViewAz);
        textViewEn = findViewById(R.id.textViewEn);
        Intent intent = getIntent();
        String textAz = intent.getStringExtra("sentDictionaryAz");
        String textEn = intent.getStringExtra("sentDictionaryEn");
        textViewAz.setText(textAz);
        textViewEn.setText(textEn);
        textViewAz.setTextColor(Color.parseColor(intent.getStringExtra("Color")));



    }
}