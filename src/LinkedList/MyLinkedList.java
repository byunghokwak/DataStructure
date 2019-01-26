package LinkedList;

public class MyLinkedList {
	
	Node head;
	Node before, cur;
	int size;
	
	public MyLinkedList() {
		this.head = new Node();
		this.head.next = null;
		
		this.size = 0;
	}
	
	public void add(Node node) {
		
		Node newNode = node;
		
		newNode.next = head.next;
		head.next = newNode;
		
		size++;
	}

		
	public void remove(Node node) {
		
	}
	
	public void remove(int idx) {
		
		int nowIdx = 0;
		Node nowNode = LFirst();
		
		if(nowNode == null || idx>=size) return;
		
		while(nowIdx != idx && nowIdx<size) {
			nowNode = LNext();
			nowIdx++;
		}
		
		before.next = cur.next;
		cur = before;
	}
	
	private Node LFirst() {
		
		if(head.next == null) return null;
		
		before = head;
		cur = before.next;
		
		return cur;
	}
	
	private Node LNext() {
		if(cur.next == null) return null;
		
		
		// 아래는 잘못된 접근법
		// before가 현재 노드를 가르키고, cur가 현재 노드의 다음 노드를 가르켜야 함
		// 아래 코드는 before와 cur 위치가 같을 때(노드 삭제 후) 위 조건을 만족시키지 못함
		/*
		cur = cur.next;
		before = before.next;
		*/
		
		before = cur;
		cur = cur.next;
		
		return cur;
	}
	
	public void printAll() {
		Node nowNode = LFirst();
		if(nowNode != null) {
			while(nowNode != null) {
				System.out.println(nowNode.getId());
				nowNode = LNext();
			}
		}
	}
	
}
