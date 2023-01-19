import java.util.*;

public class App {
  public static void main(String[] args){
    // CardSolver.allOperators();
    float[][] s1 = CardSolver.allCardAndOp1(1,2,3,4);
    float[][] s2 = CardSolver.allCardAndOp2(s1);
    float[][] s3 = CardSolver.allCardAndOp3(s2);
    float[][] s4 = CardSolver.allCardAndOp4(s3);
  }
}