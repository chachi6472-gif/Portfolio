package swea.d3_10726.binary_notation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_10726_forStringSol {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\swea\\d3_10726\\binary_notation\\input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			System.out.println("--------------------------------------------");
			System.out.print("#" + tc + " ");
			System.out.println();
			st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int tmp = M;
			String str = Integer.toBinaryString(tmp);
			System.out.println(str);
			for(int i = 0 ; i < N ; i++) {
				if(str.charAt(str.length()-1) == '0') {
					System.out.println("OFF");
					break;
				} else {
					// Q. 이거 너무 비효율적인 거 아닌가요? 이럴 거면 그냥
					// byte 배열이나 boolean 배열을 만드는 게 낫지 않을까요?
					// A. 비효율적인 거 맞다. 매번 인스턴스를 생성할 거다.
					// 배열을 만들어서 해도 되는데 차라리 그럴 거면
					// string이 어차피 char 배열을 담고 있으니까
					// charAt 쓰면 되지 않겠니? -> 오...
					str = Integer.toBinaryString(tmp >> i+1);
					System.out.println(str);					
				}
				if (i>=N-1) {
					System.out.println("ON");
				}
			}
		}
	}
}
