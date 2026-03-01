package swea.d3_4698.special_primenum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_4698_TimeIssue {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_4698\\special_primenum\\sample_input.txt");
		Scanner sc = new Scanner(input);

		// 너무 느려
		int[] primeList = new int[((int) (1000000 / (Math.log(1000000) - 1.0837)))];
		primeList[0] = 2;
		int start = 1;
		for (int j = 3; j < 1000000; j += 2) {
			boolean isPrime = true;
			for (int i = 0; i < primeList.length; i++) {
				if (primeList[i] == 0) {
					break;
				}
				if (j % primeList[i] != 0) {
					continue;
				} else {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeList[start++] = j;
			}
		}
		System.out.println(Arrays.toString(primeList));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;

			for (int p : primeList) {
				for (int i = 0; i < 7; i++) {
					if (p < A) {
						continue;
					}
					if (p > B) {
						break;
					}
					if (p == 0) {
						break;
					}
					if (p % 10 == D) {
						cnt++;
						break;
					} else {
						p /= 10;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // tcf
	}
}
