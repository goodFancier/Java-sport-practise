import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTests
{
		@Test
		public void testRemoveFromBegin()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.remove(10);
				assertEquals(20, linkedList.head.value);
				assertEquals(20, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromEnd()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.remove(20);
				assertEquals(10, linkedList.head.value);
				assertEquals(10, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromBeginInEmptyList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.remove(20);
				assertNull(linkedList.head);
				assertNull(linkedList.tail);
		}

		@Test
		public void testRemoveFromBeginInBigList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.remove(10);
				assertEquals(20, linkedList.head.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromEndInBigList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.remove(100);
				assertEquals(10, linkedList.head.value);
				assertEquals(90, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromCenterInBigList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.remove(50);
				assertEquals(60, linkedList.head.next.next.next.next.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveAllFromBegin()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.removeAll(10);
				assertEquals(30, linkedList.head.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveAllFromEnd()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(100));
				linkedList.addInTail(new Node(100));
				linkedList.addInTail(new Node(100));
				linkedList.removeAll(100);
				assertEquals(10, linkedList.head.value);
				assertEquals(70, linkedList.tail.value);
		}

		@Test
		public void testClearList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.clear();
				assertNull(linkedList.head);
				assertNull(linkedList.tail);
		}

		@Test
		public void testListCount()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				linkedList.addInTail(new Node(50));
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				assertEquals(linkedList.count(), 10);
		}

		@Test
		public void testInsertNodeAfterValue()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Node(10));
				linkedList.addInTail(new Node(20));
				linkedList.addInTail(new Node(30));
				linkedList.addInTail(new Node(40));
				Node fifthNode = new Node(50);
				linkedList.addInTail(fifthNode);
				linkedList.addInTail(new Node(60));
				linkedList.addInTail(new Node(70));
				linkedList.addInTail(new Node(80));
				linkedList.addInTail(new Node(90));
				linkedList.addInTail(new Node(100));
				linkedList.insertAfter(fifthNode, new Node(55));
				assertEquals(linkedList.count(), 11);
				assertEquals(fifthNode.next.value, 55);
				assertEquals(fifthNode.prev.value, 40);
		}
}
