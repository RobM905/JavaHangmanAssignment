package uk.ac.aber.dcs.hangman;



public class Word {
	private String word;
	
	/**
	 * Constructor for objects in the Word class
	 */
	public Word(String w){
		word=w;
	}
	/**
     * returns the String word to be used in other classes
     * @return  String word
     */
	public String getWord() {
		return word;
	}
	
	/**
     * Takes a String to be stored in the local word variable in the Word class
     * @param  String word to be assigned
     */
	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}
