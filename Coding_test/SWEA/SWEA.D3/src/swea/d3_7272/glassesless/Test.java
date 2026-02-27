package swea.d3_7272.glassesless;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {

	public static Character[] hole = { 'A', 'D', 'O', 'P', 'Q', 'R' }; // Character[] : wrapping
	public static Set<Character> hole_set = new HashSet<>(Arrays.asList(hole));
//	public static Set<Character> hole_set = new HashSet<>(); // (1) 위에 있는 애의 역할은 (2)를 한번에 시켜준다.

//	public static char[] hole2 = { 'A', 'D', 'O', 'P', 'Q', 'R' };
//	public static List<char> hole2_arrL = new Array<>(); // 기본형은 못 들어간다.
	
	public static void main(String[] args) throws FileNotFoundException {
//		(2) Arrays.asList(hole) 을 쪼개보면 다음과 같다.
//		구글링 : Java 컬렉션 프레임워크
//		hole_set.add('A');
//		hole_set.add('D');
//		hole_set.add('O');
//		hole_set.add('P');
//		hole_set.add('Q');
//		hole_set.add('R');
		
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7272\\glassesless\\s_input.txt");
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String A = sc.next();
			String B = sc.next();
			String res = "SAME";

			if (!(A.length() == B.length())) {
				res = "DIFF";
			} else {
				for (int i = 0; i < A.length(); i++) {
					char c1 = A.charAt(i);
					char c2 = B.charAt(i);

					if (getGroup(c1) != getGroup(c2)) {
						res = "DIFF";
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getGroup(char c) {
		if (c == 'B')
			return 2;
		if (hole_set.contains(c))
			return 1;
		return 0;
	}
}