import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTests
{
		@Test
		public void testFindElement()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				Nodez node = linkedList.find(70);
				assertEquals(node.value, 70);
		}

		@Test
		public void testFindAllElements()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				List<Nodez> nodeList = linkedList.findAll(100);
				assertEquals(nodeList.size(), 3);
		}

		@Test
		public void testRemoveFromBegin()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.remove(10);
				assertEquals(20, linkedList.head.value);
				assertEquals(20, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromCenter()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.remove(10);
				assertEquals(20, linkedList.head.value);
				assertEquals(20, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromEnd()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
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
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.remove(10);
				assertEquals(20, linkedList.head.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromEndInBigList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.remove(100);
				assertEquals(10, linkedList.head.value);
				assertEquals(90, linkedList.tail.value);
		}

		@Test
		public void testRemoveFromCenterInBigList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.remove(50);
				assertEquals(60, linkedList.head.next.next.next.next.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveAllFromBegin()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.removeAll(10);
				assertEquals(30, linkedList.head.value);
				assertEquals(100, linkedList.tail.value);
		}

		@Test
		public void testRemoveAllInCenter()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(45));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(10));
				linkedList.removeAll(10);
				assertEquals(linkedList.head.value, 20);
				assertEquals(linkedList.tail.value, 30);
		}

		@Test
		public void testRemoveAllFromEnd()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				linkedList.addInTail(new Nodez(100));
				linkedList.removeAll(100);
				assertEquals(10, linkedList.head.value);
				assertEquals(70, linkedList.tail.value);
		}

		@Test
		public void testClearList()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.clear();
				assertNull(linkedList.head);
				assertNull(linkedList.tail);
		}

		@Test
		public void testListCount()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				linkedList.addInTail(new Nodez(50));
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				assertEquals(linkedList.count(), 10);
		}

		@Test
		public void testInsertNodeAfterValue()
		{
				LinkedList2 linkedList = new LinkedList2();
				linkedList.addInTail(new Nodez(10));
				linkedList.addInTail(new Nodez(20));
				linkedList.addInTail(new Nodez(30));
				linkedList.addInTail(new Nodez(40));
				Nodez fifthNode = new Nodez(50);
				linkedList.addInTail(fifthNode);
				linkedList.addInTail(new Nodez(60));
				linkedList.addInTail(new Nodez(70));
				linkedList.addInTail(new Nodez(80));
				linkedList.addInTail(new Nodez(90));
				linkedList.addInTail(new Nodez(100));
				linkedList.insertAfter(fifthNode, new Nodez(55));
				assertEquals(linkedList.count(), 11);
				assertEquals(fifthNode.next.value, 55);
				assertEquals(fifthNode.prev.value, 40);
		}
}
