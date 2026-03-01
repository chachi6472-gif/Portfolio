package swea.d3_4698.special_primenum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_4698 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_4698\\special_primenum\\sample_input.txt");
		Scanner sc = new Scanner(input);

		// false
		boolean[] primeList = new boolean[1000001];
		primeList[0] = true;
		primeList[1] = true;

		for (int i = 2; i < 500000; i++) {
			if (!primeList[i]) {
				for (int j = 2 * i; j < 1000001; j += i) {
					primeList[j] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(primeList));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;
			for (int i = A; i < B + 1; i++) {
				if (!primeList[i]) {
					int p = i;

					while (p != 0) {
						if (p % 10 == D) {
							cnt++;
							break;
						} else {
							p /= 10;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // tcf
	}
}
