package swea.d3_2817.sum_subsequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2817_RecursiveFt {

	public static int cnt;
	public static int sum;
	public static int[] arr;
	public static int[] barr;
	public static int K;

	// 2월 12일 | 집 가서 반드시 리뷰할 것
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_2817\\sum_subsequence\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken()); // # seq A
			K = Integer.parseInt(st.nextToken()); // Goal : sum of subseq.
			st = new StringTokenizer(sc.nextLine());
			arr = new int[N];
			barr = new int[N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 입력 잘 된다.
//			System.out.println(N);
//			System.out.println(K);
//			System.out.println(Arrays.toString(arr));

			// 무식한 방법으로 해보자 -> 실패
			// 재귀로 해보렴
			sumSubseq(0);
			System.out.println("#" + tc + " " + cnt);

		}
	}

	public static void sumSubseq(int idx) {
		if (idx == arr.length) {
			System.out.print("num List : ");
			for (int num : barr) {
				System.out.print(num + " ");
				sum += num;
			} // sum of barr
			System.out.println(" | sum : " + sum);
			if (sum == K) {
				cnt++;
				System.out.println("     cnt : " + cnt);
			} // if sum = K, then cnt++ and return
			sum = 0;
			return;
		}

		sumSubseq(idx + 1);

		barr[idx] = arr[idx];
		sumSubseq(idx + 1);

		barr[idx] = 0;

	}
}
