package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
  // Intializing private variables
  private static final Scanner INPUT = new Scanner(System.in);
  private int guessNumber;
  private String chosenWord;

  // Constructor with one paramet
  public Guess(int num){
    if (num < 1 || num > 6){
      throw new GameException("Invalid Input");
    } else {
      guessNumber = num;
    }
  }

  // Guess with two parameters
  public Guess(int num, String word){
    // Checks if guessNumber is valid
    if (num < 1 || num > 6){
      throw new GameException("Invalid Input");
    } else {
      guessNumber = num;
    }
    // Validation for word
    if(word.length() == 5){
      int count = 0;
    // Check if theres a digit in the word
    for(int i =0; i < word.length(); i++){
      char x = word.charAt(i);
      if(Character.isDigit(x)){
        count++;
      }
    }
    if (count == 0){
      chosenWord = word.toUpperCase();
    } else {
      throw new GameException("Invalid Word");
    }
    } else {
      throw new GameException("Invalid Word");
    }
  }

  // Gets GuessNumber
  public int getGuessNumber(){
    return guessNumber;
  }

  // Gets chosenWord
  public String getChosenWord(){
    return chosenWord;
  }

  // Takes in input from player
  public void readFromPlayer(){
   chosenWord = INPUT.nextLine();
  }

  // compareWith compares chosenWord with target and returns a string value
  public String compareWith(String target){
    // Create Stringbuilder for chosenWord
    StringBuilder word = new StringBuilder();

    // Intialize counting arrays
    int array[] = new int[26];
    int array2[] = new int[26];
    int array3[] = new int[26];
    int position = 0;
    int pos = 0;
  

    // Array of alphabets
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    // arrays to count the occurences of alphabets and add them onto an array
    for (int count = 0; count < 5; count++){
      char c = chosenWord.charAt(count);
      char cu = Character.toLowerCase(c); 
      char t = target.charAt(count);
      char t1 = Character.toLowerCase(t);
        for (int y = 0; y < 26; y++){
          if (cu == alphabet[y]){
            array2[y] = array2[y] + 1;     
          }
        }
        for (int tar = 0; tar < 26; tar++){
          if (t1 == alphabet[tar]){
            array3[tar] = array3[tar] + 1;     
          }
        }
    }

    // Loop to iterate over chosen word
    for(int i = 0; i < 5; i++){
      char c = chosenWord.charAt(i);
      char cu = Character.toLowerCase(c);
      char x = target.charAt(i);
    
      // Loop to check the first occurence of the letter
      for (int y = 0; y < 26; y++){
        if (cu == alphabet[y]){
          array[y] = array[y] + 1;
          position = array[y];
          pos = y;
          break;
        }
      }
      // Check if they are same position and equal to each other
      if (c == x){
      word.append("\033[30;102m "+c+" \033[0m");
      } 
      // Check if it's in the word and if its the first occurence 
      else if (target.contains(String.valueOf(c)) && (position == 1 || array2[pos] <= array3[pos])){
        word.append("\033[30;103m "+ c +" \033[0m");
      } 
      // If letter is not in the word 
      else {
        word.append("\033[30;107m "+ c +" \033[0m");
      }
    }
    // Returns string with ansi 
    return word.toString();
  }

  public String compareWithAccessible(String target){
    // Create Stringbuilder for chosenWord
    StringBuilder word = new StringBuilder();

    // Intialize counting arrays
    int array[] = new int[26];
    int array2[] = new int[26];
    int array3[] = new int[26];
    int position = 0;
    int pos = 0;
  

    // Array of alphabets
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    // arrays to count the occurences of alphabets and add them onto an array
    for (int count = 0; count < 5; count++){
      char c = chosenWord.charAt(count);
      char cu = Character.toLowerCase(c); 
      char t = target.charAt(count);
      char t1 = Character.toLowerCase(t);
        for (int y = 0; y < 26; y++){
          if (cu == alphabet[y]){
            array2[y] = array2[y] + 1;     
          }
        }
        for (int tar = 0; tar < 26; tar++){
          if (t1 == alphabet[tar]){
            array3[tar] = array3[tar] + 1;     
          }
        }
    }

    // Loop to iterate over chosen word
    for(int i = 0; i < 5; i++){
      char c = chosenWord.charAt(i);
      char cu = Character.toLowerCase(c);
      char x = target.charAt(i);
    
      // Loop to check the first occurence of the letter
      for (int y = 0; y < 26; y++){
        if (cu == alphabet[y]){
          array[y] = array[y] + 1;
          position = array[y];
          pos = y;
          break;
        }
      }
      // Check if they are same position and equal to each other
      if (c == x){
      word.append((i+1)+" perfect ");
      } 
      // Check if it's in the word and if its the first occurence 
      else if (target.contains(String.valueOf(c)) && (position == 1 || array2[pos] <= array3[pos])){
        word.append(i+" correct but in wrong place");
      } 
      // If letter is not in the word 
      else {
        word.append("");
      }
    }
    // Returns string with ansi 
    return word.toString();
  }

  // Checks if the chosenWord and the target word is equal
  public boolean matches(String target){
    if(target.equals(chosenWord)){
      return true;
    }
      return false;
  }
}
