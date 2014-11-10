package uk.ac.aber.dcs.hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class GameModel implements GameModelInterface{
	private ArrayList <Word> words;
	private String secretWord;
	private int guessesLeft=10;
	private String letters="";
	private String hiddenWord;
	

	/**
	 * Constructor for objects in the GameModel class
	 */
	public GameModel(){
		words=new ArrayList <Word>();
		this.load();
		this.randomWord();
		this.setHidden();
	}
	/**
     * Loads words from piratewords.txt into the words ArrayList
     */
	public void load(){
		try{ String fileName="piratewords.txt";
	        Scanner inFile =new Scanner((Readable) new InputStreamReader 
	                (new FileInputStream(fileName)));
	        int num=inFile.nextInt();inFile.nextLine();
	        for (int i=0;i<num;i++) {
	            String w=inFile.nextLine();
	            
	           Word temp=new Word(w);
	            words.add(temp);
	        }
	        inFile.close();
	        System.out.println("Load Successful");
	        
	       }
	       catch(IOException l){
	        System.out.println("File Could Not Be Loaded");
	        }
	    }
	
	/**
     * Masks the secretWord and sets it to HiddeonWord
     */
	public void setHidden(){
		hiddenWord= secretWord.replaceAll("[a-z]","*");
		}
	    
	
	/**
     * returns the secretWord String
      * @return  String secretWord
     */
	@Override
	public String getVisible() {
		return secretWord;
	}
	
	/**
     * returns the hiddenWord String
      * @return  String hiddenWord
     */
	@Override
	public String getHidden() {
		return hiddenWord;
	}
	
	/**
     * returns the guessesLeft String
      * @return  String guessesLeft
     */
	@Override
	public int guessLeft() {
		return guessesLeft;
	}

	/**
     * returns the letters String
      * @return  String letters
     */
	@Override
	public String getLetters() {
		return letters;
	}

	/**
     * Checks to see if the secretWord contains the input char letter
     * @param  Char letter inputed by the user
     * @return  boolean depending if there is a match
     */
	@Override
	public boolean tryThis(char letter) {
		
		int i = 0;
		boolean hmgame = false;
		for (char c:secretWord.toCharArray()){
			if(c==letter){
				this.hiddenWord = hiddenWord.substring(0,i)+letter+hiddenWord.substring(i+1);
				hmgame = true;		
			}
			i++;
		}
		if(!hmgame){
			letters += letter;
			guessesLeft-=1;			
		}
		if(this.hiddenWord.equals(secretWord)){
			return true;		
		}
		else{
			return false;
		}	
	}
	
	/**
     * Checks to see if the secretWord is equal to the inputed String guess
     * @param  String guess inputed by the user
     * @return  boolean depending if there is a match
     */
	@Override
	public boolean tryWord(String guess) {
	
		if(guess.equals(secretWord)){
			
			return true;
		}
		else{
			guessesLeft-=5;
			return false;
		}
	}
	
	/**
     * Creates randomGenerator and then gets a random word from the words ArrayList
     */
	public void randomWord(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(words.size());
		Word temp=words.get(randomInt);
		secretWord=temp.getWord();
		}
	
	
}

	
	

	


	
