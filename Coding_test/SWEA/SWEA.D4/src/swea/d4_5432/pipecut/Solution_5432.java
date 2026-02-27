package swea.d4_5432.pipecut;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 스택 없이 풀어보기_3 갈아엎자 ( 런타임 오류
public class Solution_5432 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d4_5432\\pipecut\\sample_input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			String pipes = sc.next();
			char[] pipeList = pipes.toCharArray();
			int N = pipes.length();
			int cnt = 0;
			int total = 0;

			for (int i = 0; i < N - 1; i++) {
				if (pipeList[i] == '(' && pipeList[i + 1] == ')') {
					total += cnt;
					i++;
					continue;
				} else if (pipeList[i] == '(') {
					cnt++;
					total++;
				} else {
					cnt--;
				}
			}

			System.out.println("#" + tc + " " + total);
		} // Test Case for
	} // main
}

//						( ( ( ( ) ( ( ) ( ) ) ) ( ( ) ) ( ) ) )				 ( ( ) ( ) )