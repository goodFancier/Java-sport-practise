import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DequeTests
{
		@Test
		public void testDequeInsertFront()
		{
				Deque<Integer> deque = new Deque<>();
				deque.addFront(1);
				deque.addFront(2);
				deque.addFront(3);
				assertEquals(deque.removeFront().intValue(), 3);
		}

		@Test
		public void testDequeInsertTail()
		{
				Deque<Integer> deque = new Deque<>();
				deque.addTail(1);
				deque.addTail(2);
				deque.addTail(3);
				assertEquals(deque.removeTail().intValue(), 3);
		}

		@Test
		public void testSize()
		{
				Deque<Integer> deque = new Deque<>();
				deque.addTail(1);
				deque.addTail(2);
				deque.addTail(3);
				assertEquals(deque.size(), 3);
		}

		@Test
		public void testIsWordPalindrome()
		{
				assertTrue(checkIsWordPalindrome());
		}

		public boolean checkIsWordPalindrome()
		{
				Deque<String> deque = new Deque<>();
				deque.addTail("L");
				deque.addTail("O");
				deque.addTail("L");
				deque.addTail("O");
				deque.addTail("L");
				while(deque.size() > 1)
				{
						String first = deque.removeFront();
						String last = deque.removeTail();
						if(!first.equals(last))
								return false;
				}
				return true;
		}
}
