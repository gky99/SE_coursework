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

import UI.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * Created by Pauli on 2017/4/7.
 */
public class ShowTable {
    static LocalDate date;

    public static ArrayList<Film> films;
    public static ArrayList<CinemaScreen> screens;

    public static ArrayList<Play> plays;

    /**
     * Initialize the date to today,
     * and all other variable according to text files.
     */
    public ShowTable() {
        //initFilms("./Movie/Movie.txt");
        screens = new ArrayList<CinemaScreen>();
        initCinemaScreens("F:\\SE_coursework\\out\\production\\SE_coursework\\Avalibleseats");

    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */

    public static ArrayList<Film> initFilms(String filePath) {
    	ArrayList<Film> movie = new ArrayList<Film>();
    	movie = Film.readMovie(filePath);
    	
    	for (int i = 0; movie.get(i)!= null;i++){
    		Film.readTime(movie.get(i));         	
        }
    	return movie;

    }
    

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initCinemaScreens(String filePath) {
    	for(int i=1;i<=3;i++){
    		CinemaScreen screen=new CinemaScreen(filePath,i);	
    		screens.add(screen);
    	}
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initPlays(String filePath) {
    }
    public static void main(String args[]){
        Film film=new Film("120","Lalaland","./");
        ShowTable st=new ShowTable();
        Play play=new Play(film, ShowTable.screens.get(1),LocalTime.now());
      SelectSeats se= new  SelectSeats();
      se.initiate(play);

    }
}
