package org.example.Entities;

import java.util.Date;

public class Booking {

    private int id;
    private Date checkIn;
    private Date checkOut;
    private int totalPtice;
    private User user;
    private Room room;

    public Booking(int id, Date checkIn, Date checkOut, User user, Room room) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPtice = calculateTotalPrice(checkIn, checkOut, room.getPricePerNight());
        this.user = user;
        this.room = room;
        user.addBookings(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getTotalPtice() {
        return totalPtice;
    }

    public void setTotalPtice(int totalPtice) {
        this.totalPtice = totalPtice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private int calculateTotalPrice(Date checkIn, Date checkOut, int pricePerNight) {
        long diff = checkOut.getTime() - checkIn.getTime();
        int nights = (int) (diff/(1000*60*60*24));
        return nights*pricePerNight;
    }
}
