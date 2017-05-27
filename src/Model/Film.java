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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pauli on 2017/4/7.
 */
public class Film {
    public String filmLength;

    public String movieName;

    public String pathToPicture;


    public Film(String filmLength, String movieName, String pathToPicture) {

        this.filmLength = filmLength;
        this.movieName = movieName;
        this.pathToPicture = pathToPicture;
    }


    /*read all movies*/
    public static ArrayList<Film> readMovie(String filePath) {
        String Path = filePath;
        File file = new File(Path);
        ArrayList<Film> film = new ArrayList<Film>();
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));
            String movieString = null;

            while ((movieString = reader.readLine()) != null) {
                String[] str = movieString.split(",");
                film.add(new Film(str[1], str[0], str[2]));

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return film;
    }
}

