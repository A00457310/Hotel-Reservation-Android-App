package com.example.hotel_reservation_system;

//@AllArgsConstructor
//@Data
public class HotelListData {

    String name;
    Integer id;
    String url;

    Integer noOfRooms;

    String price;
    Double rating;
    Boolean availability;

    public HotelListData(String name, Integer id, String url, Integer noOfRooms, String price, Double rating, Boolean availability) {
        this.name = name;
        this.id = id;
        this.url = url;
        this.noOfRooms = noOfRooms;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HotelListData(String name, String url, Integer noOfRooms, String price, Double rating, Boolean availability) {
        this.name = name;
        this.url = url;
        this.noOfRooms = noOfRooms;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public HotelListData(String name, Integer noOfRooms, String price, Double rating, Boolean availability) {
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public HotelListData() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    //    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getAvailability() {
//        return availability;
//    }
//
//    public void setAvailability(String availability) {
//        this.availability = availability;
//    }
}
