import java.util.*;
// import 

public class CardSolver {

	public static void displayMatrixFloat(float[][] m) {
		int i = 0;
		for (float[] arr : m) {
			for (float n : arr) {
				System.out.print(n + " ");
			}
			i += 1;
			System.out.println();
		}
		System.out.println(i);
	}

	public static void displayMatrixString(String[][] m) {
		int i = 0;
		for (String[] arr : m) {
			for (String n : arr) {
				System.out.print(n + " ");
			}
			i += 1;
			System.out.println();
		}
		System.out.println(i);
	}

	public static float operation(float n1, int op, float n2) {
		// -1 : +
		// -2 : -
		// -3 : *
		// -4 : /

		switch (op) {
			case -1:
				return n1 + n2;
			case -2:
				return n1 - n2;
			case -3:
				return n1 * n2;
			case -4:
				return n1 / n2;
			default:
				return 0;
		}
	}

	public static String operationToString(String n1, String op, String n2) {
		// -1 : +
		// -2 : -
		// -3 : *
		// -4 : /

		switch (op) {
			case "-1":
				return "(" + n1 + " + " + n2 + ")";
			case "-2":
				return "(" + n1 + " - " + n2 + ")";
			case "-3":
				return "(" + n1 + " * " + n2 + ")";
			case "-4":
				return "(" + n1 + " / " + n2 + ")";
			default:
				return "";
		}
	}

	public static String operationToStringLast(String n1, String op, String n2) {
		// -1 : +
		// -2 : -
		// -3 : *
		// -4 : /

		switch (op) {
			case "-1":
				return n1 + " + " + n2;
			case "-2":
				return n1 + " - " + n2;
			case "-3":
				return n1 + " * " + n2;
			case "-4":
				return n1 + " / " + n2;
			default:
				return "";
		}
	}

	public static float[][] allCard(float n0, float n1, float n2, float n3) {
		float[] deck = { n0, n1, n2, n3 };
		float[][] allDeck = new float[24][];

		int i = 0;

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					for (int d = 0; d < 4; d++) {
						if (a != b && a != c && a != d && b != c && b != d && c != d) {
							allDeck[i] = new float[] { deck[a], deck[b], deck[c], deck[d] };
							i += 1;
						}
					}
				}
			}
		}
		// displayMatrixFloat(allDeck);
		return allDeck;
	}

	public static float[][] allOperators() {
		float[] operators = { -1, -2, -3, -4 };
		float[][] allOperators = new float[64][];

		int i = 0;

		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 4; b++) {
				for (int c = 0; c < 4; c++) {
					allOperators[i] = new float[] { operators[a], operators[b], operators[c] };
					i += 1;
				}
			}
		}
		// displayMatrixFloat(allOperators);
		return allOperators;

	}

	public static float[][] allCardAndOp1(float n0, float n1, float n2, float n3) {
		float[][] allCard = allCard(n0, n1, n2, n3);
		float[][] allOp = allOperators();
		float[][] allCardAndOp = new float[24 * 64][];

		int k = 0;
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 64; j++) {
				allCardAndOp[k] = new float[] { allCard[i][0], allOp[j][0], allCard[i][1], allOp[j][1], allCard[i][2],
						allOp[j][2], allCard[i][3] };
				k += 1;
			}
		}
		// displayMatrixFloat(allCardAndOp);
		return allCardAndOp;
	}

	public static float[][] getFloatArrayOfCombination(float n0, float n1, float n2, float n3) {
		float[][] allCardAndOp1 = allCardAndOp1(n0, n1, n2, n3);
		float[][] allCardAndOp2 = new float[24 * 64 * 5][];

		int k = 0;
		for (int i = 0; i < 24 * 64; i++) {
			float combination0 = operation(
					operation(operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1], allCardAndOp1[i][2]),
							(int) allCardAndOp1[i][3], allCardAndOp1[i][4]),
					(int) allCardAndOp1[i][5], allCardAndOp1[i][6]);
			float combination1 = operation(operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1], allCardAndOp1[i][2]),
					(int) allCardAndOp1[i][3], operation(allCardAndOp1[i][4], (int) allCardAndOp1[i][5], allCardAndOp1[i][6]));
			float combination2 = operation(
					operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1],
							operation(allCardAndOp1[i][2], (int) allCardAndOp1[i][3], allCardAndOp1[i][4])),
					(int) allCardAndOp1[i][5], allCardAndOp1[i][6]);
			float combination3 = operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1],
					operation(operation(allCardAndOp1[i][2], (int) allCardAndOp1[i][3], allCardAndOp1[i][4]),
							(int) allCardAndOp1[i][5], allCardAndOp1[i][6]));
			float combination4 = operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1], operation(allCardAndOp1[i][2],
					(int) allCardAndOp1[i][3], operation(allCardAndOp1[i][4], (int) allCardAndOp1[i][5], allCardAndOp1[i][6])));

			allCardAndOp2[k] = new float[] { combination0 };
			allCardAndOp2[k + 1] = new float[] { combination1 };
			allCardAndOp2[k + 2] = new float[] { combination2 };
			allCardAndOp2[k + 3] = new float[] { combination3 };
			allCardAndOp2[k + 4] = new float[] { combination4 };

			k += 5;
		}
		// displayMatrixFloat(allCardAndOp2);
		return allCardAndOp2;
	}

	public static String[][] getStrArrayOfCombination(int n0, int n1, int n2, int n3) {
		String[][] allStr1 = new String[24 * 64][];
		float[][] allCardAndOp1 = allCardAndOp1(n0, n1, n2, n3);

		int k = 0;
		for (int i = 0; i < 24 * 64; i++) {
			allStr1[k] = new String[] { String.valueOf((int) allCardAndOp1[i][0]),
					String.valueOf((int) allCardAndOp1[i][1]),
					String.valueOf((int) allCardAndOp1[i][2]),
					String.valueOf((int) allCardAndOp1[i][3]),
					String.valueOf((int) allCardAndOp1[i][4]),
					String.valueOf((int) allCardAndOp1[i][5]),
					String.valueOf((int) allCardAndOp1[i][6]) };
			k += 1;
		}
		// displayMatrixString(allStr1);

		String[][] allStr2 = new String[24 * 64 * 5][];
		int l = 0;
		for (int i = 0; i < 24 * 64; i++) {
			String combination0 = operationToString(
					operationToString(operationToString(allStr1[i][0], allStr1[i][1], allStr1[i][2]), allStr1[i][3],
							allStr1[i][4]),
					allStr1[i][5], allStr1[i][6]);
			String combination1 = operationToString(operationToString(allStr1[i][0], allStr1[i][1], allStr1[i][2]),
					allStr1[i][3], operationToString(allStr1[i][4], allStr1[i][5], allStr1[i][6]));
			String combination2 = operationToString(operationToString(allStr1[i][0], allStr1[i][1],
					operationToString(allStr1[i][2], allStr1[i][3], allStr1[i][4])), allStr1[i][5], allStr1[i][6]);
			String combination3 = operationToString(allStr1[i][0], allStr1[i][1], operationToString(
					operationToString(allStr1[i][2], allStr1[i][3], allStr1[i][4]), allStr1[i][5], allStr1[i][6]));
			String combination4 = operationToString(allStr1[i][0], allStr1[i][1], operationToString(allStr1[i][2],
					allStr1[i][3], operationToString(allStr1[i][4], allStr1[i][5], allStr1[i][6])));

			allStr2[l] = new String[] { combination0 };
			allStr2[l + 1] = new String[] { combination1 };
			allStr2[l + 2] = new String[] { combination2 };
			allStr2[l + 3] = new String[] { combination3 };
			allStr2[l + 4] = new String[] { combination4 };

			l += 5;
		}
		// displayMatrixString(allStr2);
		return allStr2;
	}

	public static String solve24card(int n0, int n1, int n2, int n3) {
		float[][] FloatComb = getFloatArrayOfCombination(n0, n1, n2, n3);
		String[][] StringComb = getStrArrayOfCombination(n0, n1, n2, n3);

		String outputStr = "";
		int n = 0;

		for (int i = 0; i < 24 * 64 * 5; i++) {
			if (FloatComb[i][0] >= 23.95 && FloatComb[i][0] <= 24.05) {
				outputStr += n + 1 + ".    " + StringComb[i][0] + "\n";
				n += 1;
			}
		}
		if (n == 0) {
			outputStr = "no solution found";
		} else {
			outputStr = n + " solution found\n" + outputStr;
		}
		System.out.println(outputStr);
		return (outputStr);

	}

}