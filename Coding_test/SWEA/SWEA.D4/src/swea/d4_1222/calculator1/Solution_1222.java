package swea.d4_1222.calculator1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1222 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d4_1222\\calculator1\\input.txt");
		Scanner sc = new Scanner(input);

		Map<Character, Integer> info = new HashMap<>();
//		StringBuilder postfix = new StringBuilder();
//		Stack oper = new Stack();
		info.put('(', 0);
		info.put('+', 1);
		info.put('-', 1);
		info.put('*', 2);
		info.put('/', 2);

		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String mono = sc.next();
			StringBuilder postfix = new StringBuilder();
			Stack<Character> oper = new Stack<>();
//			char[] arr = mono.toCharArray();
//			char[] arr = new char[len+2];
//			arr[0] = '(';
//			arr[len+1] = ')';

			// Cannot invoke "java.lang.Integer.intValue()" because the return value of
			// "java.util.Map.get(Object)" is null
			// •NullPointerException - if the specified key is null and this mapdoes not
			// permit null keys(optional)
			for (int i = 0; i < mono.length(); i++) {
				char tmp = mono.charAt(i);
				//////////////////////////////////////////////////////////////////////////////////
				/// 문제 지점 '0', '9'가 0, 9로 들어가고 있었음
				if (tmp >= '0' && tmp <= '9') {
					postfix.append(tmp);
				} else if (tmp == '(') {
					oper.push(tmp);
				} else if (tmp == ')') {
					while (oper.peek() != '(') { // Q. 왜 oper : empty 체크 x?
						postfix.append(oper.pop());
					}
					oper.pop();
				} else {
					if (oper.isEmpty()) {
						oper.push(tmp);
					} else {
//						System.out.println(oper.peek());
//						System.out.println(tmp);
//						while (!oper.isEmpty()) {
						while (!oper.isEmpty() && info.get(oper.peek()) >= info.get(tmp)) {

							// Issue : info.get(oper.peek()) >= info.get(tmp)
							postfix.append(oper.pop());
						}
						oper.push(tmp);
					}
				}
			} // calc for
				// •NullPointerException - if the specified key is null and this mapdoes not
				// permit null keys(optional)
//			for (int i = 0; i < len; i++) {
//				if (arr[i] >= '0' && arr[i] <= '9') {
//					postfix.append(arr[i]);
//				} else if (arr[i] == '(') {
//					oper.push(arr[i]);
//				} else if (arr[i] == ')') {
//					while (oper.peek() != '(') { // Q. 왜 oper : empty 체크 x?
//						postfix.append(oper.pop());
//					}
//					oper.pop();
//				} else {
//					if (oper.isEmpty()) {
//						oper.push(arr[i]);
//					} else {
//						while (!oper.isEmpty() && info.get(oper.peek()) >= info.get(arr[i])) {
//							postfix.append(oper.pop());
//						}
//						oper.push(arr[i]);
//					}
//				}
//			} // calc for
			while (!oper.isEmpty()) {
				postfix.append(oper.pop());
			}

			System.out.println(postfix);

			Stack<Integer> res = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char tmp = postfix.charAt(i);
				if (tmp >= '0' && tmp <= '9') {
					res.push(postfix.charAt(i) - 48);
				} else if (!res.isEmpty()) {

					int B = res.pop();
					int A = res.pop();
					switch (tmp) {
					case '+':
						res.push(A + B);
						break;
					}
				}
			}
			System.out.println(res.peek());

		}

	}
}
