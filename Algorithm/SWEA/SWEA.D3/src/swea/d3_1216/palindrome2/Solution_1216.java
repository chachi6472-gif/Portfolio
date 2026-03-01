package swea.d3_1216.palindrome2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1216 {
	public static void main(String[] args) throws FileNotFoundException {
//		File input = new File("src\\swea\\d3_1216\\palindrome2\\input.txt");
//		Scanner sc = new Scanner(input);
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			String[] lineIdx = new String[100];
			for (int i = 0; i < 100; i++) {
				lineIdx[i] = sc.next();
			}
			char[][] arr = new char[100][100];
			for (int r = 0; r < 100; r++) {
				arr[r] = lineIdx[r].toCharArray();
			} // 여기까지 2차원 char 배열 arr 만들기 성공
			int maxLength = 0;
			for (int row = 0; row < 100; row++) {
				for (int col = 0; col < 100; col++) {
					int max_rowFix = calMaxLen(arr, row, col);
//					System.out.println("(" + row + ", " + col + ") | " + max_rowFix + ", " + max_colFix + ", " + maxLength);
					if (max_rowFix > maxLength) {
						maxLength = max_rowFix;
					}

//					int max_colFix = calMaxLen(arr, col, row);
//					if (max_colFix > maxLength) {
//						maxLength = max_colFix;
//					}
				}
//				System.out.println();
			}
			System.out.println("#" + T + " " + maxLength);

		} // tcf
	} // main

	// (i,j)의 원소와 동일한 char의 위치를 반대편 행/열부터 찾고 좌표 반환
	public static int calMaxLen(char[][] arr, int row, int col) {

		int max = 0;
		for (int i = 0; i < 99 - col; i++) {
			int maxLength = 0;
			char curr = arr[row][99 - i];
			if (arr[row][col] == curr) {
				int cnt = 0;
				for (int j = 0; j < (100 - i - col) / 2; j++) {
					if (arr[row][col + j] == arr[row][99 - i - j]) {
						cnt++;
					} else
						break;
					if ((100 - i - col) / 2 == cnt) {
						maxLength = 100 - i - col;
					}
					if (maxLength > max) {
						max = maxLength;
					}
				}
			}
		} // 행 고정 최대값 뽑아내기

		for (int i = 0; i < 99 - row; i++) {
			int maxLength = 0;
			char curr = arr[99 - i][col];
			if (arr[row][col] == curr) {
				int cnt = 0;
				for (int j = 0; j < (100 - i - row) / 2; j++) {
					if (arr[row + j][col] == arr[99 - i - j][col]) {
						cnt++;
					} else
						break;
					if ((100 - i - row) / 2 == cnt) {
						maxLength = 100 - i - row;
					}
					if (maxLength > max) {
						max = maxLength;
					}
				}
			}
		}
		return max;
	} // calcMaxLen
} // class
