import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTests
{
		@Test
		public void testAddElement()
		{
				OrderedList<Integer> orderedList = new OrderedList<>(true);
				orderedList.add(10);
				orderedList.add(20);
				orderedList.add(30);
				orderedList.add(15);
				assertEquals(orderedList.head.next.value.intValue(), 15);
		}
}
