package com.mohzulfikar.crudproject.rest;

import com.mohzulfikar.crudproject.model.GetUser;
import com.mohzulfikar.crudproject.model.PostPutDetUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("users")
    Call<GetUser>getuser();
    @FormUrlEncoded
    @POST("users")
    Call<PostPutDetUser>postUser(@Field("name") String name,
                                 @Field("job") String job);
    @FormUrlEncoded
    @PUT("users")
    Call<PostPutDetUser>putUser(@Field("name") String name,
                                 @Field("job") String job);
    @FormUrlEncoded
    @HTTP(method = "DELETE",path = "users",hasBody = true)
    Call<PostPutDetUser>deleteUser(@Field("id") String id);


}
