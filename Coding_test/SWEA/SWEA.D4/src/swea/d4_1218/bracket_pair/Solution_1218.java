package swea.d4_1218.bracket_pair;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1218 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		File input = new File("src\\swea\\d4_1218\\bracket_pair\\input.txt");
//		Scanner sc = new Scanner(input);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String inputVal = sc.next();
			char[] arr = inputVal.toCharArray();
			boolean isEff = true;
			int curr = -1; // top
			int[] stack = new int[N];
//			System.out.println(N);
			
			// 1, 2, 3, 4 : ( [ { <
			for (int i = 0; i < N; i++) {
				switch (arr[i]) {
				case '(':
						stack[++curr] = 1;
						break;
				case '[':
						stack[++curr] = 2;
						break;
				case '{':
						stack[++curr] = 3;
						break;
				case '<':
						stack[++curr] = 4;
						break;
				case ')':
					if (stack[curr] == 1) {
						stack[curr--] = 0;
						break;
					} else {
						isEff = false;
						break;
					}
				case ']':
					if (stack[curr] == 2) {
						stack[curr--] = 0;
						break;
					} else {
						isEff = false;
						break;
					}
				case '}':
					if (stack[curr] == 3) {
						stack[curr--] = 0;
						break;
					} else {
						isEff = false;
						break;
					}
				case '>':
					if (stack[curr] == 4) {
						stack[curr--] = 0;
						break;
					} else {
						isEff = false;
						break;
					}
				}
				if (!isEff) {
					break;
				}
			} // test isEff

//			System.out.println(Arrays.toString(stack));
//			System.out.println(isEff);
			
			if (isEff) {
				System.out.print("#" + tc + " ");
				System.out.println(1);
			} else {
				System.out.print("#" + tc + " ");
				System.out.println(0);
				
			}

		} // tc
	} // main
}
