/*
 * Copyright (c) 2017, Pauli Guan.
 *
 * Licensed under the General Public License, Version 2.0.
 * You may not use this file except in compliance with the Licese.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/gpl.txt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */

/**
 * Created by Pauli on 2017/4/4.
 */
package Model;

public class Ticket {
    private static int ticketNumber;

    Play play;

    String ticketType;
    String seat;
    String studentID;

    double ticketPrice;

    public Ticket(Play film, String ticketType, String seat, String studentID) {
        this.play = film;
        this.ticketType = ticketType;
        this.seat = seat;
        this.studentID = studentID;
        this.ticketPrice = countPrice(film.price, ticketType);
    }

    public Ticket() {
    }

    public Ticket(Play film, String ticketType, String seat) {
        this(film, ticketType, seat, null);
    }


    /**
     * Print ticket into the filePath;
     * after each print, the ticketNumber add by 1
     */
    private void printTicket() {
        String filePath;

    }

    /**
     * Count the ticket price according to the ticketType
     */
    public static double countPrice(double price, String ticketType) {
        if (ticketType.equals("Child")) {
            price = price / 2;
        } else if (ticketType.equals("Adult")) {

        } else if (ticketType.equals("Senior")) {
            price = price * 0.8;
        } else if (ticketType.equals("Student")) {
            price = price * 0.85;
        }
        return price;
    }

    public void confirm() throws Exception {
        if (ticketType.equals("Student")) {
            throw new IllegalArgumentException("Student ticket should contain student ID");
        }
        this.ticketPrice = countPrice(this.play.price, this.ticketType);
    }

    public static void main(String[] args) {
    }
}
