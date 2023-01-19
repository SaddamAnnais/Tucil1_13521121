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

	public static float[][] allCardAndOp2(float[][] allCardAndOp1) {
		float[][] allCardAndOp2 = new float[24 * 64 * 3][];

		// System.out.println(allCardAndOp1[0][1]);
		int k = 0;
		for (int i = 0; i < 24 * 64; i++) {
			allCardAndOp2[k] = new float[] { operation(allCardAndOp1[i][0], (int) allCardAndOp1[i][1], allCardAndOp1[i][2]), allCardAndOp1[i][3], allCardAndOp1[i][4], allCardAndOp1[i][5], allCardAndOp1[i][6]};
			allCardAndOp2[k+1] = new float[] { allCardAndOp1[i][0], allCardAndOp1[i][1], operation(allCardAndOp1[i][2], (int) allCardAndOp1[i][3], allCardAndOp1[i][4]), allCardAndOp1[i][5], allCardAndOp1[i][6]};
			allCardAndOp2[k+2] = new float[] { allCardAndOp1[i][0], allCardAndOp1[i][1], allCardAndOp1[i][2], allCardAndOp1[i][3], operation(allCardAndOp1[i][4], (int)allCardAndOp1[i][5], allCardAndOp1[i][6])};
			
			k += 3;
		}
		// displayMatrixFloat(allCardAndOp2);
		return allCardAndOp2;
	}

	public static float[][] allCardAndOp3(float[][] allCardAndOp2) {
		float[][] allCardAndOp3 = new float[24 * 64 * 3 * 2][];

		// System.out.println(allCardAndOp1[0][1]);
		int k = 0;
		for (int i = 0; i < 24 * 64 * 3; i++) {
			allCardAndOp3[k] = new float[] { operation(allCardAndOp2[i][0], (int) allCardAndOp2[i][1], allCardAndOp2[i][2]), allCardAndOp2[i][3], allCardAndOp2[i][4]};
			allCardAndOp3[k+1] = new float[] { allCardAndOp2[i][0], allCardAndOp2[i][1], operation(allCardAndOp2[i][2], (int) allCardAndOp2[i][3], allCardAndOp2[i][4])};
			k += 2;
		}
		// displayMatrixFloat(allCardAndOp3);
		return allCardAndOp3;
	}

	public static float[][] allCardAndOp4(float[][] allCardAndOp3) {
		float[][] allCardAndOp4 = new float[24 * 64 * 3 * 2][];

		// System.out.println(allCardAndOp1[0][1]);
		int k = 0;
		for (int i = 0; i < 24 * 64 * 3 * 2; i++) {
			allCardAndOp4[k] = new float[] { operation(allCardAndOp3[i][0], (int) allCardAndOp3[i][1], allCardAndOp3[i][2])};
			k += 1;
		}
		displayMatrixFloat(allCardAndOp4);
		return allCardAndOp4;
	}

}