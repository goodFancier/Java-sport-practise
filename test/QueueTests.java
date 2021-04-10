import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTests
{
		@Test
		public void testEnqueueAndDequeue()
		{
				Queue<Integer> queue = new Queue<>();
				queue.enqueue(1);
				queue.enqueue(2);
				queue.enqueue(3);
				assertEquals(queue.dequeue().intValue(), 1);
				assertEquals(queue.dequeue().intValue(), 2);
		}

		@Test
		public void testSize()
		{
				Queue<Integer> queue = new Queue<>();
				queue.enqueue(1);
				queue.enqueue(2);
				queue.enqueue(3);
				assertEquals(queue.size(), 3);
		}
}
