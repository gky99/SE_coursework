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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pauli on 2017/4/7.
 */
public class Report {
    private OutputStreamWriter out = null;

    /**
     * Open an print writer and save it in out.
     */
    private OutputStreamWriter open() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        String filePath = "./report/" + dateFormat.format(now);

        try {
            File file = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

            return outputStreamWriter;
        } catch (Exception e) {
            return null;
        }
    }

    public Report() {
        try {
            open();
            filmStatistic();
            out.close();
        } catch (IOException e) {

        }
    }


    /**
     * Print the sale statistic.
     */
    private void filmStatistic() throws IOException{
        int total = 0;
        Map<String, Integer> types = new HashMap<String, Integer>(4);
        types.put("Child", 0);
        types.put("Adult", 0);
        types.put("Senior", 0);
        types.put("Student", 0);

        for (Film film : ShowTable.films) {
            int count = 0;
            for (Ticket ticket : Ticket.tickets) {
                if (ticket.play.film.movieName.equals(film.movieName)) {
                    count++;
                }
                for (Map.Entry<String, Integer> type : types.entrySet()) {
                    if (type.getKey().equals(ticket.ticketType)) {
                        type.setValue(type.getValue() + 1);
                    }
                }
            }
            out.append("Movie: " + film.movieName);
            out.append("Sales: " + count);
            out.append("\n");
            total += count;
        }
        for (Map.Entry<String, Integer> type : types.entrySet()) {
            out.append(type.getKey() + "ticket: " + type.getValue());
        }
        out.append("Total sale: " + total);
    }


}
