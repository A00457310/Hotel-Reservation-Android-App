package com.example.hotel_reservation_system;

import java.util.List;

public class ReserveRoomRequestBody {
    Integer userId;
    Integer hotelId;
    Integer noOfRoomsBooked;
    String checkInDate;
    String checkOutDate;
    List<GuestDetail> guests;

    public ReserveRoomRequestBody(Integer userId, Integer hotelId, Integer noOfRoomsBooked, String checkInDate, String checkOutDate, List<GuestDetail> guests) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guests = guests;
    }

    public ReserveRoomRequestBody() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public void setNoOfRoomsBooked(Integer noOfRoomsBooked) {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<GuestDetail> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestDetail> guests) {
        this.guests = guests;
    }
}
