package swea.d3_10726.binary_notation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_10726_while_sol {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_10726\\binary_notation\\input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Integer.parseInt(st.nextToken());

//			System.out.println("--------------------------------------------");
			System.out.print("#" + tc + " ");
			long tmp = M;
			int cnt = 0;
			if (tmp == 0) {
				System.out.println("OFF");
				continue;
			}
			while (tmp != 0 && cnt <= N) {
				
//				System.out.print("cnt : " + cnt);
//				System.out.print(" | ");
//				System.out.print("tmp : " + tmp);
//				System.out.println(" | tmp mod : " + tmp%2);
				
				if (tmp % 2 == 0) {
					break;
				}
				tmp /= 2;
				cnt++;
				
			}
			if (cnt >= N) {
				System.out.println("ON");
			} 
			else {
				System.out.println("OFF");
			}
		}
	}
}
