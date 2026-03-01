package swea.d4_1222.calculator1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1222_2 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d4_1222\\calculator1\\input.txt");
		Scanner sc = new Scanner(input);

		Map<String, Integer> info = new HashMap<>();
//		StringBuilder postfix = new StringBuilder();
//		Stack oper = new Stack();
		info.put("(", 0);
		info.put("+", 1);
		info.put("-", 1);
		info.put("*", 2);
		info.put("/", 2);

		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String mono = sc.next();
			StringBuilder postfix = new StringBuilder();
			Stack<Character> oper = new Stack<>();
			char[] arr = mono.toCharArray();

			for (int i = 0; i < len; i++) {
				char tmp = mono.charAt(i);
				if (arr[i] >= 0 && arr[i] <= 9) {
					postfix.append(arr[i]);
				} else if (arr[i] == '(') {
					oper.push(arr[i]);
				} else if (arr[i] == ')') {
					while (oper.peek() != '(') { // Q. 왜 oper : empty 체크 x?
						postfix.append(oper.pop());
					}
					oper.pop();
				} else {
					if (oper.isEmpty()) {
						oper.push(arr[i]);
					} else {
						while (!oper.isEmpty() && (info.get(oper.peek()) >= info.get(arr[i]))) {
							postfix.append(oper.pop());
						}
						oper.push(arr[i]);
					}
				}
			} // calc for
			while (!oper.isEmpty()) {
				postfix.append(oper.pop());
			}
			
			System.out.println(postfix);
			
		}

	}
}
