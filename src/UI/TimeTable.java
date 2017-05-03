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
import Model.ShowTable;

public class TimeTable {
	
	public static void show(int n) {
		// TODO Auto-generated constructor stub
		MFrame mFrame = new MFrame();
		ArrayList<Film> movies = new ArrayList<Film>();
		ArrayList<JButton> timebutton = new ArrayList<JButton>();
		JPanel mpanel=new JPanel();
		JButton back = new JButton("back");
		Calendar now = Calendar.getInstance();
		
		new ShowTable();
		movies = ShowTable.initFilms("./src/Movie/Movie.txt");
		
		 for(int i=0; i < (movies.get(n).time.size()-1);i++){
	        	
	        	timebutton.add(new JButton());
	        	timebutton.get(i).setPreferredSize(new Dimension(100,100));
	        	timebutton.get(i).setText(movies.get(n).time.get(i));
	        	mpanel.add(timebutton.get(i));
	        	timebutton.get(i).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						int n = 0;
						for(n=0;n<6;n++){
							if(e.getSource() == timebutton.get(n))
								break;
						}
						mFrame.dispose();    //for next UI
						
					} 
		         });
	        	
	        	String[] str = movies.get(n).time.get(i).split(":");
	        	int current = ((now.get(Calendar.HOUR_OF_DAY)*60) + now.get(Calendar.MINUTE));
	        	int showtime = ((Integer.parseInt(str[0])*60)+Integer.parseInt(str[1]));
	        	if(current > showtime){
	        		timebutton.get(i).setEnabled(false);

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
