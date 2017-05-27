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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Pauli on 2017/4/7.
 */
public class ShowTable {
    public static LocalDate date;

    public static ArrayList<Film> films = new ArrayList<>();
    public static ArrayList<CinemaScreen> screens = new ArrayList<>();

    public static ArrayList<Play> plays = new ArrayList<>();

    /**
     * Initialize the date to today,
     * and all other variable according to text files.
     */
    public ShowTable() {
//        initFilms("/Users/ljy/Documents/SE_coursework/out/production/SE_coursework/Movie/");
//        initCinemaScreens("/Users/ljy/Documents/SE_coursework/out/production/SE_coursework/Avalibleseats");
//        initPlays("/Users/ljy/Documents/SE_coursework/out/production/SE_coursework/Movie/");

        initFilms("./Movie/");
        initCinemaScreens("./Avalibleseats");
        initPlays("./Movie/");
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    public static void initFilms(String filePath) {

        films = Film.readMovie(filePath + "Movie.txt");

    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private static void initPlays(String filePath) {
        BufferedReader reader = null;
        for (int i = 0; i < films.size(); i++) {
            try {
                File file = new File(filePath + films.get(i).movieName + ".txt");
                //File file = new File("./src/Movie/KONG SKULL ISLAND.txt");
                reader = new BufferedReader(new FileReader(file));
                String movieString = null;

                while ((movieString = reader.readLine()) != null) {
                    String[] str = movieString.split(",");
                    String screen = str[1].substring(6);
                    int hour = Integer.parseInt(str[0].substring(0, 2));
                    int minute = Integer.parseInt(str[0].substring(3, 5));
                    LocalTime showtime = LocalTime.of(hour, minute, 00);

                    Film film = films.get(i);
                    CinemaScreen cinemaScreen = screens.get(Integer.parseInt(screen) - 1);

                    plays.add(new Play(film, cinemaScreen, showtime));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println(films.get(i).movieName);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ShowTable test = new ShowTable();
        for (int i = 0; i < ShowTable.films.size(); i++) {
            System.out.println(ShowTable.films.get(i).movieName);
            System.out.println(ShowTable.films.get(i).filmLength);
            System.out.println(ShowTable.films.get(i).pathToPicture);
            System.out.println(ShowTable.plays.get(1).price);
            System.out.println(ShowTable.plays.get(1).startTime);
            System.out.println("====================");
        }
        System.out.println(ShowTable.plays.size());
    }

    /**
     * Initialize films according to text files
     *
     * @param filePath
     */
    private void initCinemaScreens(String filePath) {
        for (int i = 1; i <= 3; i++) {
            CinemaScreen screen = new CinemaScreen(filePath, i);
            screens.add(screen);
        }
    }
}