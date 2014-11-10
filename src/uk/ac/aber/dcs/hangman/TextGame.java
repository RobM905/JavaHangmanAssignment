package uk.ac.aber.dcs.hangman;

import java.util.*;



public class TextGame {
	
	private Scanner input;
	private GameModel gameM;
	private String response;
	private boolean win;
	
	
	/**
 * Constructor for objects in the TextGame class
 */
	public TextGame(){
		 input=new Scanner(System.in);
		 gameM= new GameModel();
	}
	/**
     * Runs the textGame
     */
	public void runTextGame(){
		
		
		do{
			printMenu();
			response=input.nextLine();
			
			if(response.equals("L") || response.equals("l")){
				System.out.println("Enter letter to guess: ");
				char guess=input.nextLine().charAt(0);
			
				if(gameM.tryThis(guess)==(true)){
					System.out.println("The word does contain "+guess+"!");
					win=true;
					System.out.println("Congratulations");
					System.out.println("You win!");
				}
					else{
						
						//System.out.println("Nope, That's not right! Loose a turn.");
						}
					
			
			}
				
			
			else if(response.equals("W") || response.equals("w")){
				System.out.println("Enter word to guess: ");
				String guessWord=(input.nextLine());
				
				if(gameM.tryWord(guessWord)==true){
					System.out.println("Yes! The word is "+guessWord+"!");
					System.out.println("Congratulations");
					System.out.println("You win!");
					win=true;
					
						}
				else{
					System.out.println("Wrong! The word isn't "+guessWord+"! Loose 5 turns.");
					
					
				}
		}
		
			else if(response.equals("q") || (response.equals("Q"))){
			System.out.println("Too Hard for You?!");
			break;
			
		}
			
	}
		while(!((win)||gameM.guessLeft()<=(0)));
	
		
}
	
	
	
	/**
     * Prints the menu
     */
		public void printMenu(){
		System.out.println("You have "+gameM.guessLeft()+" turns left. \n");
        System.out.println("So far you have used the following letters:");
        System.out.println(gameM.getLetters()+"\n");
        System.out.println("");
        System.out.println("The word to guess is: "+gameM.getHidden()+"\n");
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("L - Guess a Letter");    
        System.out.println("W - Guess a Word");
        System.out.println("Q - Quit the Game");  

		
	}
	
	
		
		
}


