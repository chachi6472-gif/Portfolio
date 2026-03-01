package swea.d3_10726.binary_notation;

public class test {
	public static void main(String[] args) {
		int M = 8388607;
		String str = Integer.toBinaryString(M << 0);
		String str1 = Integer.toBinaryString(M << 1);
		String str2 = Integer.toBinaryString(M << 2);
		String str3 = Integer.toBinaryString(M << 3);

		System.out.println(Integer.toBinaryString(M));
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println();

		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(1 << 0));
		System.out.println(Integer.toBinaryString(1 << 1));
		System.out.println(Integer.toBinaryString(1 << 2));
		System.out.println(Integer.toBinaryString(1 << 3));
		System.out.println(Integer.toBinaryString((1 << 4) - 1));
		System.out.println();

		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toBinaryString(15 >> 1));
		System.out.println(Integer.toBinaryString(15 >> 2));
		System.out.println(Integer.toBinaryString(15 >> 3));
		System.out.println(Integer.toBinaryString(15 >> 4));
		System.out.println(Integer.toBinaryString(15 >> 5));

		System.out.println("-----------------------------");

		System.out.println(Integer.toBinaryString(M).length());
		for (int i = 0; i < 24; i++) {

			if ((M & 1 << i) == 0) {
				System.out.print(i);
				System.out.println(" : 오프링");
			} else {
				System.out.print(i);
				System.out.println("는 괜찮아~");
			}
		}
	}
}
