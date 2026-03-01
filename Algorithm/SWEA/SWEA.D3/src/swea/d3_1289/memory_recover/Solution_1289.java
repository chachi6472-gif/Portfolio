package swea.d3_1289.memory_recover;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1289 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_1289\\memory_recover\\input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			// counter cnt for counting changes
			int cnt = 0;
			// compute cnt to use a method similar with selection sort
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] != arr[i + 1]) {
					cnt++;
				}
			}
			if (arr[0] == '1') {
				cnt++;
			} // if arr starts with '1', then it needs one more swap
			System.out.println("#" + tc + " " + cnt);
		}
	}
}