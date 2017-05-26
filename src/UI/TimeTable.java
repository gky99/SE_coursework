package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Film;
import Model.Play;
import Model.ShowTable;

public class TimeTable {
	public static void show(int n) {
		// TODO Auto-generated constructor stub
		MFrame mFrame = new MFrame();
		ArrayList<Film> movies = new ArrayList<Film>();
		ArrayList<TimeButton> timebutton = new ArrayList<TimeButton>();
		JPanel mpanel=new JPanel();
		JButton back = new JButton("back");
		Calendar now = Calendar.getInstance();
		int j = 0;
		int i =0;

		movies = ShowTable.films;
		 for(i = 0; i < ShowTable.plays.size(); i++){
	        	if(movies.get(n).movieName.equals(ShowTable.plays.get(i).film.movieName)){

					timebutton.add(new TimeButton());
					timebutton.get(j).setPreferredSize(new Dimension(100,100));
					timebutton.get(j).setText(ShowTable.plays.get(i).startTime.toString());
					timebutton.get(j).setTime(i);
					mpanel.add(timebutton.get(j));
					timebutton.get(j).addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							int n = 0;
							for(n=0;n<ShowTable.plays.size();n++){
								if(e.getSource() == timebutton.get(n))
									break;
							}
							mFrame.dispose();//for next UI
							Play forNext = ShowTable.plays.get(timebutton.get(n).getTime());

						}
					});


					int current = ((now.get(Calendar.HOUR_OF_DAY)*60) + now.get(Calendar.MINUTE));
					int showtime = ((ShowTable.plays.get(i).startTime.getHour()*60)+ShowTable.plays.get(i).startTime.getMinute());
					if(current > showtime){
						timebutton.get(j).setEnabled(false);

					}
					j++;
				}

		 }
		 
		 back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					mFrame.dispose();
					new Movies();
					Movies.show();
				} 
			});
		 
		 mFrame.setLayout(new BorderLayout());
		 mFrame.add(BorderLayout.CENTER,mpanel);
		 mFrame.add(BorderLayout.SOUTH,back);
		 
		 
	}

}
