import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTests
{
		@Test
		public void testAddElementAsc()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(10);
				orderedList.add(11);
				orderedList.add(11);
				orderedList.add(10);
				orderedList.add(5);
				assertEquals(orderedList.head.value.intValue(), 5);
				assertEquals(orderedList.tail.value.intValue(), 11);
				assertEquals(orderedList.count(), 6);
		}

		@Test
		public void testAddElementDesc()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(false);
				orderedList.add(10);
				orderedList.add(10);
				orderedList.add(11);
				orderedList.add(11);
				orderedList.add(10);
				orderedList.add(5);
				assertEquals(orderedList.head.value.intValue(), 11);
				assertEquals(orderedList.tail.value.intValue(), 5);
				assertEquals(orderedList.count(), 6);
				orderedList.add(10);
				orderedList.add(11);
				orderedList.add(11);
				orderedList.add(10);
				assertEquals(orderedList.count(), 10);
				orderedList.getAll().stream().map(o -> o.value).forEach(System.out::println);
		}

		@Test
		public void testDeleteElement()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				orderedList.delete(20);
				assertEquals(orderedList.tail.value.intValue(), 30);
		}

		@Test
		public void testClearList()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				orderedList.clear(true);
				assertNull(orderedList.head);
				assertNull(orderedList.tail);
				assertEquals(orderedList.count(), 0);
		}

		@Test
		public void testCount()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				assertEquals(orderedList.count(), 4);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				assertEquals(orderedList.count(), 8);
		}

		@Test
		public void testFind()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				assertEquals(orderedList.find(30).value.intValue(), 30);
		}

		@Test
		public void testGetAll()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				assertEquals(orderedList.getAll().size(), 4);
		}


}
