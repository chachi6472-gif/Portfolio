package swea.d3_1208.flatten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208 {
	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(System.in);
		File inputFile = new File("src\\swea\\d3_1208\\flatten\\input.txt");
		Scanner sc = new Scanner(inputFile);

//		System.out.println(inputFile);
//		
//		while (sc.hasNextLine()) {
//		    System.out.println(sc.nextLine());
//		}
//
//		sc.close();

		// 가로의 길이는 항상 100
		// 상자의 높이는 1 이상 100 이하
		// 덤프 횟수는 1 이상 1000 이하
		// 평탄화가 완료되면 그 떄의 최고점과 최저점의 높이 차를 반환
		// 10개의 테스트 케이스 / 덤프 횟수 / 상자의 높이 값

		int T = 10;

		for (int tc = 1; tc <= 10; tc++) {
			

			int dumpNum = sc.nextInt(); // 첫 줄의 덤프 횟수 입력

			int[] arr = new int[100]; // 가로 100개짜리 배열 생성

			for (int i = 0; i < 100; i++) { // 100개 데이터 입력 idx 0 ~ 99
				arr[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int p = 0; p < dumpNum; p++) {
				int maxIdx = 0;
				int minIdx = 0;
				int maxVal = 0;
				int minVal = 1001;
				for (int i = 0; i < 100; i++) { // 최대 최소 인덱스 찾기
					if (arr[i] > maxVal) {
						maxVal = arr[i];
						maxIdx = i;
					}
					if (arr[i] < minVal) {
						minVal = arr[i];
						minIdx = i;
					}
				}
				
				if (arr[maxIdx] - arr[minIdx] <= 1) { // 평탄화 완료 됐으면 0 또는 1 출력 후 종료
					System.out.println("#" + tc + " " + cnt);
					break;
				}

//				System.out.println("최대 인덱스 : " + maxIdx);
//				System.out.println("최대값 : " + maxVal);
//				System.out.println("최소 인덱스 : " + minIdx);
//				System.out.println("최소값 : " + minVal);

				arr[maxIdx] -= 1;
				arr[minIdx] += 1;

//				System.out.println("덤프 후 최대값 : " + arr[maxIdx]);
//				System.out.println("덤프 후 최소값 : " + arr[minIdx]);
////			
//				System.out.println(Arrays.toString(arr));

				// Sort를 먼저 하고 제일 높은 곳에서 낮은 곳으로 던져도 될듯
//			for (int i = 0; i < 100; i++) {
//
//			}
				// 얘 초기화 문제였다
				maxIdx = 0;
				minIdx = 0;
				maxVal = 0;
				minVal = 1001;
				for (int i = 0; i < 100; i++) { // 최대 최소 인덱스 다시 찾기
					if (arr[i] > maxVal) {
						maxVal = arr[i];
						maxIdx = i;
					}
					if (arr[i] < minVal) {
						minVal = arr[i];
						minIdx = i;
					}
				}
				
				// 얘네는 죄가 없음
				cnt = arr[maxIdx] - arr[minIdx];
//				cnt = maxVal - minVal;
//				System.out.println("최대 인덱스 : " + maxIdx);
//				System.out.println("최대값 : " + maxVal);
//				System.out.println("최소 인덱스 : " + minIdx);
//				System.out.println("최소값 : " + minVal);
//				System.out.println((p+1) + "번째 ----------------------------------");
				
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}

	}
}
