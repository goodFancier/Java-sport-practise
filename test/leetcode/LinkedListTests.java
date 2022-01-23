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
				linkedList.linkedList.stream().filter(Objects::nonNull).map(MyLinkedList.Node::getValue).forEach(System.out::println);
		}
}
