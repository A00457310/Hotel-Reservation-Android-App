package com.example.hotel_reservation_system;

public class ReserveRoomData {
    String confirmationId;

    public ReserveRoomData(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }
}
