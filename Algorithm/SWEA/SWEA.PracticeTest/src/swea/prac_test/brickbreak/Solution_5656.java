package swea.prac_test.brickbreak;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656 {
	public static int N, W, H, minRest;
	public static int[] brickInfo;
	// clockwise, start at 12
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\brickbreak\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// Given condition : 1 <= N <= 4 | 2 <= W <= 12 | 2 <= H <= 15
		// make #{bricks} minimal
		// there can exist W power N cases s.t. N = 4, W = 12 ( maximal case )
		// => then #cases : 12^4 ( First position of brick : 1~12, ..., Fourth : 1~12 )
		// 10^4 < 12^4 < 10^5 => this number is computable. Thus put all cases into ft.
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(arr[r])); // it works
			} // input

			minRest = W * H;
			dropTheBricks();

			sb.append(minRest);
			System.out.println(sb);
		} // tc for

	} // main

	public static void dropTheBricks() {
		brickInfo = new int[N];
//		int cnt = 0;
		// determine where to drop -> one cycle, one case
		while (true) {
//			cnt++;

			getResult();

//			System.out.println("dropTheBeat : " + Arrays.toString(brickInfo));
			brickInfo[0]++;
			for (int i = 0; i < N - 1; i++) {
				if (brickInfo[i] == W) {
					brickInfo[i] = 0;
					brickInfo[i + 1]++;
				}
			}
			if (brickInfo[N - 1] == W) {
				break;
			}
			// test case 1 : it can make 1000 cases

		} // while
//		System.out.println(cnt);

	} // method : drop the bricks

	public static void getResult() {
		// make array for this case ( because of deep copy )
		int[][] currArr = new int[H][W];
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				currArr[r][c] = arr[r][c];
			}
		} // input

		for (int i = 0; i < brickInfo.length; i++) {
			int Col = brickInfo[i];
			boolean needToSort = false;
			// i번째 돌을 떨궈용
			for (int r = 0; r < H; r++) {
				if (currArr[r][Col] == 0) {
					continue;
				} else if (currArr[r][Col] == 1) {
					currArr[r][Col] = 0;
					break;
				} else {
					needToSort = true;
					int num = currArr[r][Col];
					breakBricks(currArr, r, Col, num);
					break;
				}
			} // for : drop the ith-brick

			if (needToSort) {
				grabToBottom(currArr);
			}

		} // for : brick simulation

		// count rest blocks and compare with static minRest
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0 ; c < W ; c++) {
				if (currArr[r][c] == 0) {
					continue;
				} else {
					cnt++;
				}
			}
		}
		if(cnt < minRest) {
			minRest = cnt;
		}

	}

	public static void breakBricks(int[][] arr, int r, int c, int num) {
		arr[r][c] = 0;

		for (int j = 0; j < 4; j++) {
			int currR = r;
			int currC = c;
			for (int k = 1; k < num; k++) {
				currR += dr[j];
				currC += dc[j];
				if (currR >= 0 && currR < H && currC >= 0 && currC < W) {
					if (arr[currR][currC] == 0) {
						continue;
					} else if (arr[currR][currC] == 1) {
						arr[currR][currC] = 0;
					} else {
						breakBricks(arr, currR, currC, arr[currR][currC]);
					}
				} else {
					break;
				}
			}
		}

	}

	public static void grabToBottom(int[][] arr) {
		for (int c = 0; c < W; c++) {
			boolean zeroInside = true;

			while (zeroInside) {
				zeroInside = false;
				for (int r = H - 1; r > 0; r--) {
					if (arr[r][c] != 0) {
						continue;
					} 
					else if (arr[r][c] == 0 && arr[r - 1][c] == 0) {
						continue;
					} 
					else {
						arr[r][c] = arr[r - 1][c];
						arr[r - 1][c] = 0;
						zeroInside = true;
					}
				}
			}
		}
	}

} // class
