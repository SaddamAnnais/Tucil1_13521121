import java.util.*;
import java.io.*;


public class App {
  public static void main(String[] args) throws IOException {
    int[] input = IO.readAndValidate();
    String outputStr = CardSolver.solve24card(input[0], input[1], input[2], input[3]);
    
    String filename = input[0] + " " + input[1] + " " + input[2] + " " + input[3] + ".txt";
    outputStr = filename + "\n" + outputStr;

    IO.save(outputStr, "test/"+ filename);
  }
}