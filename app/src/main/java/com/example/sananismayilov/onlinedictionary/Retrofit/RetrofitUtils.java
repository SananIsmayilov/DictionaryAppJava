package com.example.sananismayilov.onlinedictionary.Retrofit;

public class RetrofitUtils {
    public static String BASE_URL = "https://senan2.000webhostapp.com/";
    public static Retrofitinterface retrofitinterface(){
        return  RetrofitClient.getRetrofit(BASE_URL).create(Retrofitinterface.class);
    }
}
