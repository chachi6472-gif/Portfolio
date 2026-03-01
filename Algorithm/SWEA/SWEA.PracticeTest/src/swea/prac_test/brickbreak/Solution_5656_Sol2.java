package swea.prac_test.brickbreak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_Sol2 {
	static int N, W, H, minRest;
	static int[] brickInfo;
	static int[][] arr;
	// clockwise, start at 12
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src\\swea\\prac_test\\brickbreak\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		// Given condition : 1 <= N <= 4 | 2 <= W <= 12 | 2 <= H <= 15
		// make #{bricks} minimal
		// there can exist W power N cases s.t. N = 4, W = 12 ( maximal case )
		// => then #cases : 12^4 ( First position of brick : 1~12, ..., Fourth : 1~12 )
		// 10^4 < 12^4 < 10^5 => this number is computable. Thus put all cases into ft.
		for (int tc = 1; tc <= T; tc++) {
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
			} // input

			minRest = W * H;
			dropTheBricks(0, arr);

			sb.append(minRest).append("\n");
		} // tc for
		System.out.println(sb);

	} // main

	static void dropTheBricks(int depth, int[][] arr) {
		int remain = countBricks(arr);

		if (remain == 0) {
			minRest = 0;
			return;
		}

		if (depth == N) {
			minRest = Math.min(minRest, remain);
			return;
		}
		
		for (int c = 0 ; c < W ; c++) {
			int Row = findFirstBrick(c,arr);
			if(Row == -1) continue;
			
			int[][] newArr = copy(arr);
			
			boom(Row, c, newArr);
			downBricks(newArr);
			
			dropTheBricks(depth+1, newArr);
		}
	} // method : drop the bricks

	
	static int findFirstBrick(int idxC, int[][] arr) {
		for(int i = 0 ; i < H ; i++) {
			if(arr[i][idxC] > 0) return i;
		}
		return -1;
	}
	
	static void boom(int r, int c, int[][] arr) {
		Queue<int[]> q = new LinkedList<>();
		
		if(arr[r][c]>1) {
			q.add(new int[] {r, c, arr[r][c]});
		}
		
		arr[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int power = curr[2];
			
			for(int d = 0 ; d < 4 ; d++) {
				for (int p = 1 ; p < power ; p++) {
					int nr = curr[0] + dr[d]*p;
					int nc = curr[1] + dc[d]*p;
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
						break;
					}
					if (arr[nr][nc] == 0) {
						continue;
					}
					if(arr[nr][nc] > 1) {
						q.add(new int[] {nr, nc, arr[nr][nc]});
					}
					
					arr[nr][nc] = 0;
				}
			}
		}
	}
	
	static void downBricks(int[][] arr) {
		for (int c = 0 ; c < W ; c++) {
			int bottom = H-1;
			
			for (int r = H-1 ; r >= 0 ; r--) {
				if (arr[r][c]>0) {
					arr[bottom][c] = arr[r][c];
					if(bottom != r) {
						arr[r][c] = 0;
					}
					bottom--;
				}
			}
		}
	}
	
	static int countBricks(int[][] arr) {
		int cnt = 0;
		
		for(int c = 0; c < W ; c++) {
			for (int r = 0 ; r < H ; r++) {
				if (arr[r][c] > 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static int[][] copy(int[][] arr){
		int[][] newArr = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			System.arraycopy(arr[i], 0, newArr[i], 0, W);
		}
		return newArr;
	}
} // class
