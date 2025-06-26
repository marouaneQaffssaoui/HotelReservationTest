package org.example.Entities;

public class Room {
    private int id;
    private RoomType roomType;
    private int pricePerNight;

    public Room(int id, RoomType roomType, int pricePerNight) {
        this.id = id;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType=" + roomType +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}
