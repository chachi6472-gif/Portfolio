package swea.d3_2817.sum_subsequence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2817_Buffer_BitMask {
	// 2월 12일 | 집 리뷰
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d3_2817\\sum_subsequence\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			for (int i = 0; i < 1 << N; i++) {
//				String str = Integer.toBinaryString(i);
//				System.out.print(str);
				int tmp = 0;
				int jRestrict = 32 - Integer.numberOfLeadingZeros(i);
				for (int j = 0; j < jRestrict; j++) {
//					System.out.print( " | " + (i & ( 1 << j)));
					if ((i & (1 << j)) != 0) {
//					if (str.charAt(j) == '1') {
						tmp += arr[arr.length - 1 - j];
//						System.out.println(" 이거 " + Integer.parseInt(arr[str.length() - j - 1]));
					}
					if (tmp > K) 
						break;
				}
//				System.out.println(" | " + tmp);
				if (tmp == K) {
					cnt++;
				}
			}
//			System.out.println(cnt);
			sb.append(cnt).append("\n");
		} // tc for
		System.out.println(sb);
	}
}