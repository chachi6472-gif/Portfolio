package swea.d3_7272.glassesless;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7272_SulMaSibal {
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
//			if (len < B.length()) {
//				len = B.length();
//			}

//			char[] arrA = new char[len];
//			char[] arrB = new char[len];
//
//			for (int i = 0; i < A.length(); i++) {
//				arrA[i] = A.charAt(i);
//			}
//			for (int i = 0; i < B.length(); i++) {
//				arrB[i] = B.charAt(i);
//			}

			char[] arrA = A.toCharArray();
			char[] arrB = B.toCharArray();

			int cntA = 0;
			int cntB = 0;
			boolean isSAME = true;

//			for (int i = 0; i < A.length(); i++) {
			for (int i = 0; i < len; i++) {
				if (arrA[i] == 'B') {
					if (arrB[i] != 'B') {
						isSAME = false;
						break;
					}
				}

				switch (arrA[i]) {
				case 'A':
					cntA++;
					break;
				case 'D':
					cntA++;
					break;
				case 'O':
					cntA++;
					break;
				case 'P':
					cntA++;
					break;
				case 'Q':
					cntA++;
					break;
				case 'R':
					cntA++;
					break;
				}

			}

//			for (int i = 0; i < B.length(); i++) {
			for (int i = 0; i < len; i++) {
				if (arrB[i] == 'B') {
					if (arrA[i] != 'B') {
						isSAME = false;
						break;
					}
				}

				switch (arrB[i]) {
				case 'A':
					cntB++;
					break;
				case 'D':
					cntB++;
					break;
				case 'O':
					cntB++;
					break;
				case 'P':
					cntB++;
					break;
				case 'Q':
					cntB++;
					break;
				case 'R':
					cntB++;
					break;
				}

			}

			if (isSAME && cntA == cntB) {
				System.out.println("#" + tc + " SAME");
			} else {
				System.out.println("#" + tc + " DIFF");
			}
		}
	}
}

//if (arrA[i] == 'B' || arrB[i] == 'B') { // A랑 B 길이가 다르면 니가 뭘 할 수 있는데?
//	if(!(arrA[i] == arrB[i])) {
//		isSAME = false;
//	}
//}
//
//switch (arrA[i]) {
//case 'A':
//	cntA++;
//	break;
//case 'D':
//	cntA++;
//	break;
//case 'O':
//	cntA++;
//	break;
//case 'P':
//	cntA++;
//	break;
//case 'Q':
//	cntA++;
//	break;
//case 'R':
//	cntA++;
//	break;
//}
//
//switch (arrB[i]) {
//case 'A':
//	cntB++;
//	break;
//case 'D':
//	cntB++;
//	break;
//case 'O':
//	cntB++;
//	break;
//case 'P':
//	cntB++;
//	break;
//case 'Q':
//	cntB++;
//	break;
//case 'R':
//	cntB++;
//	break;
//}