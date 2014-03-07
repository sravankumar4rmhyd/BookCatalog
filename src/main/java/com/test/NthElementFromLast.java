package com.test;

public class NthElementFromLast {
public static void main(String[] args) {
	LinkedList linkedList = new LinkedList();
    LinkedList.Node head = linkedList.head();
    linkedList.add( new LinkedList.Node("1"));
    linkedList.add( new LinkedList.Node("2"));
    linkedList.add( new LinkedList.Node("3"));
    linkedList.add( new LinkedList.Node("4")); 
    LinkedList.Node elem =nthToLast(head, 3);
    System.out.println(elem.data());
	}
public static LinkedList.Node nthToLast(LinkedList.Node head, int n) {
	  if (head == null || n < 1) {
	  return null;
	}
	  LinkedList.Node p1 = head;
	  LinkedList.Node p2 = head;
	  for (int j = 0; j < n - 1; ++j) {
	  if (p2 == null) {
	       return null;
	   }
	  p2 = p2.next();
	  }
	  while (p2.next() != null) {
	  p1 = p1.next();
	  p2 = p2.next();
	 }
	   return p1;
	 }
}
