import java.io.*;
import java.util.*;


public class IO {

  public static boolean validateCard(String input) {
    String[] validCards = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    for (String card : validCards) {
      if (input.equals(card)) {
        return true;
      }
    }
    return false;
  }

  public static boolean validateInput(String[] input) {
    if (input.length != 4) {
      return false;
    } else {
      for (int i = 0; i < input.length; i++) {
        if (!validateCard(input[i])) {
          return false;
        }
      }
      return true;
    }
  }

  public static String[] readInput() throws IOException {
    System.out.println("\nInput 4 character of A, J, Q, K, or 1-10.\nEach character is separated by a space");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String lines = br.readLine();

    String[] strs = lines.trim().split("\\s+");
    return strs;
  }

  public static int convertToInteger(String input) {
    switch (input) {
      case "A":
        return 1;
      case "J":
        return 11;
      case "Q":
        return 12;
      case "K":
        return 13;
      default:
        return Integer.parseInt(input);
    }
  }

  public static int[] readAndValidate() throws IOException {
    String[] inputArr = readInput();

    while (!validateInput(inputArr)) {
      System.out.println("Input is incorrect.");
      inputArr = readInput();
    }

    int[] outputInt = { convertToInteger(inputArr[0]), convertToInteger(inputArr[1]), convertToInteger(inputArr[2]),
        convertToInteger(inputArr[3]) };

    return outputInt;
  }

  public static void save2TXT(String input, String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    writer.write(input);
    writer.close();
    System.out.println("Saved in test folder successfully!");
  }

  public static void save(String savedStr,String filename) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Do you want to save the solution? (Y/N): ");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("Y")) {
      save2TXT(savedStr, filename);
    } else {
      System.out.println("Solution not saved.");
    }
}

}
