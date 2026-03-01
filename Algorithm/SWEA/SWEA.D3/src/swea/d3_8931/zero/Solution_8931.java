package swea.d3_8931.zero;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_8931 {
	public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d3_8931\\zero\\sample_input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			
			int total = 0;
			int[] numList = new int[K];
			int curr = -1;
			for (int i = 0 ; i < K ; i++) {
				int n = sc.nextInt();
				if(n == 0 && curr > -1) {
					numList[curr--] = 0;
				} else {
					numList[++curr] = n;
				}
			} // K
			for (int i = 0 ; i < numList.length; i++) {
				total += numList[i];
			}
			
			System.out.println("#" + tc + " " + 
			total);
			
		} // tc

	} // main
}
