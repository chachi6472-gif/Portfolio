package swea.d3_10726.binary_notation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10726_Buffer {
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

			String str = Integer.toBinaryString(M);
			String str2 = Integer.toBinaryString(1 << N);
			System.out.println("--------" + tc + "----------");
			System.out.println(str);
			System.out.println(str2);
			if (str.length() < N) {
				sb.append("OFF").append("\n");
				continue;
			}
			for(int i = str.length()-1; i >= 0 ; i--) {
				if(str.charAt(i) == '0') {
					sb.append("OFF").append("\n");
					break;
				}
				if (i == str.length()-N) {
					sb.append("ON").append("\n");
					break;
				}
			}
		} // tc for
		System.out.println(sb);
	}
}
// 30 -> 11110
// 4 -> max : 1111 | min : 0000 -> 16 cases