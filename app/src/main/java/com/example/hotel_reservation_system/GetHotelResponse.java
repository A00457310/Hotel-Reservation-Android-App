package com.example.hotel_reservation_system;

import java.util.List;

public class GetHotelResponse extends ApiResponse {
    List<HotelListData> data;

    public GetHotelResponse(String message, Boolean success, List<HotelListData> data) {
        super(message, success);
        this.data = data;
    }

    public GetHotelResponse(List<HotelListData> data) {
        this.data = data;
    }


    public List<HotelListData> getData() {
        return data;
    }

    public void setData(List<HotelListData> data) {
        this.data = data;
    }
}
