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
 * the Free Software Foundation, either version 3 of the License, or
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

    ShowedFilm film;

    String ticketType;

    double ticketPrice;

    public Ticket(ShowedFilm film, String ticketType) {
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
    public static int countPrice(int price, String ticketType) {
        return price;
    }

    public static void main(String[] args) {
    }
}
