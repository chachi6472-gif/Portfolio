package swea.d3_10726.binary_notation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10726_Buffer_BitMasking {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d3_10726\\binary_notation\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean isTrue = true;
			for (int i = 0; i < N; i++) {
				if ((M & 1 << i) == 0) {
					sb.append("OFF").append("\n");
					isTrue = false;
					break;
				}
			}
			if (isTrue)
				sb.append("ON").append("\n");
		} // tc for
		System.out.println(sb);
	}
}
// 30 -> 11110
// 4 -> max : 1111 | min : 0000 -> 16 cases