package UI;

import javax.swing.*;
import java.awt.*;

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
