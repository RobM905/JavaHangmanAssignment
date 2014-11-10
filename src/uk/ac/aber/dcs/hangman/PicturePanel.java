package uk.ac.aber.dcs.hangman;
import java.awt.*;

import javax.swing.*;
 
public class PicturePanel extends JPanel {                     
     private static final long serialVersionUID = 1L;
     private JLabel imageLabel;

     /**
      * Constructor for objects in the PicturePanel class
      */
		public PicturePanel() {                
                imageLabel = new JLabel(new ImageIcon("images/pirateGame10.jpg"),JLabel.CENTER);
            	add(imageLabel, BorderLayout.CENTER );
            	this.setPreferredSize(new Dimension(700,500));                 
                }
		/**
	     * Takes the input String and uses it to find and change the imageLabel
	     * @param  String imamge supplied by the ButtonPanel class
	     */
		public void setPicture(String image){
			this.remove(imageLabel); 
			imageLabel = new JLabel(new ImageIcon("images/"+image+".jpg"),JLabel.CENTER); 
			add(imageLabel);
			
			
		}
       
}


