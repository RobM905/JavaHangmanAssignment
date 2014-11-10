package uk.ac.aber.dcs.hangman;
public class PirateApp {
	public static void main(String[] args){
   if (args.length != 0){
          if (args[0].equals("-t")){
            	TextGame game= new TextGame();
            	game.runTextGame();
            }
    }
   else{
   	Display display=new Display();
   	display.setVisible(true);
   }
}
}