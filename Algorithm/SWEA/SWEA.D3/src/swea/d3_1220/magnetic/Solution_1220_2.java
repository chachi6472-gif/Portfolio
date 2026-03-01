package swea.d3_1220.magnetic;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 정렬을 해서 한쪽으로 몰아버려도 될듯 -> 그게 더 좋겠다
// 1220_2 는 정렬로 풀어보자

public class Solution_1220_2 {
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
			}
			int total = 0;
			for (int i = 0; i < 100; i++) {
				int[] colVec = new int[100];
				for (int j = 0; j < 100; j++) {
					colVec[j] = arr[j][i];
				} // 100개짜리 colVec에 모든 원소 저장
				////////////////////// Test ////////////////////////////////////
//				System.out.println(Arrays.toString(colVec));
				sortColVec(colVec);
//				System.out.println(Arrays.toString(colVec));
//				System.out.println(numDeadLock(colVec));
				total += numDeadLock(colVec);
			}
//			System.out.println(total);
			System.out.println("#" + magneeeric + " " + total);
		}
	}

	public static void sortColVec(int[] arr) { // 열벡터의 0이 아닌 숫자 1, 2를 모두 앞쪽으로 몰아주자
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 99; i++) {
				if (arr[i] == 0 && arr[i + 1] != 0) {
					arr[i] = arr[i + 1];
					arr[i+1] = 0;
				}
			}
		}
	}

	public static int numDeadLock(int[] arr) {
		int cnt = 0;
		for (int row = 0; row < 99; row++) {
			if (arr[row] == 1) {
				if (arr[row + 1] == 2) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
