package com.example.sananismayilov.onlinedictionary.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sananismayilov.onlinedictionary.R;
import com.example.sananismayilov.onlinedictionary.RecylerView.Adaptertorecylerview;
import com.example.sananismayilov.onlinedictionary.RecylerView.ConteynerToWord;
import com.example.sananismayilov.onlinedictionary.RecylerView.Dictionary;
import com.example.sananismayilov.onlinedictionary.Retrofit.RetrofitUtils;
import com.example.sananismayilov.onlinedictionary.Retrofit.Retrofitinterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Adaptertorecylerview adaptertorecylerview;
List<Dictionary> conteynerToWords;
ProgressBar progressBar;
Button button;
Retrofitinterface retrofitinterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.recylerview);
        retrofitinterface = RetrofitUtils.retrofitinterface();
        getData();

    }


    public void getData(){
    retrofitinterface.getdata().enqueue(new Callback<ConteynerToWord>() {
        @Override
        public void onResponse(Call<ConteynerToWord> call, Response<ConteynerToWord> response) {
            conteynerToWords = response.body().getDictionary();
            adaptertorecylerview = new Adaptertorecylerview(conteynerToWords);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(adaptertorecylerview);
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onFailure(Call<ConteynerToWord> call, Throwable t) {

        }
    });


    }
}