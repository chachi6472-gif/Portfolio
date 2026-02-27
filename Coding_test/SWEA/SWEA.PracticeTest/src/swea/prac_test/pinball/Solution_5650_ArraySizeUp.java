package swea.prac_test.pinball;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5650_ArraySizeUp {
	static int first_r;
	static int first_c;
	static int N;
	static int[][] arr;
	static int[][] arrWH;
	static int cnt;
	static int round;
	static int[] arrMove = new int[4];
	static boolean isOK;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\pinball\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// [ game rule ]
		// ( information ) : black hole = -1 | empty space = 0 | block = [1,5] | worm
		// hole = [6,10]
		// 1. 5 <= N <= 100
		// 2. worm hole : [6,10] and if there exists worm hole, then the unique pair
		// must be on the table.
		// 3. if coordinate of pin ball equals with worm hole, then switch the position
		// into another worm hole.
		// -> in this case, the vector doesn't change.
		// 4. black hole : -1 and there is a case that there is no black hole on the
		// table
		// 5. max #{black hole} : 5

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N + 2][N + 2];
			arrWH = new int[10][2];
			for (int i = 0; i < N + 2; i++) {
				arr[0][i] = 5;
				arr[N + 1][i] = 5;
			}
			for (int i = 0; i < N + 2; i++) {
				arr[i][0] = 5;
				arr[i][N + 1] = 5;
			}
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 1; j < N + 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > 5) {
						int numWH = (arr[i][j] - 6) * 2;
						// save idx of first WH
						if (arrWH[numWH][0] == 0 && arrWH[numWH][1] == 0) {
							arrWH[numWH][0] = i;
							arrWH[numWH][1] = j;
						} else {
							arrWH[numWH + 1][0] = i;
							arrWH[numWH + 1][1] = j;
						} // save idx of second WH
					}
				}
			} // input

			int res = 0;
			int caseOne = 0;
			int caseTwo = 0;
			int caseThree = 0;
			int caseFour = 0;
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					if (arr[r][c] != 0) {
						continue;
					}
					first_r = r;
					first_c = c;
					caseOne = LetsPinball(r, c, 1, 0);
					caseTwo = LetsPinball(r, c, -1, 0);
					caseThree = LetsPinball(r, c, 0, 1);
					caseFour = LetsPinball(r, c, 0, -1);
					res = Math.max(res, caseOne);
					res = Math.max(res, caseTwo);
					res = Math.max(res, caseThree);
					res = Math.max(res, caseFour);
				}
			}
			sb.append(res);
			System.out.println(sb);
		} // tc for
	} // main

	public static int LetsPinball(int r, int c, int dr, int dc) {
		cnt = 0;
		round = 0;
		arrMove[0] = r;
		arrMove[1] = c;
		arrMove[2] = dr;
		arrMove[3] = dc;
		isOK = true;
		while (isOK) {
			maxPoint(arrMove[0], arrMove[1], arrMove[2], arrMove[3]);
		}
		return cnt;
	}

	public static void maxPoint(int r, int c, int dr, int dc) {
		// if the ball crash with the wall
		round++;

		// end case
		if (round != 1 && ((r == first_r && c == first_c) || arr[r][c] == -1)) {
			isOK = false;
			return;
		}
		// case : current element -> is it a blank space/block/worm hole ?
		switch (arr[r][c]) {
		case 0:
			arrMove[0] += arrMove[2];
			arrMove[1] += arrMove[3];
			return;
		case 1:
			cnt++;
			if (dr == 1) {
				arrMove[2] = 0;
				arrMove[3] = 1;
			} else if (dc == -1) {
				arrMove[2] = -1;
				arrMove[3] = 0;
			} else {
				arrMove[2] = -dr;
				arrMove[3] = -dc;
			}
			break;
		case 2:
			cnt++;
			if (dr == -1) {
				arrMove[2] = 0;
				arrMove[3] = 1;
			} else if (dc == -1) {
				arrMove[2] = 1;
				arrMove[3] = 0;
			} else {
				arrMove[2] = -dr;
				arrMove[3] = -dc;
			}
			break;
		case 3:
			cnt++;
			if (dr == -1) {
				arrMove[2] = 0;
				arrMove[3] = -1;
			} else if (dc == 1) {
				arrMove[2] = 1;
				arrMove[3] = 0;
			} else {
				arrMove[2] = -dr;
				arrMove[3] = -dc;
			}
			break;
		case 4:
			cnt++;
			if (dr == 1) {
				arrMove[2] = 0;
				arrMove[3] = -1;
			} else if (dc == 1) {
				arrMove[2] = -1;
				arrMove[3] = 0;
			} else {
				arrMove[2] = -dr;
				arrMove[3] = -dc;
			}
			break;
		case 5:
			cnt++;
			arrMove[2] = -dr;
			arrMove[3] = -dc;
			break;
		default: // case : positioned at worm hole
			int[] idxWH = findPair(r, c);
			arrMove[0] = idxWH[0];
			arrMove[1] = idxWH[1];
			break;
		} // sw-c
		arrMove[0] += arrMove[2];
		arrMove[1] += arrMove[3];
		return;
	} // maxPoint

	public static int[] findPair(int r, int c) {
		int[] arr_return = new int[2];
		int numFind = (arr[r][c] - 6) * 2;
		// save idx of first WH
		if (arrWH[numFind][0] == r && arrWH[numFind][1] == c) {
			arr_return[0] = arrWH[numFind + 1][0];
			arr_return[1] = arrWH[numFind + 1][1];
		} else {
			arr_return[0] = arrWH[numFind][0];
			arr_return[1] = arrWH[numFind][1];
		} // save idx of second WH
		return arr_return;
	} // findPair
	
} // class
