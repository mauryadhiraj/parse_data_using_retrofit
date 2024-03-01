package com.data.e_commerceproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://klinq.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
            val retrofitData = retrofitBuilder.getProductDetails("eminem")

        retrofitData.enqueue(object :Callback<MyData?>{
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList=response.body()?.data
                val textView = findViewById<TextView>(R.id.textView)
                textView.text= dataList.toString()
                Log.d("TAG:onResponse","onResponse: "+response.body())
            }
            override fun onFailure(call: Call<MyData?>, t:Throwable){
                Log.d("TAG:onFailure","onFailure: "+ t.message)
            }
        })


    }
}