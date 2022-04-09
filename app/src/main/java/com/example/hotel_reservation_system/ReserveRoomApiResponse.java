package com.example.hotel_reservation_system;

public class ReserveRoomApiResponse extends ApiResponse {
    ReserveRoomData data;

    public ReserveRoomApiResponse(String message, Boolean success, ReserveRoomData data) {
        super(message, success);
        this.data = data;
    }

    public ReserveRoomApiResponse(ReserveRoomData data) {
        this.data = data;
    }

    public ReserveRoomData getData() {
        return data;
    }

    public void setData(ReserveRoomData data) {
        this.data = data;
    }
}
