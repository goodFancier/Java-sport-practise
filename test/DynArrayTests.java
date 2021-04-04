import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DynArrayTests
{
		@Test
		public void testAddElement()
		{
				DynArray<Integer> dynArray = new DynArray<>(Integer.class);
				dynArray.append(1);
				assertEquals(dynArray.getItem(0).intValue(), 1);
				assertEquals(dynArray.count, 1);
				assertEquals(dynArray.capacity, 16);
				dynArray.append(2);
				dynArray.append(3);
				dynArray.append(4);
				dynArray.append(5);
				assertEquals(dynArray.count, 5);
				assertEquals(dynArray.capacity, 16);
				dynArray.append(6);
				dynArray.append(7);
				dynArray.append(8);
				dynArray.append(9);
				dynArray.append(10);
				dynArray.append(11);
				dynArray.append(12);
				dynArray.append(13);
				dynArray.append(14);
				dynArray.append(15);
				dynArray.append(16);
				dynArray.append(17);
				assertEquals(dynArray.count, 17);
				assertEquals(dynArray.capacity, 32);
		}

		@Test
		public void testInsertElement()
		{
				DynArray<Integer> dynArray = new DynArray<>(Integer.class);
				dynArray.append(1);
				dynArray.append(2);
				dynArray.append(3);
				dynArray.append(4);
				dynArray.append(5);
				dynArray.append(6);
				dynArray.append(7);
				dynArray.append(8);
				dynArray.append(9);
				dynArray.append(10);
				dynArray.append(11);
				dynArray.append(12);
				dynArray.append(13);
				dynArray.append(14);
				dynArray.append(15);
				dynArray.append(16);
				dynArray.insert(44, 40);
				Arrays.stream(dynArray.array).forEach(System.out::println);
				assertEquals(dynArray.count, 17);
				assertEquals(dynArray.capacity, 32);
		}

		@Test
		public void testRemoveItem()
		{
				DynArray<Integer> dynArray = new DynArray<>(Integer.class);
				dynArray.append(1);
				dynArray.append(2);
				dynArray.append(3);
				dynArray.append(4);
				dynArray.remove(2);
				assertEquals(dynArray.count, 3);
				assertEquals(dynArray.capacity, 16);
				Arrays.stream(dynArray.array).forEach(System.out::println);
		}

		@Test
		public void testGetItem()
		{
				DynArray<Integer> dynArray = new DynArray<>(Integer.class);
				dynArray.append(1);
				dynArray.append(2);
				dynArray.append(3);
				dynArray.append(4);
				System.out.println(dynArray.getItem(1));
		}
}
