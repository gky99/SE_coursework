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

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Pauli on 2017/4/7.
 */
public class AvailableSeats extends Seats {
    /**
     * Initialize the seats into vectors with 0 and 1
     * 0 represents the seat there is taken or there isn't a seat there
     * 1 represents the seat is available there
     *
     * @param seats initialize the availableSeats according to existing seat vector.
     */

    public AvailableSeats(Seats seats) {
        this.seats = new Vector<Vector<Integer>>();
        for (int i = 0; i < seats.seats.size(); i++){
            Vector<Integer> list = seats.seats.get(i);
            Vector<Integer> list2 = new Vector<Integer>();
            for(int j=0;j<list.size();j++) {
                list2.add(list.get(j));
            }
            this.seats.add(list2);

        }
    }

    public AvailableSeats() {
    }

}
