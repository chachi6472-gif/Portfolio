package swea.d2_1204.mode;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1204 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int numT = sc.nextInt();

			int[] arr = new int[101];

			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				arr[score]++;
			}
			int mode = 0;
			for (int i = 100; i > 0; i--) {
				if (arr[i] > arr[mode]) {
					mode = i;
				}
			}
			System.out.println("#" + numT + " " + mode);

		}

	}
}
