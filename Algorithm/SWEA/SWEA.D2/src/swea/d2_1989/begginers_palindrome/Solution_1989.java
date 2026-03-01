package swea.d2_1989.begginers_palindrome;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1989 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d2_1989\\begginers_palindrome\\input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String isPal = sc.next();
			char[] sToChar = isPal.toCharArray();
			int res = 0;
			for (int j = 0; j < isPal.length() / 2; j++) {
				;
				if (sToChar[0] == sToChar[sToChar.length - 1]) {
					res = 1;
					continue;
				} else {
					res = 0;
					break;
				}
			}
			System.out.println("#" + i + " " + res);
		}
	}
}
