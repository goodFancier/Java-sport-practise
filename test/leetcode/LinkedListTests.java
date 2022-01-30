package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

public class LinkedListTests
{
		@Test
		public void testInsertInHeadInEmptyList()
		{
				MyLinkedList linkedList = new MyLinkedList();
				linkedList.addAtHead(10);
				assertEquals(linkedList.linkedList.size(), 10);
				assertEquals(linkedList.head.getValue(), 10);
		}

		@Test
		public void testInsertInHeadInOneElementList()
		{
				MyLinkedList linkedList = new MyLinkedList();
				linkedList.addAtHead(10);
				linkedList.addAtHead(20);
				linkedList.addAtHead(30);
				linkedList.addAtHead(40);
				//	assertEquals(linkedList.linkedList.length, 13);
				assertEquals(linkedList.head.getValue(), 40);
				assertEquals(linkedList.tail.getValue(), 10);
				/*assertEquals(linkedList.tail.getPrev(), linkedList.head);
				assertEquals(linkedList.head.getNext(), linkedList.tail);*/
				linkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::println);
		}

		@Test
		public void testAddAtIndex()
		{
				MyLinkedList linkedList = new MyLinkedList();
				linkedList.addAtHead(10);
				linkedList.addAtHead(20);
				linkedList.addAtHead(30);
				linkedList.addAtHead(40);
				linkedList.addAtIndex(6, 60);
				linkedList.addAtIndex(4, 45);
				linkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::println);
		}

		@Test
		public void testLinkedList()
		{
				MyLinkedList myLinkedList = new MyLinkedList();
				myLinkedList.addAtHead(1);
				myLinkedList.addAtTail(3);
				myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
				System.out.println(myLinkedList.get(1));            // return 2
				myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
				System.out.println(myLinkedList.get(1));             // return 3
		}

		@Test
		public void testLongLinkedList()
		{
				MyLinkedList myLinkedList = new MyLinkedList();
				myLinkedList.addAtHead(2);
				myLinkedList.deleteAtIndex(1);
				myLinkedList.addAtHead(2);
				myLinkedList.addAtHead(7);
				myLinkedList.addAtHead(3);
				myLinkedList.addAtHead(2);
				myLinkedList.addAtHead(5);
				myLinkedList.addAtTail(5);
				System.out.println(myLinkedList.get(5));
				myLinkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::print);
				System.out.println();
				myLinkedList.deleteAtIndex(6);
				myLinkedList.deleteAtIndex(4);
				myLinkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::print);
		}

		@Test
		public void test1LongLinkedList()
		{
				MyLinkedList myLinkedList = new MyLinkedList();
				myLinkedList.addAtTail(1);
				myLinkedList.addAtTail(3);
				myLinkedList.addAtIndex(1,2);
				myLinkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::print);
				System.out.println();
				System.out.println(myLinkedList.get(1));
				myLinkedList.deleteAtIndex(1);
				System.out.println(myLinkedList.get(2));
				myLinkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::print);
		}

		@Test
		public void test1LinkedList()
		{
				MyLinkedList myLinkedList = new MyLinkedList();
				myLinkedList.addAtIndex(1, 0);
				System.out.println(myLinkedList.get(0));
		}
}
