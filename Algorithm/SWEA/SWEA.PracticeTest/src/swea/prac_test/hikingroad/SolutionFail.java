package swea.prac_test.hikingroad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionFail {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\hikingroad\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int maxHeight = 0;
			boolean[][] isHighest = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > maxHeight) {
						maxHeight = arr[i][j];
					}
				}
			} // for : input -> array

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == maxHeight) {
						isHighest[i][j] = true;
					}
				}
			} // for : check where the highest is

			int currK = K;
			// delta : 12 3 6 9  - clockwise
			int[] dr = { -1,  0,  1,  0 };
			int[] dc = { 0, 1,  0, - -1 };
			int currRow = 0;
			int currCol = 0;
			boolean isConstructable = false;
			int maxCnt = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (isHighest[r][c]) {
						System.out.println("---------------------------------------------------------------------");
						System.out.println("초기 행, 열 : " + r + ", " + c);
						currRow = r;
						currCol = c;

//						while (true) {

							int currH = maxHeight;
							int currD = 0;
							int idxD = 0;
							int cnt = 0;
							while (true) {
								if (K > 0) {
									isConstructable = true;
								}

// second while
							int idxK_r = 0;
							int idxK_c = 0;
							int idxDr = 0;
							int idxDc = 0;
//							System.out.println(currRow);
//							System.out.println(currCol);
							for (int d = idxD; d < 4; d++) {
								System.out.println("d : " + d + " | currD : " + currD); 
								System.out.println("현재 행, 열 : " + currRow + ", " + currCol);
								currRow += dr[d];
								currCol += dc[d];

								if (currRow < N && currRow >= 0 && currCol < N && currCol >= 0) {
									System.out.println("*** 델타 이동 후 행, 열 : " + currRow + ", " + currCol);
									if (arr[currRow][currCol] >= arr[currRow - dr[d]][currCol - dc[d]]
											&& isConstructable) {
										if (currK >= arr[currRow - dr[d]][currCol - dc[d]] - arr[currRow][currCol]) {
											currH = arr[currRow - dr[d]][currCol - dc[d]] - 1;
											arr[currRow][currCol] = currH;
											isConstructable = false;
											idxK_r = currRow;
											idxK_c = currCol;
											idxDr = dr[d];
											idxDc = dc[d];
											idxD = d + 1;
											System.out.println("[ 깎았어용~~~~~~~ (" + currRow + " , " + currCol + ") ]");
//											System.out.println(idxD);
										}
									}
									if (arr[currRow][currCol] < arr[currRow - dr[d]][currCol - dc[d]]) {
										cnt++;
										System.out.println("Count : " + cnt);
										d = idxD;
										if (cnt > maxCnt) {
											maxCnt = cnt;
										}
										continue;
									} else {
										currRow -= dr[d];
										currCol -= dc[d];
									}

								}

								else {
									currRow -= dr[d];
									currCol -= dc[d];
								}
							} // for : delta

							if (!isConstructable) {
								arr[idxK_r][idxK_c]++;
								isConstructable = true;
								currRow = idxK_r - idxDr;
								currCol = idxK_c - idxDc;
								cnt--;
								System.out.println("[ 깎은 거 복구 ]");
								System.out.println();
							}

							currD++;
							if (currD == 8) {
								break;
							}

						} // second while

//						} // first while

					} // if element is maxHeight

				} // for : column changes
			} // for : row changes
			System.out.println(maxCnt);
			System.out.println("---------------------------------------------------------------------");
		} // tc for
	}
}
