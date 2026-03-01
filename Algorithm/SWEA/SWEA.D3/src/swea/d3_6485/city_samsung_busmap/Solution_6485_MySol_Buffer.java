package swea.d3_6485.city_samsung_busmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485_MySol_Buffer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] busstop = new int[5001];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				for (int j = A; j <= B; j++) {
					busstop[j]++;
				}
			}
			int P = Integer.parseInt(br.readLine());
			sb.append("#").append(tc);
			for(int i = 1 ; i <= P ; i++) {
				int k = Integer.parseInt(br.readLine());
				sb.append(" ").append(busstop[k]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}