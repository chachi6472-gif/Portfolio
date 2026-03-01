package swea.d5_1248.common_descent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1248_Buffer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st1.nextToken());
			int B = Integer.parseInt(st1.nextToken());
			int[][] tree = new int[V + 1][3];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int ch = Integer.parseInt(st.nextToken());
				if (tree[p][0] == 0) {
					tree[p][0] = ch;
				} else {
					tree[p][1] = ch;
				}
				tree[ch][2] = p;
			} // 값은 잘 받았다

			boolean[] desA = new boolean[V + 1];
			boolean[] desB = new boolean[V + 1];

			int tmp1 = A;
			int tmp2 = B;
			// 얘를 고쳐야 한다 -> 둘을 동시에 바꿔두는 것보다 하나를 기준으로 바꿔두고, 나머지 인덱스가 조상 타고 올라갈 때 true 만나면 공통이 효율적
			while (!desA[1] || !desB[1]) {
				if (!(tree[tmp1][2] == 0)) {
					desA[tree[tmp1][2]] = true;
				}
				if (!(tree[tmp2][2] == 0)) {
					desB[tree[tmp2][2]] = true;
				}
				tmp1 = tree[tmp1][2];
				tmp2 = tree[tmp2][2];
			}

			int cnt = 0;
			int k = 0;
			while (k <= V) {
				if (desA[k] && desB[k]) {
					cnt++;
				}
				k++;
			} // 1 포함 공통 조상 개수 : cnt

			int tmp3 = V;
			int[] common = new int[cnt];
			while (tmp3 >= 1) {
				if (!desA[tmp3] || !desB[tmp3]) {
				} else {
					common[--cnt] = tmp3; // 만들 때 배열의 크기보다 1을 우선 빼줘서 뒤쪽부터 넣자
				}
				tmp3--;
			} // tmp를 줄여가며 공통조상 리스트 common에 공통 조상을 저장

			int sol1 = 0; // 가장 가까운 공통 조상
			int minSize = V + 10; // 서브트리 크기를 저장할 변수

			for (int t : common) { // common 배열에서 하나씩 뽑아와서 size를 재보자 -> 어차피 불리언이라 금방 잴 것 같다.
				int size = 0; // minSize와 비교
				boolean[] desC = new boolean[V + 1]; // 0번 인덱스는 버려두고 시작
				tmp3 = t; // 앞에서 써먹었던 임시 변수 재활용

				while (!desC[t]) {
					if (!(tree[tmp3][0] == 0) && !desC[tree[tmp3][0]]) {
						tmp3 = tree[tmp3][0];
					} else if (!(tree[tmp3][1] == 0) && !desC[tree[tmp3][1]]) {
						tmp3 = tree[tmp3][1];
					} else if (!desC[tmp3]) {
						desC[tmp3] = true;
						size++;
						tmp3 = tree[tmp3][2];
					} else {
						break;
					}
				} // size 재는 while 문

				if (minSize > size) {
					minSize = size;
					sol1 = t;
				} // size가 minSize보다 작으면 '가장 가까운 조상'과 '서브 트리의 크기' 갱신
			} // 된다!
			sb.append(sol1).append(" ").append(minSize).append("\n");
		} // tc for
		System.out.print(sb);
	} // main
}