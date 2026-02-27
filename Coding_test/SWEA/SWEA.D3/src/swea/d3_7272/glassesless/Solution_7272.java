package swea.d3_7272.glassesless;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7272 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7272\\glassesless\\s_input.txt");
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String A = sc.next();
			String B = sc.next();

			if (!(A.length() == B.length())) {
				System.out.println("#" + tc + " DIFF");
				continue;
			}

			int len = A.length();

			char[] arrA = A.toCharArray();
			char[] arrB = B.toCharArray();

			boolean isSAME = true;

			for (int i = 0; i < len; i++) {
				if (arrA[i] == 'B') {
					if (arrB[i] != 'B') {
						isSAME = false;
						break;
					}
				}

				switch (arrA[i]) {
				case 'A':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'D':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'O':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'P':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'Q':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'R':
					if (arrB[i] == 'A' || arrB[i] == 'D' || arrB[i] == 'O' || arrB[i] == 'P' || arrB[i] == 'Q'
							|| arrB[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				}

			}

			for (int i = 0; i < len; i++) {
				if (arrB[i] == 'B') {
					if (arrA[i] != 'B') {
						isSAME = false;
						break;
					}
				}

				switch (arrB[i]) {
				case 'A':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'D':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'O':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'P':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'Q':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				case 'R':
					if (arrA[i] == 'A' || arrA[i] == 'D' || arrA[i] == 'O' || arrA[i] == 'P' || arrA[i] == 'Q'
							|| arrA[i] == 'R') {
						break;
					} else
						isSAME = false;
					break;
				}

			}

			if (isSAME) {
				System.out.println("#" + tc + " SAME");
			} else {
				System.out.println("#" + tc + " DIFF");
			}
		}
	}
}