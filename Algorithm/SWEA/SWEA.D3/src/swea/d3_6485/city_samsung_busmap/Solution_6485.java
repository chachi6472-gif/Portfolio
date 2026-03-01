package swea.d3_6485.city_samsung_busmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			int[] cnt = new int[P];
			int[] ans = new int[P];
			for (int i = 0; i < P; i++) {
				cnt[i] = Integer.parseInt(br.readLine());
				for (int j = 0; j < N; j++) {
					if (A[j] <= cnt[i] && B[j] >= cnt[i]) {
						ans[i]++;
					}
				}
			}
			sb.append("#").append(tc);
			for (int i = 0; i < P; i++) {
				sb.append(" ").append(ans[i]);
			}
			System.out.println(sb);
		}
	}
}