package swea.d3_7964.dim_gate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7964 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7964\\dim_gate\\input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int C = sc.nextInt();
			int r = sc.nextInt();
			int[] arr = new int[C];
			for (int i = 0; i < C; i++) {
				arr[i] = sc.nextInt();
			} // map data

			int cnt = r;
			int num = 0;
			for (int i = 0 ; i < C ; i++) {
				if (arr[i] == 0) {
					cnt--;
				} else {
					cnt = r;
				}
				if (cnt == 0) {
					num++;
					cnt = r;
				}
			}
			System.out.println("#" + tc + " " + num);
		} // tc for
	} // main
}