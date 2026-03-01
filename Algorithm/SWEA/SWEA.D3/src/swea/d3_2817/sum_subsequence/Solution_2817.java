package swea.d3_2817.sum_subsequence;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2817 {
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
			System.out.println(Arrays.toString(arr));

			int cnt = 0;
			int tmp = 0;
			int prev = 0;

			// bit가 하나씩만 바뀌게 하는 gray code
			for (int i = 0; i < (1 << N); i++) {
				// i = 6 일 때 예시) gray = 110 ^ 11 = 101
				// prev(gray i-1) : 111 -> changedBit = 101 ^ 111 = 10 = 2 -> 2^1 자리가 바뀜
				int gray = i ^ (i >> 1);
				int changedBit = gray ^ prev;
				// bit : changedBit가 몇 번 자리인지 반환 -> 2(10) 반환 | 4이면 100 의 1 자리 비트가 바뀌었다는 뜻
				int bit = Integer.numberOfTrailingZeros(changedBit);

				// 아래는 구현 시각화
				System.out.println(
						" | i(bit) : " + Integer.toBinaryString(i) + " | i>>1 : " + Integer.toBinaryString(i >> 1)
								+ " | gray(bit) : " + Integer.toBinaryString(gray) + " | prev(bit) : "
								+ Integer.toBinaryString(prev) + " | changedBit : " + changedBit + " | bit : " + bit);

				// 초기값은 bit = 32로 나오니까 털어주기. 어차피 0은 의미 없다.
				if (i == 0) {
					continue;
				}
				// gray와 prev를 비교했을 때, changedBit 의 위치에서 bit 0 -> 1 이면 tmp+ | 1 -> 0 이면 tmp-
				if ((gray & changedBit) != 0) {
					tmp += arr[bit];
				} else {
					tmp -= arr[bit];
				}

				// 아래는 이번 단계에서 진행된 부분집합의 합
				System.out.println(" | tmp : " + tmp);

				// 만약 부분집합의 합이 찾는 값과 동일하다면 cnt++
				if (tmp == K) {
					cnt++;
				}

				// 이전 단계를 현 단계로 초기화하고 다음 단계로 넘어감
				prev = gray;
			}
			sb.append(cnt).append("\n");
		} // tc for
		System.out.println(sb);
	}
}