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
}
