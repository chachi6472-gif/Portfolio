package swea.d3_1289.memory_recover;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1289_booleanArr {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_1289\\memory_recover\\input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			boolean[] res = new boolean[arr.length];
			// counter cnt for counting changes
			int cnt = 0;
//			System.out.println("-------- before ------------");
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(res));
			// if element from head not equals with input array's, then swap res from i-th
			// to tail and count
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '0' && res[i]) {
					for (int j = i; j < arr.length; j++) {
						res[j] = false;
					}
				} else if (arr[i] == '1' && !res[i]) {
					for (int j = i; j < arr.length; j++) {
						res[j] = true;
					}
				} else
					continue;
				cnt++;
			}
//			System.out.println("--------- after -------------");
//			System.out.println(Arrays.toString(res));
			System.out.println("#" + tc + " " + cnt);
		}
	}
}