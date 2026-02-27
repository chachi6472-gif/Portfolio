package swea.d2_1926.samyukgu;

import java.util.Scanner;

public class Solution_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			if (num3(i, 3) > 0 || num3(i, 6) > 0 || num3(i, 9) > 0) {
				for (int j = 0; j < num3(i, 3) + num3(i, 6) + num3(i, 9); j++) {
					System.out.print("-");
				}
			}
			else {
				System.out.print(i);
			}
			System.out.print(" ");
		}
	}

	public static int num3(int n, int tsn) {
		int c = 0;
		if (n == 0) {
			return 0;
		}
		if (n % 10 == tsn) {
			c++;
			n /= 10;
		} else {
			n /= 10;
		}
		return num3(n, tsn) + c;
	}
}