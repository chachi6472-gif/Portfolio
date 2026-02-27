package swea.d2_1859.millionaire_project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d2_1859\\millionaire_project\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			// output : res
			long res = 0; // range of N : [ 2 , 10^6 ] and range of Val : [ 1 , 10^4 ] -> Type long needed
			sb.append("#").append(tc).append(" ");

			// input N and elements
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// logic : Assume that current element is greater one. If not, then change that.
			int maxVal = arr[N - 1];
			for (int i = N - 1; i >= 0; i--) {

				if (arr[i] < maxVal) {
					res += maxVal - arr[i];
				} else {
					maxVal = arr[i];
				}

			} // for : current element of array
			sb.append(res).append("\n");

		} // tc for
		System.out.println(sb);

	}
}