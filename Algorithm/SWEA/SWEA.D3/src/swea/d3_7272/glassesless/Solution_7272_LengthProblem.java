package swea.d3_7272.glassesless;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7272_LengthProblem {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7272\\glassesless\\s_input.txt");
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String A = sc.next();
			String B = sc.next();
//			if (!(A.length() == B.length())) {
//				System.out.println("#" + tc + " DIFF");
//				break;
//			}

			int cntA = 0;
			int cntB = 0;
			boolean isSAME = true;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == 'B' || B.charAt(i) == 'B') { // A랑 B 길이가 다르면 니가 뭘 할 수 있는데?
					if(!(A.charAt(i) == B.charAt(i))) {
						isSAME = false;
						break;
					}
				}

				switch (A.charAt(i)) {
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
				
				switch (B.charAt(i)) {
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

//				switch (A.charAt(i)) {
//				case 'A', 'D', 'O', 'P', 'Q', 'R':
//					cntA++;
//					break;
//				case 'B':
//					cntA += 2;
//					break;
//				}
// 제출은 이렇게 해야되더라. Java8 이라서 그런듯.
// 그럴 거면 안 쓰지
//				case 'A':
//					cntA++;
//					break;
//				case 'D':
//					cntA++;
//					break;
//				case 'O':
//					cntA++;
//					break;
//				case 'P':
//					cntA++;
//					break;
//				case 'Q':
//					cntA++;
//					break;
//				case 'R':
//					cntA++;
//					break;