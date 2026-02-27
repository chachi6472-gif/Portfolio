package swea.d2_1961.num_arr_rotate;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1961 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d2_1961\\num_arr_rotate\\input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			} // 잘 들어옴 // 행 고정 | 열 이동

			// 열 고정 | 행 이동으로 데이터를 받아보자
//			for (int c = 0; c < N; c++) {					// 애초에 데이터 입력 방식이 행을 고정하는데
//				for (int r = 0; r < N; r++) {				// 고정하는 애 이름을 c(열)로 두는 게 모순
//					arr[c][r] = sc.nextInt();				// => 몰라도 되겠다
//				}
//			} // 잘 들어옴
			
			////////////////////////////////////////////////////////////////////////////////////////// 원본

//			int[][] arr90 = new int[N][N];					// 열 고정 | 행 이동
//			for (int c = 0; c < N; c++) {
//				for (int r = 0; r < N; r++) {
//					arr90[r][c] = arr[N - 1 - c][r];
//				}
//			}

			// 행 고정 | 열 이동으로 90도 회전변환을 해보자
			int[][] arr90 = new int[N][N];					// 행 고정 | 열 이동
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr90[r][c] = arr[N-1-c][r];
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////// 90도

//			int[][] arr180 = new int[N][N]; 				// 행 고정 | 열 이동
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					arr180[r][c] = arr[N - 1 - r][N - 1 - c];
//				}
//			}
			
			// 열 고정 | 행 이동으로 180도 회전변환을 해보자
			int[][] arr180 = new int[N][N]; 				// 열 고정 | 행 이동
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					arr180[r][c] = arr[N-1-r][N-1-c];
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////// 180도

//			int[][] arr270 = new int[N][N]; 				// 열 고정 | 행 이동
//			for (int c = 0; c < N; c++) {
//				for (int r = 0; r < N; r++) {
//					arr270[r][c] = arr[c][N - 1 - r];
//				}
//			}
			
			// 행 고정 | 열 이동으로도 270도 변환을 해보자
			int[][] arr270 = new int[N][N]; 				// 행 고정 | 열 이동
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr270[r][c] = arr[c][N-1-r];
				}
			}

			////////////////////////////////////////////////////////////////////////////////////////// 270도
			
//			System.out.println("----원본-----");
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println("----90도 회전-----");
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(arr90[i]));
//			}
//			System.out.println("----180도 회전-----");
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(arr180[i]));
//			}
//			System.out.println("----270도 회전-----");
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(arr270[i]));
//			}
			
			///////////////////////////////////////////////////////////////////////////////////////////
			
			System.out.println("#" + tc);
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0; j < N ; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N ; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N ; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
	}
}
