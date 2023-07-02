package com.example.sananismayilov.onlinedictionary.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sananismayilov.onlinedictionary.R;
import com.example.sananismayilov.onlinedictionary.RecylerView.Adaptertorecylerview;
import com.example.sananismayilov.onlinedictionary.RecylerView.ConteynerToWord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Adaptertorecylerview adaptertorecylerview;
ArrayList<ConteynerToWord> conteynerToWords;
ProgressBar progressBar;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.recylerview);
        getData();

    }


    public void getData(){
        conteynerToWords = new ArrayList<>();
        String url = "https://senan2.000webhostapp.com/DictionaryApp/getdata.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("dictionary");
                    for(int i=0;i<array.length();i++){
                        JSONObject object1 = array.getJSONObject(i);
                        ConteynerToWord conteyner = new ConteynerToWord(object1.getString("text_az"),object1.getString("text_en"));
                        conteynerToWords.add(conteyner);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                progressBar.setVisibility(View.INVISIBLE);
                adaptertorecylerview = new Adaptertorecylerview(conteynerToWords);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adaptertorecylerview);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }
}