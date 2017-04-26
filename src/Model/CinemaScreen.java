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
import java.util.Vector;

/**
 * Created by Pauli on 2017/4/7.
 */
public class CinemaScreen extends Seats {
    int screenNum;
    String filePath;
    /**
     * Initialize the seats into vectors with number of column of the seat
     * read out directly from the file.
     * 0 represents there isn't a seat there.
     *
     * @param filePath  Path to the screen info directory
     * @param screenNum screen number
     *                  <p>
     *                  The screen info text should be in [filePath]/screen[screenNum].txt
     */
    public CinemaScreen(String filePath, int screenNum) {
    	this.screenNum = screenNum;
        this.filePath =  filePath;
        String path=filePath+"/screen"+screenNum+".txt";
        File file = new File(path);
    	Reader reader = null;
    	
    	Vector<Vector<Integer>> seats=new Vector<Vector<Integer>>();
		try {
               reader = new InputStreamReader(new FileInputStream(file));
               int tempchar;
               
             
               Vector<Integer> list=new Vector<Integer>() ;
               while ((tempchar = reader.read()) != -1) {
            	   
                   if (((char) tempchar) != '\r'&&((char) tempchar) != '\n'&&((char) tempchar) != ',') {
                	  
                	   char a=(char) tempchar;
                	   int i=a-'0';
                	   if(i==0)
                	   list.add(-1);
                	   else
                	   list.add(i);
                	  
                	  }
                   if(((char) tempchar) == '\n'){
                	   seats.add(list);
                	  
                	   list=new Vector<Integer>() ;
                   }
               }
               reader.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
		this.seats=seats;
    }

    public CinemaScreen() {
    }
}
