package swea.d4_1224.calculator3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1224 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d4_1224\\calculator3\\input.txt");
		Scanner sc = new Scanner(input);
		Map<Character, Integer> info = new HashMap<>();
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
			for (int i = 0; i < mono.length(); i++) {
				char tmp = mono.charAt(i);
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
						while (!oper.isEmpty() && info.get(oper.peek()) >= info.get(tmp)) {
							postfix.append(oper.pop());
						}
						oper.push(tmp);
					}
				}
			} // calc for
			while (!oper.isEmpty()) {
				postfix.append(oper.pop());
			}
//			System.out.println(postfix);
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
					case '*':
						res.push(A*B);
					}
				}
			}
//			System.out.println("#" + tc + " " + res.peek());
			System.out.println("#" + tc + " " + res.pop());
			System.out.println("#" + tc + " " + res.isEmpty());
		}
	}
}
