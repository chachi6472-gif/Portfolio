package swea.d3_1209.sum;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1209_ToUpload {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int row = 0; row < 100; row++) {
				for (int col = 0; col < 100; col++) {
					arr[row][col] = sc.nextInt();
				}
			}
			int[] lineSum = new int[202]; // 0 ~ 201
			for (int i = 0; i < 100; i++) {
				lineSum[i] = maxValLine(arr, i, 0, 0, 1); // 0 ~ 99
				lineSum[i + 100] = maxValLine(arr, 0, i, 1, 0); // 100 ~ 199
			}
			lineSum[200] = maxValLine(arr, 0, 0, 1, 1);
			lineSum[201] = maxValLine(arr, 99, 99, -1, -1);
			bubbleSort(lineSum);
			System.out.println("#" + T + " " + lineSum[201]);
		}
	}

	public static int maxValLine(int[][] arr, int startR, int startC, int dr, int dc) {
		int total = arr[startR][startC];
		for (int i = 1; i < 100; i++) {
			startR += dr;
			startC += dc;
			total += arr[startR][startC];
		}
		return total;
	}

	public static void bubbleSort(int[] arr) { // 버블 정렬을 사용해보자
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) { // 여기가 문제였다
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

}
