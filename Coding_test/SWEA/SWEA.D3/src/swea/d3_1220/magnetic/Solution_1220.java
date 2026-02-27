package swea.d3_1220.magnetic;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 정렬을 해서 한쪽으로 몰아버려도 될듯 -> 그게 더 좋겠다

public class Solution_1220 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File uuuUuuuUu = new File("src\\swea\\d3_1220\\magnetic\\input.txt");
//		Scanner sc = new Scanner(uuuUuuuUu);

		for (int magneeeric = 1; magneeeric <= 10; magneeeric++) {
			int[][] arr = new int[100][100];
			int side = sc.nextInt();
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt(); // N극(위) 1 | S극(아래) 2
				}
			} // 2차원 배열 생성 | 잘 들어옴
			
			///////////// Test /////////////////////////////
//			for (int i = 0; i < 100; i++) {
////				System.out.print(arr[i][0]);
//				System.out.print(arr[i][99]);
//			} // 원본
//			System.out.println();
//			moveMag(arr);
//			for (int i = 0; i < 100; i++) {
////				System.out.print(arr[i][0]);
//				System.out.print(arr[i][99]);
//			}
//			System.out.println();
			for (int i = 0; i < 50; i++) { // 가장 늦게 교착에 빠지는 경우 2 0 0 ... 0 0 1
				moveMag(arr);
			}
//			for (int i = 0; i < 100; i++) {
////				System.out.print(arr[i][0]);
//				System.out.print(arr[i][99]);
//			}
//			System.out.println();
//			System.out.println(numDeadLock(arr));
			////////////////////////////////////////////////////
			System.out.println("#" + magneeeric + " " + numDeadLock(arr));
		}
	}

	public static void moveMag(int[][] arr) {
		for (int col = 0; col < 100; col++) {
			for (int row = 0; row < 99; row++) {
//				arr[row][column] = 1;
				// 맨 위에 S극 또는 맨 아래에 N극 도착하면 떨구기
				if (arr[0][col] == 2) {
					arr[0][col] = 0;
				}
				if (arr[99][col] == 1) {
					arr[99][col] = 0;
				}
				// 위/아래에서 열 방향(수직)으로 이동
				if (arr[row][col] == 1) {
					if (arr[row + 1][col] == 0) {
						int tmp = arr[row][col];
						arr[row + 1][col] = tmp;
						arr[row][col] = 0;
					}
				}
				if (arr[99 - row][col] == 2) {
					if (arr[98 - row][col] == 0) {
						int tmp = arr[99 - row][col];
						arr[98 - row][col] = tmp;
						arr[99 - row][col] = 0;
					}
				}
			}
		}
	}

	public static int numDeadLock(int[][] arr) {
		int cnt = 0;
		for (int col = 0; col < 100; col++) {
			for (int row = 0; row < 99; row++) {
				if(arr[row][col]==1) {
					if(arr[row+1][col] == 2) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
