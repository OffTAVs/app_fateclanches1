package com.example.app_fateclanches.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UsuarioRetrofit {
    val BASE_URL = "https://meuapp.com/api/"
    private var retrofit:Retrofit?=null

    val usuario:Retrofit
        get(){
            if(retrofit==null){
                retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }
    val comida:Retrofit
        get(){
            if(retrofit==null){
                retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }



}