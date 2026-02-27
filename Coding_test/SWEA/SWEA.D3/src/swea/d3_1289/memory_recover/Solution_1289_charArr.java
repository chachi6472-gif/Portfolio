package swea.d3_1289.memory_recover;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1289_charArr {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_1289\\memory_recover\\input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			char[] res = new char[arr.length];
			// char array res -> reset to '0'
			for (int i = 0; i < arr.length; i++) {
				res[i] = '0';
			}
			// counter cnt for counting changes
			int cnt = 0;
//			System.out.println("-------- before ------------");
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(res));
			// if element from head not equals with input array's, then swap from i-th to tail and count
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != res[i]) {
					for (int j = i; j < arr.length; j++) {
						res[j] = arr[i];
					}
					cnt++;
				}
			}
//			System.out.println("--------- after -------------");
//			System.out.println(Arrays.toString(res));
			System.out.println("#" + tc + " " + cnt);
		}
	}
}