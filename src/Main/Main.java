package Main;

import LinkedList.MyLinkedList;
import LinkedList.Node;

public class Main {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();
		
		list.add(new Node(5));
		list.add(new Node(10));
		list.add(new Node(15));
		list.add(new Node(20));
		list.printAll();
		
		System.out.println("--------------");
		
		list.remove(1);
		
		list.printAll();
		
	}

}
