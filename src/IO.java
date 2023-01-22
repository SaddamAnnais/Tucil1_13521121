import java.io.*;
import java.util.*;
import java.util.Random;

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



  public static void save2TXT(String input, String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    writer.write(input);
    writer.close();
    System.out.println("Saved in test folder successfully!");
  }

  public static void save(String savedStr, String filename) throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Do you want to save the solution? (Y/N): ");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("Y")) {
      save2TXT(savedStr, filename);
    } else {
      System.out.println("Solution not saved.");
    }
  }

  public static String[] randomInput() {
    String[] randArr = new String[4];
    Random random = new Random();
    for (int i = 0; i < 4; i++) {
        int randNum = random.nextInt(13) + 1;
        if (randNum == 1) {
            randArr[i] = "A";
        } else if (randNum == 11) {
          randArr[i] = "J";
        } else if (randNum == 12) {
          randArr[i] = "Q";
        } else if (randNum == 13) {
          randArr[i] = "K";
        } else {
          randArr[i] = Integer.toString(randNum);
        }
    }
    System.out.println("Random input: ");
    for (int i = 0; i < randArr.length; i++) {
        System.out.print(randArr[i]+ " ");
    }
    System.out.print("\n");
    return randArr;
}

  public static String[] userInput() throws IOException {
    System.out.println("\nInput 4 character of A, J, Q, K, or 2-10.\nEach character is separated by a space");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String lines = br.readLine();
    String[] strs = lines.trim().split("\\s+");
    return strs;
  }

  public static String[] readInput() throws IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Do you want to enter an input or generate a random one? (Enter/Random): ");
    String userChoice = scanner.nextLine();

    if (userChoice.equalsIgnoreCase("Enter")) {
        return userInput();
    } else if (userChoice.equalsIgnoreCase("Random")) {
        String[] randomStrings = randomInput();

        return randomStrings;
    } else {
        System.out.println("Invalid choice. Please enter 'Enter' or 'Random'.");
        String[] invalidStr = {};
        return invalidStr;
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
}
