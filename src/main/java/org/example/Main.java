package org.example;

import org.example.Entities.RoomType;
import org.example.Services.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Service services = new Service();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        services.setRoom(1, RoomType.STANDARD, 1000);
        services.setRoom(2, RoomType.JUNIOR, 2000);
        services.setRoom(3, RoomType.MASTER, 3000);

        services.setUser(1, 5000);
        services.setUser(2, 10000);

        services.bookRoom(
                1,
                2,
                simpleDateFormat.parse("30/06/2026"),
                simpleDateFormat.parse("07/07/2026")
        );

        services.bookRoom(
                1,
                1,
                simpleDateFormat.parse("07/07/2026"),
                simpleDateFormat.parse("30/06/2026")
        );

        services.bookRoom(2,
                1,
                simpleDateFormat.parse("07/07/2026"),
                simpleDateFormat.parse("09/07/2026")
        );
        services.bookRoom(2,
                3,
                simpleDateFormat.parse("07/07/2026"),
                simpleDateFormat.parse("08/07/2026")
        );

        services.printAll();

        services.printAllUsers();

    }
}