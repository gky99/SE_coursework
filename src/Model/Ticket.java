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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

public class Ticket {
    /**
     * An auto increase variable to generate ticket number.
     */
    private static int iterationNumber = 0;
    String ticketNumber;

    public static ArrayList<Ticket> tickets = new ArrayList();

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
     * after each print, the iterationNumber add by 1
     */
    private void printTicket() {
        this.ticketNumber = Ticket.convertTicketNum(Ticket.iterationNumber++, 8);
        String filePath = "./tickets/";

        try {
            File file = new File(filePath + this.ticketNumber);
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

            outputStreamWriter.append("Ticket Number: " + this.ticketNumber);
            outputStreamWriter.append("Ticket Type: " + this.ticketType);
            if (this.studentID != null) {
                outputStreamWriter.append("Student ID:" + this.studentID);
            }
            outputStreamWriter.append("Film Name: " + this.play.film.movieName);
            outputStreamWriter.append("Play Time: " + this.play.startTime);
            outputStreamWriter.append("Screnn: " + this.play.screen.screenNum);
            outputStreamWriter.append("Seat: " + this.seat);
            outputStreamWriter.close();
        } catch (Exception e) {

        }
        Ticket.tickets.add(this);
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

    /**
     * Check the legality of the ticket.
     */
    public void confirm() throws Exception {
        if (ticketType.equals("Student")) {
            throw new IllegalArgumentException("Student ticket should contain student ID");
        }
        this.ticketPrice = countPrice(this.play.price, this.ticketType);
    }

    public static void main(String[] args) {
        System.out.println(Ticket.convertTicketNum(894, 8));
    }

    /**
     * Convert the iteration number into a ticket number in String type.
     */
    public static String convertTicketNum(int iterationNumber, int i) {
        if (iterationNumber > 65595) {
            return null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i > 1) {
                int temp = iterationNumber % 4;
                int next = iterationNumber / 4;
                stringBuilder.append(convertTicketNum(next, i - 1));
                stringBuilder.append(temp + 1);
                return stringBuilder.toString();
            } else {
                return "" + (iterationNumber + 1);
            }
        }
    }
}