package com.example.sananismayilov.onlinedictionary.Retrofit;

import com.example.sananismayilov.onlinedictionary.RecylerView.ConteynerToWord;
import com.example.sananismayilov.onlinedictionary.RecylerView.Dictionary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofitinterface {
    @GET("DictionaryApp/getdata.php")
    Call<ConteynerToWord>getdata();
}
