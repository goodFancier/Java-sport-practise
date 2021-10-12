import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTests
{
		@Test
		public void makeHeap()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{2, 5, 8, 6, 1, 3, 4, 7, 11, 9}, 3);
				Arrays.stream(heap.HeapArray).forEach(System.out::println);
		}
}
