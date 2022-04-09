package com.example.hotel_reservation_system;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {

    // API's endpoints
    @GET("/hotel/")
    public void getHotelsLists(Callback<GetHotelResponse> callback);

    @POST("/hotel/reserve/")
    public void reserveRoom(@Body ReserveRoomRequestBody body, Callback<ReserveRoomApiResponse> callback);
    
}
