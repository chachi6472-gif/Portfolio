package swea.d4_4613.russianflag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_4613 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d4_4613\\russianflag\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
//			System.out.println(Arrays.toString(arr[0]));
//			System.out.println(Arrays.toString(arr[1]));
//			System.out.println(Arrays.toString(arr[2]));
//			System.out.println(Arrays.toString(arr[3]));
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						int cnt = 0;
						int currI = 0;
						int currJ = j;
						int currK = k;
//						System.out.print(currI);
//						System.out.print(" " + currJ);
//						System.out.println(" " + currK);
						while (currI < j || currJ < k || currK < N) {

							for (int l = 0; l < M; l++) {

								if (currI < j && arr[currI][l] != 'W') {
									cnt++;
								}
								if (currJ < k && arr[currJ][l] != 'B') {
									cnt++;
								}
								if (currK < N && arr[currK][l] != 'R') {
									cnt++;
								}

							} // for ends
							currI++;
							currJ++;
							currK++;

						} // while ends
						if (cnt < min) {
							min = cnt;
						}
//						System.out.println("cnt : " + cnt);
					}
				}
			}
			System.out.println("#" + tc + " " + min);
//			System.out.println("-----------------------------------------");
		}
	}
}
