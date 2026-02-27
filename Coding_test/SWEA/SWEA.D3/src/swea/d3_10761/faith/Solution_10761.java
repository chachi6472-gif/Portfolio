package swea.d3_10761.faith;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10761 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\d3_10761\\faith\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arrO = new int[N];
			int[] arrB = new int[N];
			boolean[] arrIdx = new boolean[N]; // missed condition -> there is an order on pushing switch
			int idxO = 0;
			int idxB = 0;
			for (int i = 0; i < N; i++) {
				String str = st.nextToken();
				int tmp = Integer.parseInt(st.nextToken());
//				System.out.println(str);
//				System.out.println(tmp);
				if (str.contains("O")) {
//				if (str.charAt(0) == 'O') {
					arrO[idxO++] = tmp;
					arrIdx[i] = true;
				} else
					arrB[idxB++] = tmp;
			}

			// check input
//			System.out.println(Arrays.toString(arrO) + " 오렌지");
//			System.out.println(Arrays.toString(arrB) + " 블루");

			idxO = 0;
			idxB = 0;
			int Ord = 0;
			int whereO = 1;
			int whereB = 1;
			int time = 0;
			boolean canIpush = true;
			while (true) {

				canIpush = true;

				// move Orange
				if (idxO >= N || arrO[idxO] == 0) {
					// skip
				} else if (whereO < arrO[idxO]) {
					whereO++;
				} else if (whereO > arrO[idxO]) {
					whereO--;
				} else if (arrIdx[Ord] && canIpush) {
					idxO++;
					Ord++;
					canIpush = false;
				}
				// move Blue
				if (idxB > N || arrB[idxB] == 0) {
					// skip
				} else if (whereB < arrB[idxB]) {
					whereB++;
				} else if (whereB > arrB[idxB]) {
					whereB--;
				} else if (!arrIdx[Ord] && canIpush) {
					idxB++;
					Ord++;
				}

				time++;

				// check current
//				System.out.println("현재 시간 : " + time);
//				System.out.println("현재 오렌지 인덱스 : " + idxO);
//				System.out.println("현재 오렌지 위치 : " + whereO);
//				System.out.println("현재 블루 인덱스 : " + idxB);
//				System.out.println("현재 블루 위치 : " + whereB);

				// exit while when idx reaches N ( case : all of the input is for O or B ) or
				// both arrays have element zero
				if (idxO == N || idxB == N || (arrO[idxO] == 0 && arrB[idxB] == 0)) {
					break;
				}

			} // while

			sb.append(time).append("\n");
		} // tc for
		System.out.println(sb);
	}
}
