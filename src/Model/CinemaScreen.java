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

/**
 * Created by Pauli on 2017/4/7.
 */
public class CinemaScreen extends Seats {
    int screenNum;

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
    }
}
