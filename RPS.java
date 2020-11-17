import javax.swing.JOptionPane;
import java.util.Random;

//used to declare WIN,LOOSE,TIE as constants
enum RESULT{
   WIN,LOOSE,TIE
}
public class RPS {
   //Simple constants 
   public static final int ROCK = 1;
   public static final int PAPER = 2;
   public static final int SCISSORS = 3;
   public static RESULT result;
  //Main class 
   public static void main(String[] args) {
    //Asks the user if he/she wants to play RPS game, Y for yes, N to exit.
    String askToPlay;
    askToPlay = JOptionPane.showInputDialog("Do you want to play ROCK PAPER SCISSORSs game?Y/N");
    //If statement, Y to call play method or N/anything else to exit program.
    //Added "IgnoreCase" to allow both lowerCase and upperCase Y as input for yes.
    if(askToPlay.equalsIgnoreCase("Y")){
        play();
    }else{
        System.exit(0);
    }
   }
  
   //Method to play the game
   public static void play(){
       //Variable to keep track of user win count
       int userWin=0;
       //Variable to keep track of CPU win count
       int CPUWin=0; 
       //Generates a random number
       Random rnd = new Random(); 
       do{
       int input;
       String str;
       str = JOptionPane.showInputDialog("Pick 1,2, or 3 for : \n ROCK (1), PAPER(2), or SCISSORS (3)");
       input = Integer.parseInt(str);
   //Generating random number between 1-3    
   int randomNumber = rnd.nextInt(3 - 1 + 1) + 1; 
   //Checks all the conditions
   if (randomNumber == ROCK) { 
               if (input == ROCK) {
                   JOptionPane.showMessageDialog(null, "ROCK beats ROCK");
                   result=RESULT.TIE;
               } else if (input == PAPER) {
                   JOptionPane.showMessageDialog(null, "PAPER beats ROCK");
                   result=RESULT.WIN;
                   userWin++;
               } else if (input == SCISSORS) {
                   JOptionPane.showMessageDialog(null, "ROCK beats SCISSORS");
                   CPUWin++;
                   result=RESULT.LOOSE;
               }
           } else if (randomNumber == PAPER) {
               if (input == ROCK) {
                   JOptionPane.showMessageDialog(null, "PAPER beats ROCK");
                   result=RESULT.LOOSE;
                   CPUWin++;
               } else if (input == PAPER) {
                   JOptionPane.showMessageDialog(null, "PAPER beats PAPER");
                   result=RESULT.TIE;
               } else if (input == SCISSORS) {
                   JOptionPane.showMessageDialog(null, "SCISSORS beats PAPER");
                   result=RESULT.WIN;
                   userWin++;
               }

           } else if (randomNumber == SCISSORS) {
               if (input == ROCK) {
                   JOptionPane.showMessageDialog(null, "ROCK beats SCISSORS");
                   result=RESULT.WIN;
                   userWin++;
               } else if (input == PAPER) {
                   JOptionPane.showMessageDialog(null, "SCISSORS beats PAPER");
                   result=RESULT.LOOSE;
                   CPUWin++;
               } else if (input == SCISSORS) {
                   JOptionPane.showMessageDialog(null, "SCISSORS beats SCISSORS");
                   result=RESULT.TIE;
               }
           }
        JOptionPane.showMessageDialog(null, "You "+result+" this round");
       //Exit loop when user or CPU wins twice   
       }while(userWin < 2 && CPUWin < 2);
      
       if(userWin==2){
           JOptionPane.showMessageDialog(null, "You win the game");
       }else{
           JOptionPane.showMessageDialog(null, "Computer wins the game");
       }
   }

}