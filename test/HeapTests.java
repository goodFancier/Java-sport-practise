import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTests
{
		@Test
		public void makeAllElementHeap()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{2, 5, 8, 6, 1, 3, 4, 7, 11, 9}, 3);
				assertEquals(heap.HeapArray[0], 11);
				assertEquals(heap.getCurrentSize(), 10);
		}

		@Test
		public void makeManyElementHeap()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{2, 5, 8, 6, 1}, 3);
				heap.Add(9);
				heap.Add(4);
				heap.Add(7);
				heap.Add(8);
				heap.Add(3);
				heap.Add(1);
				heap.Add(2);
				heap.Add(5);
				heap.Add(6);
				heap.Add(10);
				heap.Add(11);
				heap.Add(12);
				heap.Add(13);
				heap.Add(14);
				heap.Add(15);
				heap.Add(16);
				heap.Add(17);
				heap.Add(18);
				Assert.assertEquals(heap.getCurrentSize(), heap.HeapArray.length);
		}

		@Test
		public void makeSameElementHeap()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{8}, 3);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				heap.Add(8);
				Arrays.stream(heap.HeapArray).forEach(System.out::println);
		}

		@Test
		public void getMaxInHeap()
		{
				Heap heap = new Heap();
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

		@Test
		public void testAddZeroElement()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{}, 1);
				heap.Add(0);
				heap.Add(10);
				heap.Add(5);
				heap.Add(7);
				Arrays.stream(heap.HeapArray).forEach(System.out::println);
		}

		@Test
		public void testAddMinusElement()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{}, 1);
				heap.Add(0);
				heap.Add(-2);
				heap.Add(-3);
				heap.Add(-5);
				Arrays.stream(heap.HeapArray).forEach(System.out::println);
		}

		@Test
		public void testGetRoot()
		{
				Heap heap = new Heap();
				heap.MakeHeap(new int[]{2, 5, 8, 6, 1, 3, 4, 7, 11, 9}, 3);
				assertEquals(heap.GetMax(), 11);
		}
}
