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

import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pauli on 2017/4/7.
 */
public class Report {
    private PrintWriter out = null;

    private PrintWriter open() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        String filePath = "./report/" + dateFormat.format(now);

        URL reportPath = Report.class.getResource(filePath);
        try {
            PrintWriter out = new PrintWriter(reportPath.getPath());
            return out;
        } catch (Exception e) {
            return null;
        }
    }



}
