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
		
		
		// �Ʒ��� �߸��� ���ٹ�
		// before�� ���� ��带 ����Ű��, cur�� ���� ����� ���� ��带 �����Ѿ� ��
		// �Ʒ� �ڵ�� before�� cur ��ġ�� ���� ��(��� ���� ��) �� ������ ������Ű�� ����
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
