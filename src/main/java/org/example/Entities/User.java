package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private int balance;
    private List<Booking> bookings;

    public User(int id, int balance) {
        this.id = id;
        this.balance = balance;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBookings(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", balance=" + balance +
                ", bookings=" + bookings +
                '}';
    }
}
