package swea.d2_1940.rccar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1940 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d2_1940\\rccar\\input.txt");
		Scanner sc = new Scanner(input);

		int T = sc.nextInt();
		for (int tc = 1; tc <= 10; tc++) {
			int trial = sc.nextInt();

			int dist = 0; // 초기 위치 : 0
			int vel = 0; // 초기 속도 : 0

			for (int i = 0; i < trial; i++) {
				int frontRear = sc.nextInt();
				int acc = 0;
				if (frontRear != 0) {
					acc = sc.nextInt(); // 0일 때 하나만 읽으려고 넣음
				} else {
					dist += vel;
					continue;
				}
				if (frontRear == 1) {
					vel += acc;
				} else if (frontRear == 2 && vel - acc > 0) { // if if 랑 if elif 랑 답이 다르다
					vel -= acc;
				} else {
					vel = 0;
					continue;
				}
				dist += vel;
			}
			System.out.println("#" + tc + " " + dist);
		}
	}
}
