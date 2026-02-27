package swea.d3_14555.ballandweed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_14555 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_14555\\ballandweed\\sample_input.txt");
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String area = sc.next();
			char[] arr = area.toCharArray();

			int cnt = 0;
			for (int i = 0; i < area.length() - 1; i++) {
				char tmp = arr[i];
				if (tmp == '(' && arr[i + 1] == '|') {
					cnt++;
				} else if (tmp == '|' && arr[i + 1] == ')') {
					cnt ++;
				} else if (tmp == '(' && arr[i+1] == ')') {
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}

//for (int i = 1; i < area.length(); i++) {
//	char tmp = arr[i];
//	if (tmp == ')' && arr[i - 1] == '|') {
//		cnt++;
//	}
//}