package swea.d3_11315.omok_judgment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_11315 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d3_11315\\omok_judgment\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			// make O-mok table
			int[][] arr = new int[N][N];

			// input table : if there is a stone, then value is 1. if not, then value is 0.
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					if (str.charAt(j) == 'o')
						arr[i][j] = 1;
				}
			}

//			System.out.println("-----------------" + tc + "-------------------");
			
			boolean isOmok = false;
			int currRow = 0;
			int currCol = 0;
			// delta : 12 1 3 5 6 7 9 11 | clockwise
			int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
 
					if (arr[r][c] == 1) {
//						System.out.println("초기 행, 열 : " + r + " , " + c);
						for (int i = 0; i < 8; i++) {
							currRow = r;
							currCol = c;
//							System.out.println("현재 행, 열 : " + currRow + " , " + currCol);

							for (int d = 1; d < 5; d++) {
								currRow += dr[i];
								currCol += dc[i];
//								System.out.println("현재 델타 : " + i + " | 행, 열 : " + currRow + " , " + currCol);
//								System.out.println(isOmok);
								// if index is in the range [0,N) :
								if (currRow < N && currRow >= 0 && currCol < N && currCol >= 0) {
									// if there is a stone : true and continue
									if (arr[currRow][currCol] == 1) {
										isOmok = true;
										continue;
									}
									// if not : false and break -> find next case by next delta
									else {
										isOmok = false;
//										System.out.println("얘는 안됨");
										break;
									}
								}
								// else index is out of range :
								else {
									isOmok = false;
//									System.out.println("얘는 안됨");
									break;
								}
							} // for : search by delta
//							System.out.println();
							
							// if find O-mok -> break -> break -> break -> yes
							if (isOmok) {
//								System.out.println("저는 나가요~~~");
								break;
							}
						} // for : 8 cases of delta

					} // if there exists a stone
					else continue; // else continue

					if (isOmok) {
						break;
					}
				} // for : column
				if (isOmok) {
					break;
				}
			} // for : row
			
			// 30분을 고민했는데 출력이 범인인 것 같다.
			if (isOmok) {
				sb.append("YES\n");
			} else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
}
