package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Film;
import Model.ShowTable;

public class Movies {

	public static void show(){
		ArrayList<Film> movies = new ArrayList<Film>();		
		ArrayList<JButton> buybutton = new ArrayList<JButton>();
        MFrame mFrame = new MFrame();
        JPanel mpanel = new JPanel();        
        JScrollPane mScrollPane=new JScrollPane(mpanel); 
        
        mScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
		new ShowTable();
		movies = ShowTable.initFilms("./src/Movie/Movie.txt");
        mpanel.setLayout(new GridLayout((movies.size()-1),4));
        for(int i=0; i < (movies.size()-1);i++){

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
					for(n=0;n<6;n++){
						if(e.getSource() == buybutton.get(n))
							break;
					}
					mFrame.dispose();
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

