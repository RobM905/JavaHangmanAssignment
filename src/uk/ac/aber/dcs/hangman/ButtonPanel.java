package uk.ac.aber.dcs.hangman;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
		JButton word, letter;
        private JLabel letterGuesses, wordProgress, showGuesses;
        JTextField wordLabel, letterLabel;
        private GameModel gm;
        private int guesses;
        private PicturePanel picturePanel;
       
        /**
         * Constructor for objects in the ButtonPanel class
         */
        public ButtonPanel(PicturePanel pp) {
               
                gm = new GameModel();
                picturePanel=pp;
               
               
                
                
                word = new JButton("Guess Word");     //Creates the button to submit a word     
                word.addActionListener(new ActionListener() {     //adds ActionListener to button             
                        @Override
                        public void actionPerformed(ActionEvent e) {     //event handling code
                        	if(wordLabel.getText() != null && (!wordLabel.getText().equals(""))){ //if wordLabel isn't empty
                        			boolean winner = gm.tryWord(wordLabel.getText());  //set winner to return value from tryWord    
                        			wordLabel.setText(""); //sets the wordLabel to be empty again
                        			guesses = gm.guessLeft(); // sets new guesses
                        			showGuesses.setText("Guesses: "+guesses); //sets new guesses
                                if(guesses>0){ 
                                	picturePanel.setPicture("pirateGame"+guesses); //changes pirate picture as guessesLeft decreases 
                                }
                              if(guesses<=0) { //lose condition code
                                        wordLabel.setEditable(false); //stops user from using wordLabel
                                        letterLabel.setEditable(false);//stops user from using letterLabel
                                        picturePanel.setPicture("pirateGameLose");//sets new pirate picture
                                }
                                if (winner) { //win condition code
                                		
                                        wordProgress.setText(" Word to guess: "+gm.getVisible());//reveals hidden word
                                        wordLabel.setEditable(false);//stops user from using wordLabel
                                        letterLabel.setEditable(false);//stops user from using letterLabel
                                        picturePanel.setPicture("pirateGameWin");//sets new pirate picture
                                }
                        	}                    
                        
                        }
                });
 
                letter = new JButton("Guess Letter");  //Creates the button to submit a letter    
                letter.addActionListener(new ActionListener() {//adds ActionListener to button  
 
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	if(letterLabel.getText() != null && (!letterLabel.getText().equals(""))){//if letterLabel isn't empty
                                char gue = letterLabel.getText().charAt(0);// set gue to the first char inputted
                                boolean winner = gm.tryThis(gue); //set winner to return value from tryWord  
                                String i = gm.getLetters();
                                letterGuesses.setText(i);
                                String words = gm.getHidden();
                                wordProgress.setText(" Word to guess: "+words);//updates hidden word
                                letterLabel.setText("");
                                guesses = gm.guessLeft();
                                showGuesses.setText("Guesses: "+guesses);//updates guesses
                                if(guesses>0){
                                	picturePanel.setPicture("pirateGame"+guesses);//updates pirate picture
                                	
                                }
                                if(guesses<=0) {//lose condition code
                                        wordLabel.setEditable(false);
                                        letterLabel.setEditable(false);
                                        picturePanel.setPicture("pirateGameLose");//set pirate picture
                                }
                                if(winner) {//win condition code
                                        System.out.println("You win");
                                        wordLabel.setEditable(false);
                                        letterLabel.setEditable(false);
                                        picturePanel.setPicture("pirateGameWin");//set pirate picture
                                        
                                }
                        	}
                        }
                        
                       
                });
               
                JButton newWord = new JButton("New word");
                newWord.addActionListener(new ActionListener() {
                       
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                GameModel gm2 = new GameModel();
                                gm=gm2;
                                wordProgress.setText(" Word to guess: "+gm.getHidden());
                                showGuesses.setText("Guesses: "+gm.guessLeft());
                                letterGuesses.setText("");
                                wordLabel.setEditable(true);
                                letterLabel.setEditable(true);
                                picturePanel.setPicture("pirateGame10");
                        }
                });
                JPanel p = new JPanel();   //creates new panel             
                p.setLayout(new GridLayout(2,4));  //sets grid layout
                guesses = gm.guessLeft();
                wordLabel = new JTextField("");   
                letterLabel = new JTextField(""); 
                String letters = gm.getLetters();
                letterGuesses = new JLabel(" "+letters);    
                String words = gm.getHidden();
                wordProgress = new JLabel(" Word to guess: "+words);        
                int guesses = gm.guessLeft();          
                showGuesses = new JLabel("Guesses: "+guesses);
 
 
                	//adds all elements to Panel
                p.add(letter);     
                p.add(letterLabel); 
                p.add(letterGuesses);  
                p.add(showGuesses);
                p.add(word);       
                p.add(wordLabel);     
                p.add(wordProgress);   
                p.add(newWord);
                p.setBackground(Color.cyan);    
                p.setPreferredSize(new Dimension (700,50)); 
                add(p);  //adds       
        }      
 
}
