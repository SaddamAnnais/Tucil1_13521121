import java.io.*;

public class App {
  public static void main(String[] args) throws IOException {
    int[] input = IO.readAndValidate();

    long startTime = System.currentTimeMillis();
    String outputStr = CardSolver.solve24card(input[0], input[1], input[2], input[3]);
    
    String filename = input[0] + " " + input[1] + " " + input[2] + " " + input[3];
    outputStr = filename + "\n" + outputStr;

    long startTimeInput = System.currentTimeMillis();
    IO.save(outputStr, "test/"+ filename + ".txt");
    long endtTimeInput = System.currentTimeMillis();
    
    long endTime = System.currentTimeMillis();

    long time = endTime - startTime - endtTimeInput + startTimeInput;
    System.out.println("Elapsed time exclude user input: " + time + " milliseconds");
  }
}