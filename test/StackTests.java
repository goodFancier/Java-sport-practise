import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTests
{
		@Test
		public void testPushAndPop()
		{
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				stack.push(2);
				stack.push(3);
				assertEquals(stack.pop().intValue(), 3);
		}

		@Test
		public void testSize()
		{
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				stack.push(2);
				stack.push(3);
				assertEquals(stack.size(), 3);
		}

		@Test
		public void testPeek()
		{
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				stack.push(2);
				stack.push(3);
				assertEquals(stack.peek().intValue(), 3);
		}
}
