package algorithm;

/**
 * 倒置单链表
 * @author Administrator
 *
 */
public class ReverseSingleList {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		traverse(n1);
		System.out.println();
		Node nnn = reverse(n1);
		traverse(nnn);
	}
	
	/**
	 * 遍历
	 * @param head
	 */
	static void traverse(Node head) {
		Node p = head;
		while (p != null) {
			System.out.println(p.n);
			p = p.next;
		}
	}
	
	/**
	 * 倒置链表
	 * @param head
	 * @return
	 */
	static Node reverse(Node head) {
		Node p = head;
		if (p == null) {
			return null;
		}
		Node q = head.next;
		if (q == null) {
			return p;
		}
		Node r = head.next.next;
		if (r == null) {
			q.next = p;
			p.next = null;
			return q;
		}
		
		while (r != null) {
			if (p == head) {
				p.next = null;
			}
			q.next = p;
			
			p = q;
			q = r;
			r = r.next;
		}
		q.next = p;
		
		return q;
	}
}

class Node {
	int n;
	Node next;
	
	public Node(int n) {
		this.n = n;
	}
}