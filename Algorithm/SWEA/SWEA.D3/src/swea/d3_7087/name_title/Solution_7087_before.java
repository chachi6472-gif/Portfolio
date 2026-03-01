package swea.d3_7087.name_title;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7087_before {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7087\\name_title\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean[] tf = new boolean[26];

			for (int i = 0; i < N; i++) {
				String word = sc.next();
				char[] arr = word.toCharArray();
				tf[arr[0] - 65] = true; // A : 65
			}

			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				if (tf[i]) {
					cnt++;
				} else
					break;
			}
			System.out.println("#" + tc + " " + cnt);

		} // tc for
	} // main
}
