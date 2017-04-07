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

package Model;

import java.time.LocalTime;

/**
 * Created by Pauli on 2017/4/7.
 */
public class ShowedFilm {
    Film film;
    CinemaScreen screen;
    AvailableSeats seats;

    LocalTime startTime;
//    LocalTime endTime;

    double price;

    /**
     * Init the availableSeats according to screen,
     * and init all other variables.
     */
    public ShowedFilm(Film film, CinemaScreen screen, LocalTime startTime) {
    }
}
