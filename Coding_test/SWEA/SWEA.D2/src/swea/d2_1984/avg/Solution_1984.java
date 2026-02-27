package swea.d2_1984.avg;

import java.util.Scanner;

public class Solution_1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9 - j; i++) {
					if (arr[i] > arr[i + 1]) {
						int tmp = arr[i + 1];
						arr[i + 1] = arr[i];
						arr[i] = tmp;
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
			float total = 0;
			for (int i = 1; i <9 ; i++) {
				total += arr[i];
			}
			float avg = total/8;
			System.out.printf("#%d %.0f", tc, avg);
			System.out.println();
			
		}

	}

}
