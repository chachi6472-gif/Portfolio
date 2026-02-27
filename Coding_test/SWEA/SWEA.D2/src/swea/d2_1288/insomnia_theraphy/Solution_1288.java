package swea.d2_1288.insomnia_theraphy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1288 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d2_1288\\insomnia_theraphy\\sample_input.txt");
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean isEnd = false;
			int cnt = 0;
			boolean[] arr = new boolean[10];
			while (!isEnd) {
				int tmp = N * (++cnt);
				while (tmp > 0) {
					arr[tmp % 10] = true;
					tmp /= 10;
				}
				for (int i = 0; i < 10; i++) {
					if (!arr[i]) {
						break;
					}
					if (i == 9 && arr[i]) {
						isEnd = true;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt * N).append("\n");
		}
		System.out.println(sb);
	}
}