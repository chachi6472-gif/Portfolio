package swea.d4_5432.pipecut;

import java.io.FileNotFoundException;
import java.util.Scanner;

// 스택 없이 풀어보기_2 ( 런타임 오류
public class Solution_5432_TimeIssue2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d4_5432\\pipecut\\sample_input.txt");
//		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			String pipes = sc.next();
			char[] pipeList = pipes.toCharArray();
			boolean[] booList = new boolean[pipes.length()];
			laserPoint(pipeList, booList);
			int N = pipes.length();
			int cnt = 0;

//			System.out.println(pipeList.length + " " + Arrays.toString(pipeList));
//			System.out.println(booList.length + " " + Arrays.toString(booList));

			for (int i = 0; i < N; i++) {
				int end;
				if (pipeList[i] == '(') {
					end = endPoint(pipeList, i);
				} else continue;
				if (end - i + 1 == 2) {
					continue;
				}
				for(int j = i; j < end; j++) {
					if(booList[j]) {
						cnt++;
					}
					if (j == end - 1) {
						cnt++;
					}
				}
				
			}

			System.out.println("#" + tc + " " + cnt);
		} // Test Case for
	} // main

	public static int endPoint(char[] arr, int start) {
		int cnt = 0;
		int end = 0;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] == '(') {
				cnt++;
			} else {
				cnt--;
			}
			if (cnt == 0) {
				end = i;
				break;
			}
		}
		return end;
	}

	public static boolean[] laserPoint(char[] arr, boolean[] bool) {
		int lenOri = arr.length;
		for (int i = 0; i < lenOri - 1; i++) {
			if (arr[i] == '(' && arr[i + 1] == ')') {
				bool[i + 1] = true;
				i++;
			}
		}
		return bool;
	}
}
