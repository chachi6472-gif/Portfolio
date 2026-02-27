package swea.d3_7087.name_title;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_7087 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_7087\\name_title\\sample_input.txt");
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boolean[] tf = new boolean[26];

			for (int i = 0; i < N; i++) {
				String word = sc.next();
				tf[word.charAt(0) - 65] = true; // A : 65
			}
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				if (tf[i]) {
					cnt++;
				} else
					break;
			}
			System.out.println("#" + tc + " " + cnt);
		} // tc for
	} // main
}


// word.charAt 은 입력한 **index** 의 단일 문자를 **byte[]** 로 보내서, **(char)(value[index] & 0xff)** 을 반환

// 기존 맨 앞자리 알파벳 따오는 코드
// char array 에 string 을 담은 후, array[0] 을 호출
//			for (int i = 0; i < N; i++) {
//				String word = sc.next();
//				char[] arr = word.toCharArray();
//				tf[arr[0] - 65] = true; // A : 65
//			}

// 변경한 맨 앞자리 알파벳 따오는 코드
// 기존 과정을 word.charAt(0) 으로 대체
//			for (int i = 0; i < N; i++) {
//				String word = sc.next();
//				tf[word.charAt(0) - 65] = true; // A : 65
//			}

// 기존 : 메모리 30,712  |  실행시간 : 121 ms
// 변경 : 메모리 28,928  |  실행시간 : 115 ms

// 		charAt 설명
// 
//		public char charAt(int index) {
//		    if (isLatin1()) {
//		        return StringLatin1.charAt(value, index);		///////////////////////////////
//		    } else {
//		        return StringUTF16.charAt(value, index);
//		    }
//		}
		
		/**
		 * Returns the character (Unicode code point) at the specified
		 * index. The index refers to {@code char} values
		 * (Unicode code units) and ranges from {@code 0} to
		 * {@link #length()}{@code  - 1}.
		 *
		 * <p> If the {@code char} value specified at the given index
		 * is in the high-surrogate range, the following index is less
		 * than the length of this {@code String}, and the
		 * {@code char} value at the following index is in the
		 * low-surrogate range, then the supplementary code point
		 * corresponding to this surrogate pair is returned. Otherwise,
		 * the {@code char} value at the given index is returned.
		 *
		 * @param      index the index to the {@code char} values
		 * @return     the code point value of the character at the
		 *             {@code index}
		 * @throws     IndexOutOfBoundsException  if the {@code index}
		 *             argument is negative or not less than the length of this
		 *             string.
		 * @since      1.5
		 */

//		///////////////////////////////////////////////////////////////////////////////////////
//		///////////////////////////////////////////////////////////////////////////////////////
//		final class StringLatin1 {
//		    public static char charAt(byte[] value, int index) {
//		        checkIndex(index, value.length);
//		        return (char)(value[index] & 0xff);
//		    }
//
//
//
//
//
//
//
//
//
//



