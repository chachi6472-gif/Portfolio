package swea.d4_5432.pipecut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// 스택 없이 풀어보기
public class Solution_5432_SimilarButTimeFail {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d4_5432\\pipecut\\sample_input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();

		// ASCII
		// ( : 40 ) : 41
		for (int tc = 1; tc <= T; tc++) {
			// ()_(( (()()) (())() ))_(()) splits by () -> num : 2+2 | 1
			// ㄴ not a good model. cnt = 0 -> 1 -1 = 0 => get 1th_pipe | change logic to get
			// pipes
			// (( ( | | )_( | ) | ) )( | ) result
			// (( () () )) : we will cut 3 pipes | length : 8 + 1 = 9
			// cutting point : 4th, 6th
			// ( ) : cut 1 pipes | length : 2 + 1 = 3 | cut point : 2th
			//////////////////////////////////////////
			/////////////////////////// logic changed
			//////////////////////////////////////////
			// 0.1. we will make laser point as boolean lp = new boolean[pipe.len] -> true :
			// cutting
			// 0.2. (added rule from 8.1 : if (), len of () is not 2 like ( : 1 | ) : 2 =>
			// idx = 1
			// 1. find pipe with this logic. if cnt=0 twice include starting point,
			// then max_cnt = # {pipes of that bound}
			// [ example. middle case of tc_1 ]
			// ( ( ( () () ) ( () ) () ) ) : 2th pipe with len = 16 | #( 1, 1, ..., 1, 1 ) =
			// 16
			// 2.1. if 1's pipe = () -> index of ) will be laser point and end that ->
			// point.laser : idx of )
			// 2.2. else, do 1 again with set case cnt=1.-> idx : 1th and 16th -> 2_1th pipe
			// with len 16
			// ( _ ( ( () () ) ( ( ) ) ( ) ) _ )
			// 3. remove the point of cnt = 1 above
			// ( ( () () ) ( () ) () ) -> 2_2th pipe 2 to 15 -> len : 13
			// 4.1. if pipe = () -> idx of ) will be laser point
			// 4.2. else, do 2.2 -> pipe.len : 6, 4
			// (_ ( () () ) v ( () ) v () )_ | v : cnt = 1 , _ : cnt = 0
			// ( () () ) ( () ) ()
			// 5. do 3
			// 6.1. idx of ) -> laser point : 14
			// 6.2. do 2.2
			// () () ()
			// 7. do 3
			// 8.1. idx of laser point : 4, 5, 8

			String pipes = sc.next();
//			char[] pipeList = new char[pipes.length()];
//			pipeList = pipes.toCharArray();
			char[] pipeList = pipes.toCharArray();
			boolean[] booList = new boolean[pipes.length()];

			int N = pipes.length();

//			System.out.println(N);
			System.out.println(pipeList.length + " " + Arrays.toString(pipeList));
			System.out.println(booList.length + " " + Arrays.toString(booList));
			boolean[] test = laserPoint(pipeList, booList);
			System.out.println(pipeList.length + " " + Arrays.toString(test)); // 자를 위치와 인덱스
//
//			System.out.println(endPoint(pipeList, 2));

//			while (true) {
			int cnt = 0;
			for (int k = 0; k < pipes.length(); k++) {
				int start = k;
				int end = endPoint(pipeList, start); // 2, 17
				k = end;
				int len = end - start + 1; // 16
				if (len < 3) { // no
					start++;
					continue;
				} else { // do this -> cut by true
					for (int j = start; j < end; j++) {
						if (test[j]) {
							cnt++;
						}
					}
					cnt++;
					while (start < end) {
//						System.out.println("cnt : " + cnt);
//						System.out.println("start : " + start);
//						System.out.println("end : " + end);
						start++;
						end = endPoint(pipeList, start);
						len = end - start + 1;
						if (pipeList[start] == '(' && len > 2) {
							for (int j = start; j < end; j++) {
								if (test[j]) {
									cnt++;
								}
							}
							cnt++;
						} else {
							start++;
						}
						if (len < 3) {
							start++;
							cnt++;
							continue;
						}
						
					}
					
				}

			}
			System.out.println("#" + tc + " " + cnt);

			///////
//				break;
//			}

//			for (int start = 0; start < pipes.length(); start++) {
//				int end = endPoint(pipeList, start);
//				int len = end - start + 1;
//				boolean[] newPipe = new boolean[N];
//				for (int i = start; start < end + 1; start++) {
//					if (booList[i]) {
//						newPipe[i] = booList[i];
//					}
//				}
//				if (len < 3) {
//					continue;
//				}
//				start = end + 1;
//			}

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
//		int cnt = 0;
		for (int i = 0; i < lenOri - 1; i++) {
			if (arr[i] == '(' && arr[i + 1] == ')') {
				bool[i + 1] = true;
				i++;
//				cnt++;
			}
//			else cnt++;
		}
//		System.out.println(cnt);

		return bool;
	}

}
