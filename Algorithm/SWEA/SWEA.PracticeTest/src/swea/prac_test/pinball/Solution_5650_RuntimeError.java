package swea.prac_test.pinball;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5650_RuntimeError {
	static int first_r;
	static int first_c;
	static int N;
	static int[][] arr;
	static int[][] arrWH;
	static int cnt;
	static int round;

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
			arr = new int[N][N];
			arrWH = new int[10][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for (int j = 0; j < N; j++) {
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
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] != 0) {
						continue;
					}
					first_r = r;
					first_c = c;
					cnt = 0;
					round = 0;
					maxPoint(r, c, 1, 0);
					if (cnt > res) {
						res = cnt;
					}

					cnt = 0;
					round = 0;
					maxPoint(r, c, -1, 0);
					if (cnt > res) {
						res = cnt;
					}

					cnt = 0;
					round = 0;
					maxPoint(r, c, 0, 1);
					if (cnt > res) {
						res = cnt;
					}

					cnt = 0;
					round = 0;
					maxPoint(r, c, 0, -1);
					if (cnt > res) {
						res = cnt;
					}
				}
			}
			sb.append(res);
			System.out.println(sb);
		} // tc for
	} // main

	public static void maxPoint(int r, int c, int dr, int dc) {
		// if the ball crash with the wall
		round++;
//		System.out.println(round);
		if (r < 0) {
			cnt++;
			maxPoint(r + 1, c, 1, 0);
			return;
		}
		if (r >= N) {
			cnt++;
			maxPoint(r - 1, c, -1, 0);
			return;
		}
		if (c < 0) {
			cnt++;
			maxPoint(r, c + 1, 0, 1);
			return;
		}
		if (c >= N) {
			cnt++;
			maxPoint(r, c - 1, 0, -1);
			return;
		}

		// end case
		if (round != 1 && ((r == first_r && c == first_c) || arr[r][c] == -1)) {
			return;
		}

		int currNum = arr[r][c];
		switch (currNum) {
		case 0:
			maxPoint(r + dr, c + dc, dr, dc);
			break;
		case 1:
			cnt++;
			if (dr == 1) {
				maxPoint(r, c + 1, 0, 1);
			} else if (dr == -1) {
				maxPoint(r + 1, c, 1, 0);
			} else if (dc == 1) {
				maxPoint(r, c - 1, 0, -1);
			} else if (dc == -1) {
				maxPoint(r - 1, c, -1, 0);
			}
			break;
		case 2:
			cnt++;
			if (dr == 1) {
				maxPoint(r - 1, c, -1, 0);
			} else if (dr == -1) {
				maxPoint(r, c + 1, 0, 1);
			} else if (dc == 1) {
				maxPoint(r, c - 1, 0, -1);
			} else if (dc == -1) {
				maxPoint(r + 1, c, 1, 0);
			}
			break;
		case 3:
			cnt++;
			if (dr == 1) {
				maxPoint(r - 1, c, -1, 0);
			} else if (dr == -1) {
				maxPoint(r, c - 1, 0, -1);
			} else if (dc == 1) {
				maxPoint(r + 1, c, 1, 0);
			} else if (dc == -1) {
				maxPoint(r, c + 1, 0, 1);
			}
			break;
		case 4:
			cnt++;
			if (dr == 1) {
				maxPoint(r, c - 1, 0, -1);
			} else if (dr == -1) {
				maxPoint(r + 1, c, 1, 0);
			} else if (dc == 1) {
				maxPoint(r - 1, c, -1, 0);
			} else if (dc == -1) {
				maxPoint(r, c + 1, 0, 1);
			}
			break;
		case 5:
			cnt++;
			maxPoint(r - dr, c - dc, -dr, -dc);
			break;
		default: // case : positioned at worm hole
			int[] idxWH = findPair(r, c);
			maxPoint(idxWH[0]+dr, idxWH[1]+dc, dr, dc);
			break;
		} // sw-c
		return;

	}

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
	}
} // class
