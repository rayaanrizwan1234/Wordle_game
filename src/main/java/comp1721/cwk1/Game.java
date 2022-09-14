package comp1721.cwk1;
import java.time.LocalDate;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.io.FileWriter;



public class Game {
  //Initializing Variables 
  private int gameNumber;
  private String target;
  private Guess obj[] = new Guess[6];
  private StringBuilder objword = new StringBuilder();

  
  // Constructur when user doesn't input a game number

  public Game (String filename) throws IOException{
    WordList word = new WordList(filename);
    // Gets today's date and the start of the first wordle date
    LocalDate today = LocalDate.now();
    LocalDate startDate = LocalDate.of(2021, 6, 19);
    // Calculates the days between the two dates
    long num = ChronoUnit.DAYS.between(startDate, today);
    // converts the data type long to integer
    gameNumber = Math.toIntExact(num);
    target = word.getWord(gameNumber);
    System.out.println(target);
  }

  // TODO: Implement constructor with int and String parameters

  public Game (int num, String filename) throws IOException {
  WordList word = new WordList(filename);
  gameNumber = num;
  target = word.getWord(gameNumber);
  System.out.println("WORDLE "+gameNumber+"\n");
  }


  // TODO: Implement play() method

  public void play(){
    // For loop for guesses
    for (int i = 1; i <= 7; i++){
      // Create an object to get user chosenWord
      Guess guess1 = new Guess(i);
      System.out.println("Enter Guess ("+i+"/6): ");
      guess1.readFromPlayer();
      // Create another object with guessNumber and User input
      Guess guess1c = new Guess(i, guess1.getChosenWord());
      System.out.print(guess1c.compareWith(target)+"\n");
      // Append return value of comapre with 
      objword.append(guess1c.compareWith(target)+"\n");
      // Check to see in how many tries the user guessed it
      if(guess1c.matches(target) && i == 1){
        System.out.println("Super - Got it in one!");
        break;
      } else if(guess1c.matches(target) && (i >= 2 || i <= 5)){
        System.out.println("Well done!");
        break;
      } else if(guess1c.matches(target) && i == 6){
        System.out.println("That was a close call!");
        break;
      } 
      if (i == 7){
        System.out.println("Nope - Better luck next time!");
      }
    }

  }
  // Method for accessiblity
  public void playaccessible(){
    // For loop for guesses
    for (int i = 1; i <= 7; i++){
      // Create an object to get user chosenWord
      Guess guess1 = new Guess(i);
      System.out.println("Enter Guess ("+i+"/6): ");
      guess1.readFromPlayer();
      // Create another object with guessNumber and User input 
      Guess guess1c = new Guess(i, guess1.getChosenWord());
      System.out.print(guess1c.compareWithAccessible(target)+"\n");
      // Append return value of comapre with 
      objword.append(guess1c.compareWithAccessible(target)+"\n");
      // Check to see in how many tries the user guessed it
      if(guess1c.matches(target) && i == 1){
        System.out.println("Super - Got it in one!");
        break;
      } else if(guess1c.matches(target) && (i >= 2 || i <= 5)){
        System.out.println("Well done!");
        break;
      } else if(guess1c.matches(target) && i == 6){
        System.out.println("That was a close call!");
        break;
      } 
      if (i == 7){
        System.out.println("Nope - Better luck next time!");
      }
    }
  }

  // Method for saving to lastgame.txt

  public void save(String filename) throws IOException {
    // Path path = Paths.get(filename);
    FileWriter out = new FileWriter(filename);
    // Writing to the file
    out.write(objword.toString());
    out.close();
  }

}

