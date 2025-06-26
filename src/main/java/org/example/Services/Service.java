package org.example.Services;

import org.example.Entities.Booking;
import org.example.Entities.Room;
import org.example.Entities.RoomType;
import org.example.Entities.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Service {

    ArrayList<Room> rooms;
    ArrayList<User> users;
    ArrayList<Booking> bookings;

    public Service() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        Room existingRoom = findRoom(roomNumber);
        if (existingRoom == null) {
            Room newRoom= new Room(roomNumber, roomType, roomPricePerNight);
            rooms.add(newRoom);
        }else {
            existingRoom.setPricePerNight(roomPricePerNight);
            existingRoom.setRoomType(roomType);
        }
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if(room.getId() == roomNumber){
                return room;
            }
        }
        return null;
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        User existingUser = findUser(userId);
        if (existingUser == null) {
            System.out.println("User does not exist !!");
        }
        Room existingRoom = findRoom(roomNumber);
        if (existingRoom == null) {
            System.out.println("Room does not exist !!");
        }
        if(checkIn == null && checkOut == null || checkOut == null || checkIn == null){
            System.out.println("should enter check in/out date !!");
        }
        if(!checkIn.before(checkOut)){
            System.out.println("chech in must be before check out !!");
        }
        int roomPrice = existingRoom.getPricePerNight();
        int nights = calculateNight(checkIn, checkOut);
        int totalPrice = roomPrice*nights;

        if(existingUser.getBalance() < totalPrice){
            System.out.println("insufficient balance !!");
        }
        Boolean availableRoom = isRoomAvailable(existingRoom, checkIn, checkOut);

        if(!availableRoom){
            System.out.println("room is not available");
        }
        Booking booking =  new Booking(1, checkIn, checkOut, existingUser, existingRoom);

        int result = existingUser.getBalance() - totalPrice;

        existingUser.setBalance(result);

        bookings.add(booking);
    }

    private Boolean isRoomAvailable(Room existingRoom, Date checkIn, Date checkOut) {
        for (Booking booking : bookings){
            if(booking.getRoom().getId() == existingRoom.getId()){
                if ((checkOut.compareTo(booking.getCheckIn()) <= 0 || checkIn.compareTo(booking.getCheckOut()) >= 0)){
                    return false;
                }
            }
        }
        return true;
    }

    private int calculateNight(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        int nights = (int) (diff / (1000 * 60 * 60 * 24));
        return nights;
    }

    public void printAll() {
        for(int i = rooms.size() -1; i >= 0; i--){
            System.out.println(rooms.get(i));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

        for(int i = bookings.size() - 1; i >= 0; i--){
            Booking booking = bookings.get(i);
            System.out.println("Booking : userId =" + booking.getUser().getId() +
                    ", user balance = " + booking.getUser().getBalance() +
                    ", room number = " + booking.getRoom().getId() +
                    ", room type = " + booking.getRoom().getRoomType() +
                    ", room price = " + booking.getRoom().getPricePerNight() +
                    ", check in = " + simpleDateFormat.format(booking.getCheckIn()) +
                    ", check out = "+ simpleDateFormat.format(booking.getCheckOut()) + ". "
                    );
        }
    }

    public void setUser(int userId, int balance) {
        User existingUser = findUser(userId);
        if (existingUser == null) {
            User newUser = new User(userId, balance);
            users.add(newUser);
        }else {
            existingUser.setBalance(balance);
        }
    }

    private User findUser(int userId) {
        for (User user : users){
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void printAllUsers() {
        for(int i = users.size() - 1; i >= 0; i--){
            System.out.println(users.get(i));
        }
    }
}
