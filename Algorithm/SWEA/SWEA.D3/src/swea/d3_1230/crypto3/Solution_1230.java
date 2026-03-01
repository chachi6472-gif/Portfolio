package swea.d3_1230.crypto3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1230 {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner sc = new Scanner(System.in);
		File input = new File("src\\swea\\d3_1230\\crypto3\\input.txt");
		Scanner sc = new Scanner(input);

		for (int tc = 1; tc <= 10; tc++) {
			int oriLen = sc.nextInt();
			SinglyLinkedList list = new SinglyLinkedList();
			for (int i = 0; i < oriLen; i++) {
				list.add(i, sc.nextInt());
			} // crypto input end

			int numOrd = sc.nextInt();
			for (int i = 0; i < numOrd; i++) {
				String tmp = sc.next();
				int x = sc.nextInt();

				switch(tmp) {
				case "I" :
					int y1 = sc.nextInt();
					for (int j = 0; j < y1; j++) {
						list.add(x + j, sc.nextInt());
					}
					break;
				case "D" :
					int y2 = sc.nextInt();
					for(int j = 0 ; j < y2 ; j++) {
//						list.remove(x); // 아마 이거일 건데 제출 결과는 맞다고 나옴
						list.remove(x+1);
					}
					break;
				case "A" :
					for(int j = 0 ; j < x ; j++) {
						list.addLast(sc.nextInt());
					}
					break;
				}

			} // order input end

			System.out.print("#" + tc + " ");
			list.printList();
			System.out.println();

		} // tc for

	} // main

} // class

class Node {
	int data;
	Node link;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

}

class SinglyLinkedList {
	Node head;
	int size;

	public void addFirst(int data) {
		Node node = new Node(data);

		node.link = head;

		head = node;
		size++;

	}

	public void addLast(int data) {
		if (size == 0) {
			addFirst(data);
		}

		Node node = new Node(data);

		Node curr = head;

		while (curr.link != null) {
			curr = curr.link;
		}

		curr.link = node;
		size++;
	}

	public void add(int idx, int data) {
		if (idx <= 0) {
			addFirst(data);
		} else if (idx >= size) {
			addLast(data);
		} else {
			Node pre = get(idx - 1);

			Node node = new Node(data);

			node.link = pre.link;
			pre.link = node;

			size++;

		}

	}

	public Node get(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		}

		Node curr = head;

		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}

	public int removeFirst() {
		if (head == null) {
			return -1;
		}

		int data = head.data;
		head = head.link;
		size--;
		return data;
	}

	public int remove(int idx) {
		if (idx == 0) {
			return removeFirst();
		}
		if (idx < 0 || idx >= size) {
			return -1;
		}

		Node pre = get(idx - 1);
		Node curr = pre.link;

		int data = curr.data;

		pre.link = curr.link;

		size--;

		return data;
	}

	public void printList() {
		Node curr = head;
		if (head == null) {
			return;
		}
		int cnt = 0;
		while (curr != null && cnt < 10) {
//		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.link;
			cnt++;
		}

	}

}