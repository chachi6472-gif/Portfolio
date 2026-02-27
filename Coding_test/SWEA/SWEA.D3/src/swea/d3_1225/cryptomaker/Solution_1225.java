package swea.d3_1225.cryptomaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_1225\\cryptomaker\\input.txt");
		Scanner sc = new Scanner(input);

		for (int tc = 1; tc <= 10; tc++) {
			int[] arr = new int[8];
			int T = sc.nextInt();

			Queue<Integer> cQ = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
				cQ.add(arr[i]);
			}

			int cnt = 0;
			int curr = 0;
			while (true) {
				curr = cQ.remove();
				cnt++;
				curr -= cnt;
				if (curr <= 0) {
					cQ.add(0);
					break;
				}
				if (cnt == 5) {
					cnt = 0;
				}
				cQ.add(curr);
			}

//			System.out.println(Arrays.toString(cQ.toArray()));

			System.out.print("#" + tc + " ");

			for (Object k : cQ.toArray()) {
				System.out.print(k + " ");
			}
			System.out.println();

		}
	}
}