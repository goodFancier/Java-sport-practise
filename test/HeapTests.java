import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTests
{
		@Test
		public void makeHeap()
		{
				Heap heap = new Heap();
				// heap.MakeHeap(new int[]{2, 5, 8, 6, 1, 3, 4, 7, 11, 9}, 3);
				heap.MakeHeap(new int[]{11}, 3);
				heap.Add(9);
				heap.Add(4);
				heap.Add(7);
				heap.Add(8);
				heap.Add(3);
				heap.Add(1);
				heap.Add(2);
				heap.Add(5);
				heap.Add(6);
				Arrays.stream(heap.HeapArray).forEach(System.out::println);
		}

		@Test
		public void getMaxInHeap()
		{
				Heap heap = new Heap();
				// heap.MakeHeap(new int[]{2, 5, 8, 6, 1, 3, 4, 7, 11, 9}, 3);
				heap.MakeHeap(new int[]{11}, 3);
				heap.Add(9);
				heap.Add(4);
				heap.Add(7);
				heap.Add(8);
				heap.Add(3);
				heap.Add(1);
				heap.Add(2);
				heap.Add(5);
				heap.Add(6);
				System.out.println(heap.GetMax());
		}
}
