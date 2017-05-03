package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MFrame extends JFrame {

	 public MFrame(){
	        super();
	        this.setSize(800,600);
	        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width -800)/2),
	        		         ((Toolkit.getDefaultToolkit().getScreenSize().height-600)/2));
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

}
