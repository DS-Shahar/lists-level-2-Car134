package shesh;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static Node<Integer> mergeSortedLists(Node<Integer> list1, Node<Integer> list2) {
	    Node<Integer> dummyHead = new Node<>(0); // Temporary head
	    Node<Integer> current = dummyHead;

	    while (list1 != null && list2 != null) {
	        if (list1.getValue() <= list2.getValue()) {
	            current.setNext(new Node<>(list1.getValue()));
	            list1 = list1.getNext();
	        } else {
	            current.setNext(new Node<>(list2.getValue()));
	            list2 = list2.getNext();
	        }
	        current = current.getNext();
	    }

	    
	    current.setNext(list1 != null ? list1 : list2);

	    return dummyHead.getNext();
	}
	
	public static Node<Integer> selectionSort(Node<Integer> head) {
	    Node<Integer> sorted = null;

	    while (head != null) {
	        Node<Integer> minNode = findAndRemoveMin(head);
	        if (sorted == null) {
	            sorted = minNode;
	        } else {
	            append(sorted, minNode);
	        }
	        head = head.getNext();
	    }

	    return sorted;
	}

	private static Node<Integer> findAndRemoveMin(Node<Integer> head) {
	    Node<Integer> minNode = head;
	    Node<Integer> prevMin = null;

	    Node<Integer> prev = null;
	    Node<Integer> current = head;

	    while (current != null) {
	        if (current.getValue() < minNode.getValue()) {
	            minNode = current;
	            prevMin = prev;
	        }
	        prev = current;
	        current = current.getNext();
	    }

	    if (prevMin != null) {
	        prevMin.setNext(minNode.getNext());
	    } else {
	        head = head.getNext();
	    }

	    minNode.setNext(null);
	    return minNode;
	}

	private static void append(Node<Integer> sorted, Node<Integer> node) {
	    while (sorted.getNext() != null) {
	        sorted = sorted.getNext();
	    }
	    sorted.setNext(node);
	}
	
	public static int sumDistances(Node<Integer> head, int value) {
	    int index = 0;
	    int first = -1, last = -1;
	    int count = 0;

	    while (head != null) {
	        if (head.getValue() == value) {
	            count++;
	            if (first == -1) {
	                first = index;
	            }
	            last = index;
	        }
	        head = head.getNext();
	        index++;
	    }

	    if (count == 0) return -1; 

	    return first + (index - 1 - last);
	}

	public static void main(String[] args) {
		
	}
	public static boolean areAllElementsUnique(Node<Integer> head) {
	    Set<Integer> seen = new HashSet<Integer>(0);

	    while (head != null) {
	        if (!seen.add(head.getValue())) {
	            return false;
	        }
	        head = head.getNext();
	    }

	    return true;
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
	    Node<Integer> seen = new Node<Integer>(0);
	    Node<Integer> dummyHead = new Node<>(0);
	    Node<Integer> current = dummyHead;

	    while (head != null) {
	        if (seen.(head.getValue())) {
	            current.setNext(new Node<>(head.getValue()));
	            current = current.getNext();
	        }
	        head = head.getNext();
	    }

	    return dummyHead.getNext();
	}

}
