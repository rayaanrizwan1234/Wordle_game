package comp1721.cwk1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.io.IOException;

public class WordList {

  private List<String> words = new ArrayList<String>();
  // TODO: Implement constructor with a String parameter

  public WordList(String filename) throws IOException {
    Path path = Paths.get(filename);
    words = Files.readAllLines(path);
  }

  // TODO: Implement size() method, returning an int

  public int size(){
    return words.size();
  }

  // TODO: Implement getWord() with an int parameter, returning a String

  public String getWord(int n){
    if(n < 0 || n > words.size()-1){
      throw new GameException("Game number out of range");

    }else {
      return words.get(n);
    }
  }
}
