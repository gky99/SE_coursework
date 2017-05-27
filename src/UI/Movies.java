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

package UI;

import Model.Film;
import Model.ShowTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Movies {

	public static void show(){
		ArrayList<Film> movies = new ArrayList<Film>();		
		ArrayList<JButton> buybutton = new ArrayList<JButton>();
        MFrame mFrame = new MFrame();
        JPanel mpanel = new JPanel();        
        JScrollPane mScrollPane=new JScrollPane(mpanel); 
        
        mScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

		movies = ShowTable.films;
		mpanel.setLayout(new GridLayout(movies.size(),4));
		for(int i=0; i < movies.size();i++){

			ImageIcon image = new ImageIcon(movies.get(i).pathToPicture);
			Image mimage = null;
        	mimage = image.getImage();
        	mpanel.add(new JLabel(new ImageIcon(mimage.getScaledInstance(190, 200, Image.SCALE_DEFAULT))));     
        	mpanel.add(new JLabel(movies.get(i).movieName));
        	mpanel.add(new JLabel(movies.get(i).filmLength + "min"));
        	buybutton.add(new JButton("Buy!"));
        	mpanel.add(buybutton.get(i));
        	buybutton.get(i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int n = 0;
					for(n=0;n<5;n++){
						if(e.getSource() == buybutton.get(n))
							break;
					}
					mFrame.dispose();
				//	ShowTable.plays.add(new Play(ShowTable.films.get(n),ShowTable.screens.get()))
					new TimeTable();
					TimeTable.show(n);
				} 
			});
        }
            
		mFrame.setLayout(new BorderLayout());
		mFrame.add(BorderLayout.CENTER, mScrollPane);
		mFrame.setVisible(true);
	}
}

