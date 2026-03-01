package swea.d3_4047.card_counting;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d3_4047\\card_counting\\sample_input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String cardList = sc.next();
			int numCard = cardList.length();
			char[] cards = cardList.toCharArray();
			System.out.print("#" + tc);
			int[] restS = new int[13];
			int[] restD = new int[13];
			int[] restH = new int[13];
			int[] restC = new int[13];
			int cntS = 0;
			int cntD = 0;
			int cntH = 0;
			int cntC = 0;
			for (int i = 0; i < numCard / 3; i++) {
				int nth = (cards[3 * i + 1] - 48) * 10 + (cards[3 * i + 2] - 48);
				switch (cards[3 * i]) {
				case 'S':
					restS[nth - 1]++;
					cntS++;
					break;
				case 'D':
					restD[nth - 1]++;
					cntD++;
					break;
				case 'H':
					restH[nth - 1]++;
					cntH++;
					break;
				case 'C':
					restC[nth - 1]++;
					cntC++;
					break;
				}
			}
			Arrays.sort(restS);
			Arrays.sort(restD);
			Arrays.sort(restH);
			Arrays.sort(restC);
			if (restS[12] > 1 || restD[12] > 1 || restH[12] > 1 || restC[12] > 1) {
				System.out.println(" ERROR");
				continue;
			} else {
				System.out.println(" " + (13 - cntS) + " " + (13 - cntD) + " " + (13 - cntH) + " " + (13 - cntC));
			}
		}
	}
}