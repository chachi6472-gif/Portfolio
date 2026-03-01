package swea.d5_1248.common_descent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1248 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d5_1248\\common_descent\\input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
//		System.out.println(T);
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.nextLine();
			StringTokenizer st1 = new StringTokenizer(str);
			int V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st1.nextToken());
			int B = Integer.parseInt(st1.nextToken());

			int[][] tree = new int[V + 1][3];
//			int[] arr = new int[V + 1];

			StringTokenizer st = new StringTokenizer(sc.nextLine());

//			System.out.println(V);
//			System.out.println(E);
//			System.out.println(A);
//			System.out.println(B);
//			System.out.println(st.nextToken());
//			System.out.println();

			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int ch = Integer.parseInt(st.nextToken());
				if (tree[p][0] == 0) {
					tree[p][0] = ch;
				} else {
					tree[p][1] = ch;
				}
				tree[ch][2] = p;
//				System.out.println(tree[ch][2]);
			} // 값은 잘 받았다

			// 숫자가 크면 가장 가까운 공통조상이다 -> 10번 케이스에서 거름 당했다
			// 숫자가 크다고 꼭 가장 가까운 공통조상은 아니다.
			// 실제 10번 케이스 output : 7165 2453
			// 내 10번 케이스 output : 8666 4599 -> 더 상위의 노드를 잡았겠구나~
			// 10번 케이스 공통 조상 : 8666 7735 7165 5596 5081 4128 4011
			boolean[] desA = new boolean[V + 1];
			boolean[] desB = new boolean[V + 1];

			desA[A] = true;
			desB[B] = true;
			int tmp1 = A;
			int tmp2 = B;
			// 얘를 고쳐야 한다
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
//			System.out.println(Arrays.toString(decA));
//			System.out.println(Arrays.toString(decB));

			int tmp3 = V;
//			 얘는 10번 반영 전
			while (!desA[tmp3] || !desB[tmp3]) {
				tmp3--;
			}
			int sol1 = tmp3;
//			System.out.println(tmp3);
//			int sol1 = tmp3;
//			System.out.println(desA[tmp3]);
//			System.out.println(desB[tmp3]);

			// 제일 작게 나오는 게 가장 가까운 조상 아니겠니?
			// 8666 4599
			// 7735 4568
			// 7165 2435
			// 5596 5060
			// 5081 3685
			// 4128 9013
			// 4011 9420
			// 1 10000
			// 그럴싸하다!
			// 그럼 그냥 공통조상 리스트를 다 세버리는 건 어때?
			// 당장 해보자!
			int cnt = 0;
			int k = 0;
			while (k <= V) {
				if (desA[k] && desB[k]) {
					cnt++;
				}
				k++;
			}
//			System.out.println(cnt); // 1 포함 공통조상 개수
			int[] common = new int[cnt];
			cnt--; // 밑에서 인덱스 벗어나니까 미리 빼두자

			// 얘는 10번 반영 후
			while (tmp3 >= 1) {
				if (!desA[tmp3] || !desB[tmp3]) {
				} else {
					// 공통조상 리스트를 쭉 뽑아보자!
//					System.out.println(tmp3);
					// 공통조상 리스트에 저장하자
					common[cnt--] = tmp3;
				}
				tmp3--;
			}
//			System.out.println(Arrays.toString(common));

//			System.out.println(tmp3); // 공통 조상
//			System.out.println(desA[tmp3]);
//			System.out.println(desB[tmp3]);

			int minSize = V + 10;
//			System.out.println("--------------------------------------------------------------------");
//			System.out.println(Arrays.toString(desC));
//			System.out.println();

//			sol1 = tmp3 = 1;
			for (int t : common) {
				int size = 0; // sol2
				boolean[] desC = new boolean[V + 1];
				tmp3 = t;
				
				while (!desC[t]) {
//				System.out.println("idx : " + tmp3 + " | 좌 : " + tree[tmp3][0] + " | 우 : " + tree[tmp3][1] + " | 부모 : " + tree[tmp3][2]);
					if (!(tree[tmp3][0] == 0) && !desC[tree[tmp3][0]]) {
						tmp3 = tree[tmp3][0];
					} else if (!(tree[tmp3][1] == 0) && !desC[tree[tmp3][1]]) {
						tmp3 = tree[tmp3][1];
					} else if (!desC[tmp3]) {
						desC[tmp3] = true;
						size++;
						tmp3 = tree[tmp3][2];
//					System.out.println(Arrays.toString(desC));
					} else {
						break;
					}
				}

				if (minSize > size) {
					minSize = size;
					sol1 = t;
				}
			} // 된다!
//			System.out.println(size);
			System.out.println("#" + tc + " " + sol1 + " " + minSize);

		} // tc for

	} // main
}
