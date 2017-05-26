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

package Model;

import java.time.LocalTime;

/**
 * Created by Pauli on 2017/4/7.
 */
public class Play {
    /**
     * An alphabet list helped to trans row number to alphabets
     */
    private static final char[] alphabet = {'A','B','C','D','E'};

    public  Film film;
    private final CinemaScreen screen;
    AvailableSeats seats;

    public LocalTime startTime;
//    LocalTime endTime;

    double price;

    /**
     * Init the availableSeats according to screen,
     * and init all other variables.
     */
    public Play(Film film, CinemaScreen screen, LocalTime startTime) {
	    this.film = film;
        this.screen = screen;
        seats = new AvailableSeats(screen);
        this.startTime = startTime;
	    this.price = 16.0;
    }

    public Play(CinemaScreen screen) {
        this.screen = screen;
    }

    /**
     * Change the seat flag in seats to 0
     *
     * @return the seat mark like: A6, G8
     */
    private String takeASeat(int row, int col) {
	    if( seats.seats.get(row-1).get(col-1) == 1 ){
		    seats.seats.get(row-1).setElementAt(0,col-1);
		    return alphabet[row-1]+""+col;
	    }
	    else return ""+-1;
    }

    /**
     * Reverse process of takeASeat
     */
    private void returnASeat(String seat) {
	    int row = this.AtoI(seat.charAt(0));
	    int col = Integer.parseInt(String.valueOf(seat.charAt(1)));
	    if( seats.seats.get(row-1).get(col-1) == 0 ){
		    seats.seats.get(row-1).setElementAt(1,col-1);
	    }
    }

    /**
     * Transform the row number to alphabets
     */
    private char ItoA(int row) {
	    return alphabet[row-1];
    }

    /**
     * Transform the row mark to row number
     */
    private int AtoI(char mark) {
	    int i;
	    for( i=0; i<=4; i++){
		    if( alphabet[i] == mark ){
			    return i+1;
		    }
	    }
	    return -1;
    }

}
