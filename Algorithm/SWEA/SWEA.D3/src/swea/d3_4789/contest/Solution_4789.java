package swea.d3_4789.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_4789 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_4789\\contest\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String viewer = sc.next();
			char[] arr = new char[viewer.length()];
			arr = viewer.toCharArray();
			int sum = 0;
			int hire = 0;
			for (int i = 0; i < viewer.length(); i++) {
				if ( arr[i]-48 == 0) {
					continue;
				}
				if (arr[i] - 48 != 0) {
					if (sum >= i) {
						sum += arr[i] - 48;
						continue;
					} else {
						int added = i - sum;
						hire += added;
						sum += arr[i] - 48 + added;
					}
				}
			}
			System.out.println("#" + tc + " " + hire);
		} // tcf 09
	}
}
