package swea.d3_1215.palindrome1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1215 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d3_1215\\palindrome1\\input.txt");
//		Scanner sc = new Scanner(input);

		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String[] lineChar = new String[8];
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				lineChar[i] = sc.next();
				arr[i] = lineChar[i].toCharArray();
			} // arr 잘 만들어짐
			int divLen = len / 2;
			int cnt = 0;
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8 - len + 1; c++) {
					int colCnt = 0;
					for (int ext = 0; ext < divLen; ext++) {
						if (arr[r][c + ext] == arr[r][c + len - 1 - ext]) {
							colCnt++;
						} else
							break;
					}
					if (colCnt == divLen) {
						cnt++;
					}

				}
			}
			for (int r = 0; r < 8 - len + 1; r++) {
				for (int c = 0; c < 8; c++) {
					int rowCnt = 0;
					for (int ext = 0; ext < divLen; ext++) {
						if (arr[r + ext][c] == arr[r + len - 1 - ext][c]) {
							rowCnt++;
						} else
							break;
					}
					if (rowCnt == divLen) {
						cnt++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // [ tc for ]
	} // [ main ]
} // [ class ]
