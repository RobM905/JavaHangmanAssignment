package uk.ac.aber.dcs.hangman;

import java.awt.*;

import javax.swing.JFrame;

 public class Display extends JFrame{
	private static final long serialVersionUID = 1L;
		private ButtonPanel buttonPan;     
		private PicturePanel picPan;
		
		
		/**
		 * Constructor for objects in the Display class
		 */
        public Display()  {              
        		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setTitle("Pirate Hangman Game"); //Give the window the title Pirate Hangman Game            
               
                picPan = new PicturePanel();   //Creates the JPanel           
                add(picPan,BorderLayout.CENTER); //Puts the JPanel in the JFrame
                       
                buttonPan = new ButtonPanel(picPan); //Creates the JPanel for the game controls        
                add(buttonPan,BorderLayout.SOUTH); //Puts the JPanel in the JFrame
               
                pack(); 
                setResizable(false); //Sets the JFrame window to non resizable           
        }
}
