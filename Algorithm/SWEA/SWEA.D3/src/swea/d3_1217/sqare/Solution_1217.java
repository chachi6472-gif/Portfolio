package swea.d3_1217.sqare;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1217 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d3_1217\\sqare\\input.txt");
//		Scanner sc = new Scanner(input);
			
		for ( int tc = 0 ; tc < 10 ; tc++) {
			int T = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println("#" + T + " " + square(A,B));
		}
		
	}

	public static  int square(int a, int b) {
		if (b <= 1) {
			return a;
		}
		b--;
		
		return square(a, b)*a;
	}
	
	
}

//	
//	
//	
//		square(2,3)
//		b = 2 , return 2 * square (2, 2)
//		b = 1 , return 2 * 2 * square ( 2 , 1 )
// 		b = 1 , return a = 2 -> 2 * 2 * 2 = 8
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
