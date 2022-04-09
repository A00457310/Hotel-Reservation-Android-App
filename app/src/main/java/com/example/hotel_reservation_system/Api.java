package com.example.hotel_reservation_system;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint("http://Hotelreservation-env.eba-avazyhss.us-east-1.elasticbeanstalk.com/") //Set the Root URL
                .setEndpoint("http://192.168.2.24:8081") //Set the Root URL
//                .setEndpoint("https://7712-134-41-196-67.ngrok.io") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}