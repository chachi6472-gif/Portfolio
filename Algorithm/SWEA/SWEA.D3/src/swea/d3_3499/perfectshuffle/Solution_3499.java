package swea.d3_3499.perfectshuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_3499 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_3499\\perfectshuffle\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			String[] arr = new String[N];
			int num = N/2 + (N%2);
			
			for (int cs = 0; cs < N; cs++) {
				String tmp = sc.next();
					
				
				if (cs < num) {
					arr[cs*2] = tmp;
				} else {
					arr[2*cs - N + (N+1)%2 ] = tmp;
				}
			}
			
//			System.out.println(Arrays.toString(arr));
			System.out.print("#" + tc + " ");
			for(int i = 0 ; i < N ; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}
}
