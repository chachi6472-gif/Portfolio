package swea.d4_1231.inorder_traversal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1231 {

	private static char[] arr;
	private static int N;
	private static int[][] tree;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d4_1231\\inorder_traversal\\input.txt"));
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d4_1231\\inorder_traversal\\input.txt");
//		Scanner sc = new Scanner(input);
		int T = 10;
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
//			System.out.println(N);
			tree = new int[N + 1][3];
			arr = new char[N + 1];
			sc.nextLine();
			for (int i = 1; i < N + 1; i++) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				int p = Integer.parseInt(st.nextToken());
				arr[i] = st.nextToken().charAt(0);
				int cnt = 0;
				while (st.hasMoreTokens()) {
					tree[p][cnt++] = Integer.parseInt(st.nextToken());
				}
				tree[p][2] = i;
//				System.out.println(tree[i][0]);
//				System.out.println(tree[i][1]);
//				System.out.println(tree[i][2]);
//				System.out.println();
			}
			System.out.print("#" + tc + " ");
			inOrder(1);
//			System.out.println(arr[tree[8][2]]);
			System.out.println();

		} // tc for
	} // main

	public static void inOrder(int idx) {
//		System.out.println(idx + " : 1");
		// 아래에서 다 걸러지나본데잉
		if (idx > N || tree[idx][2] == 0) {
			return;
		}
		inOrder(idx * 2);
		System.out.print(arr[tree[idx][2]]);
		inOrder(idx * 2 + 1);
		
		// 조건문 새로 짜보기 -> N 초기화 문제였다
//		if (idx <= N) {
////		System.out.println("2");
//			inOrder(idx * 2);
//			System.out.print(arr[tree[idx][2]]);
////			System.out.println(idx + " : 2");
//			inOrder(idx * 2 + 1);
//		}

	} // method inOrder

}
