package swea.d2_1859.millionaire_project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_SearchFromFront {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d2_1859\\millionaire_project\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			// output : res
			long res = 0; // range of N : [ 2 , 10^6 ] and range of Val : [ 1 , 10^4 ] -> Type long needed
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			// input N and elements
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arr)); // input OK

			// logic : if there exists an greatest value on the range of post,
			// then add diff on 'res'.
			// This way is too heavy to compute
			int maxIdx = 0;
			int maxVal = arr[0];
			for (int i = 0; i < N; i++) {
				
				// add this method for less compute
				// -> if there exists greatest after this element, then just add diff and skip searching
				if (maxIdx > i && maxVal > arr[i]) {
					res += maxVal - arr[i];
					continue;
				} else {
					maxIdx = i;
					maxVal = arr[i];
					for (int j = i+1; j < N; j++) {
						if (arr[j] >= maxVal) {
							maxVal = arr[j];
							maxIdx = j;
						}
					}
				}
				if (arr[i] < maxVal) {
					res += maxVal - arr[i];
				}
				
//				System.out.println(maxIdx);
//				System.out.println(maxVal);
//				System.out.println(res);
			} // for : current element of array
			sb.append(res);
			System.out.println(sb);
//			System.out.println("---------------------------------------");

		} // tc for
//		System.out.print(sb);

	}
}