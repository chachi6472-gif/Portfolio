package swea.prac_test.runway;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\prac_test\\runway\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		// 6 <= N <= 20
		// height slide = 1
		// 2 <= X <= 4
		// height land H : 1 <= H <= 6

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			int maxH = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (maxH < arr[i][j]) {
						maxH = arr[i][j];
					}
				}
			} // arr input
			int res = 0;
			int idxBug = 0;
			for (int r = 0; r < N; r++) {
				boolean isAble = true;
				int cFirst = arr[r][0];
				int cLast = arr[r][N - 1];
				int idx = -1;

				// if blocks from 0 to X-1 are diff -> break
				for (int c1 = 0; c1 < X; c1++) {
					if (arr[r][c1] > cFirst) {
						isAble = false;
						break;
					}
				}
				if (!isAble) {
//					System.out.println(r + "행은 1번 위치에서 나가용");
					continue;
				}

				// if blocks from N-1 to N-X are diff -> break
				for (int c2 = N - 1; c2 >= N - X; c2--) {
					if (arr[r][c2] > cLast) {
						isAble = false;
						break;
					}
				}
				if (!isAble) {
//					System.out.println(r + "행은 2번 위치에서 나가용");
					continue;
				}

				// remain cases
				int preH = arr[r][0];
				for (int c = 1; c < N; c++) {
					// save current element in currH
					preH = arr[r][c-1];
					int currH = arr[r][c];
					// if both are same -> continue
					if (preH == currH) {
						continue;
					}
					// if diff > 1 -> break
					if (Math.abs(preH - currH) > 1) {
						isAble = false;
						idxBug = 3;														// bug 3
						break;
					}
					// if left is bigger than right ( left = right + 1 )
					if (preH > currH) {
						for(int i = c ; i < c+X ; i++) {
							if(currH == arr[r][i]) {
								continue;
							} else {
								isAble = false;
								idxBug = 4;												// bug 4
								break;
							}
						}
						if(!isAble) {
							break;
						} else {
							idx = c+X-1;
						}
					} 
					// if right is bigger than left ( right = left + 1 )
					else {
						for(int i = c-1 ; i >= c-X ; i--) {
							if(preH == arr[r][i]) {
								continue;
							} else {
								isAble = false;
								idxBug = 5;												// bug 5
								break;
							}
						}
						if(!isAble) {
							break;
						}
						if(idx >= c-X) {
							isAble = false;
							idxBug = 6;													// bug 6
							break;
						}
						if(isAble) {
							idx = c-1;
						}
					}
					
					// if isAble = true, res++
					
				}
				
				if(isAble) {
					res++;
//					System.out.println(r + "번째 행은 개넝~");
				} else {
//					System.out.println(r + "번째 행은 unAble~~" + " | 문제는 " + idxBug + "번 입니다~");
				}
				
			} // row search
			
			for (int c = 0; c < N; c++) {
				boolean isAble = true;
				int rFirst = arr[0][c];
				int rLast = arr[N-1][c];
				int idx = -1;
				
				// if blocks from 0 to X-1 are diff -> break
				for (int r1 = 0; r1 < X; r1++) {
					if (arr[r1][c] > rFirst) {
						isAble = false;
						break;
					}
				}
				if (!isAble) {
//					System.out.println(c + "열은 1번 위치에서 나가용");
					continue;
				}
				
				// if blocks from N-1 to N-X are diff -> break
				for (int r2 = N - 1; r2 >= N - X; r2--) {
					if (arr[r2][c] > rLast) {
						isAble = false;
						break;
					}
				}
				if (!isAble) {
//					System.out.println(c + "열은 2번 위치에서 나가용");
					continue;
				}
				
				// remain cases
				int preH = arr[0][c];
				for (int r = 1; r < N; r++) {
					// save current element in currH
					preH = arr[r-1][c];
					int currH = arr[r][c];
					// if both are same -> continue
					if (preH == currH) {
						continue;
					}
					// if diff > 1 -> break
					if (Math.abs(preH - currH) > 1) {
						isAble = false;
						idxBug = 3;														// bug 3
						break;
					}
					// if left is bigger than right ( left = right + 1 )
					if (preH > currH) {
						for(int i = r ; i < r+X ; i++) {
							if(currH == arr[i][c]) {
								continue;
							} else {
								isAble = false;
								idxBug = 4;												// bug 4
								break;
							}
						}
						if(!isAble) {
							break;
						} else {
							idx = r+X-1;
						}
					} 
					// if right is bigger than left ( right = left + 1 )
					else {
						for(int i = r-1 ; i >= r-X ; i--) {
							if(preH == arr[i][c]) {
								continue;
							} else {
								isAble = false;
								idxBug = 5;												// bug 5
								break;
							}
						}
						if(!isAble) {
							break;
						}
						if(idx >= r-X) {
							isAble = false;
							idxBug = 6;													// bug 6
							break;
						}
						if(isAble) {
							idx = r-1;
						}
					}
					
					// if isAble = true, res++
					
				}
				
				if(isAble) {
					res++;
//					System.out.println(c + "번째 열은 개넝~");
				} else {
//					System.out.println(c + "번째 열은 unAble~~" + " | 문제는 " + idxBug + "번 입니다~");
				}
				
			} // column search

//			System.out.println(res);
//			System.out.println("------------------------------------");
			sb.append(res).append("\n");
		} // tc for
		System.out.println(sb);
	}
}
