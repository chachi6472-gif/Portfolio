package swea.d3_1213.string;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1213_ToUpload {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			String find = sc.next();
			String sent = sc.next();
			char[] arrFind = find.toCharArray();
			char[] arrSent = sent.toCharArray();
			int lenF = arrFind.length;
			int lenS = arrSent.length;
			int total = 0;
			for (int i = 0; i < lenS - lenF + 1; i++) {
				int cnt = 0;
				for (int j = 0 ; j < lenF ; j++) {
					if (arrSent[i+j] == arrFind[j]) {
						cnt++;
						continue;
					} else break;
				}
				if (cnt == arrFind.length) {
					total++;
				}
			}
			System.out.println("#" + T + " " + total);
		}
	}
}
