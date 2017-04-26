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

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Pauli on 2017/4/7.
 */
public class ShowTable {
    static LocalDate date;

    ArrayList<Film> films;
    ArrayList<CinemaScreen> screens;

    ArrayList<Play> plays;

    /**
     * Initialize the date to today,
     * and all other variable according to text files.
     */
    public ShowTable() {
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initFilms(String filePath) {
    	ArrayList<Film> movie = new ArrayList<Film>();
    	movie = Film.readMovie(filePath);
    	
    	for (int i = 0; movie.get(i)!= null;i++){
         	System.out.println(movie.get(i).movieName);
         	System.out.println(movie.get(i).pathToPicture);
         	System.out.println(movie.get(i).filmLength + " min");
        }
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initCinemaScreens(String filePath) {
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initPlays(String filePath) {
    }
}
