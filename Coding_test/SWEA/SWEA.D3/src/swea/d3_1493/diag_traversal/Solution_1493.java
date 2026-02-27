package swea.d3_1493.diag_traversal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1493 {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_1493\\diag_traversal\\input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int x = whereP(p)[0] + whereP(q)[0];
			int y = whereP(p)[1] + whereP(q)[1];

			int comp = whatXY(x, y);

			System.out.println("#" + tc + " " + comp);

		}

//		int p = 3;
//		int q = 9;
//				
//		System.out.println("x of p : " + whereP(p)[0]);
//		System.out.println("y of p : " + whereP(p)[1]);
//		System.out.println("x of q : " + whereP(q)[0]);
//		System.out.println("y of q : " + whereP(q)[1]);
//		int x = whereP(p)[0] + whereP(q)[0];
//		int y = whereP(p)[1] + whereP(q)[1];
//		System.out.println("new x : " + x);
//		System.out.println("new y : " + y);
//		System.out.println("component of (" + x + ", " + y + ") : " + whatXY(x, y));
//		int before = 0;
//		for (int i = 1; i < numDiagLine(p); i++ ) {
//			before += i;
//		}
//		System.out.println(before);
//		for ( int i = 0; i <= p - before-1; i++) {
//			System.out.println((i+1) + "," + (numDiagLine(p)-i));
//		}
	}

	public static int[] whereP(int p) {
		int[] arr = new int[2];
		int line = 0;
		int currP = p;
		for (int i = 1; currP > 0; i++) {
			currP -= i;
			line++;
		}

		int before = 0;
		for (int i = 1; i < line; i++) {
			before += i;
		}

//		int x = 0;
//		int y = 0;
		for (int i = 0; i <= p - before - 1; i++) {
			arr[0] = i + 1; // x
			arr[1] = line - i; // y
//			System.out.println((i+1) + "," + (line-i));
		}
		return arr;
	}

	public static int whatXY(int x, int y) {
		int line = x + y - 1; // x,y 가 몇 번째 줄에 있는가
		int before = 0;
		for (int i = 1; i < line; i++) {
			before += i;
		} // 지난 줄의 마지막 숫자는 몇인가
		int num = before + (line - y + 1);

		return num;
	}

}
