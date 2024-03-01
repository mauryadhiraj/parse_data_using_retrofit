package com.data.e_commerceproduct

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("rest/V1/productdetails/6701/253620?lang=en&store=KWD")
    fun getProductDetails(@Query("q")query: String):Call<MyData>

}
