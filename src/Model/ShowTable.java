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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Pauli on 2017/4/7.
 */
public class ShowTable {
    LocalDate date;

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
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initCinemaScreen(String filePath) {
    	ArrayList<ArrayList<Integer>> seats=null; 
    	File file = new File(filePath);
    	Reader reader = null;
		try {
               reader = new InputStreamReader(new FileInputStream(file));
               int tempchar;
               
               ArrayList<Integer> list=new ArrayList<Integer>() ;
               while ((tempchar = reader.read()) != -1) {
            	   
                   if (((char) tempchar) != '\r'&&((char) tempchar) != '\n'&&((char) tempchar) != ',') {
                	  
                	   char a=(char) tempchar;
                	   int i=a-'0';
                	   list.add(i);
                	  
                	  }
                   if(((char) tempchar) == '\n'){
                	   seats.add(list);
                	   list=new ArrayList<Integer>() ;
                   }
               }
               reader.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initPlay(String filePath) {
    }
}
