package swea.d4_1232.arithmetic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1233_0211_1734 {

	private static String[] arr;
	private static int N;
	private static int[][] tree;
	private static int A;
	private static int B;
	private static char curr;
	private static int compute;

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src\\swea\\d4_1232\\arithmetic\\input.txt"));
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d4_1231\\inorder_traversal\\input.txt");
//		Scanner sc = new Scanner(input);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			compute = 0;
			A = 0;
			B = 0;
			N = sc.nextInt();
//			System.out.println(N);
			tree = new int[N + 1][3];
			arr = new String[N + 1];
			sc.nextLine();
			for (int i = 1; i < N + 1; i++) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				int p = Integer.parseInt(st.nextToken());
				if (!st.hasMoreElements()) {
					continue;
				}
				String tmp = st.nextToken();
				int cnt = 0;
				if (tmp.contains("+") || tmp.contains("-") || tmp.contains("/") || tmp.contains("*")) {
//					System.out.println(tmp);
					arr[i] = tmp;
					tree[p][2] = i;
					while (st.hasMoreTokens()) {
						tree[p][cnt++] = Integer.parseInt(st.nextToken());
					}
				} else {
//					int l = Integer.parseInt(tmp);
					arr[p] = tmp;
					tree[p][2] = Integer.parseInt(tmp);
//					tree[p][0] = l;
//					if(st.hasMoreElements()) {
//						int r = Integer.parseInt(st.nextToken());
//					}
				}
//				while (st.hasMoreTokens()) {
//					tree[p][cnt++] = Integer.parseInt(st.nextToken());
//				}
//				tree[p][2] = i;
			}
			System.out.print("#" + tc + " ");
//			System.out.println();
//			System.out.println(Arrays.toString(arr));
			inOrder(1);
			System.out.println(arr[1]);

		} // tc for
	} // main

	public static void inOrder(int idx) {
		if (idx > N || tree[idx][2] == 0) {
			return;
		}
		inOrder(idx * 2);
		inOrder(idx * 2 + 1);
//		System.out.print("idx : " + idx + " | ");
//		System.out.print("arr[idx] : " + arr[idx]);
		if (arr[idx].contains("+") || arr[idx].contains("-") || arr[idx].contains("*") || arr[idx].contains("/")) {
			curr = arr[idx].charAt(0);
			switch (curr) {
			case '+':
				compute = Integer.parseInt(arr[tree[idx][0]]) + Integer.parseInt(arr[tree[idx][1]]);
				arr[idx] = compute + "";
				compute = 0;
				break;

			case '-':
				compute = Integer.parseInt(arr[tree[idx][0]]) - Integer.parseInt(arr[tree[idx][1]]);
				arr[idx] = compute + "";
				compute = 0;
				break;

			case '*':
				compute = Integer.parseInt(arr[tree[idx][0]]) * Integer.parseInt(arr[tree[idx][1]]);
				arr[idx] = compute + "";
				compute = 0;
				break;

			case '/':
				compute = Integer.parseInt(arr[tree[idx][0]]) / Integer.parseInt(arr[tree[idx][1]]);
				arr[idx] = compute + "";
				compute = 0;
				break;
			}
		}
//		else {
//			if (idx % 2 == 0) {
//				A = Integer.parseInt(arr[idx]);
//			} else {
//				B = Integer.parseInt(arr[idx]);
//			}
//		}

//		System.out.println(" | arr[idx] : " + arr[idx]);
//		System.out.println();

	} // method inOrder

}