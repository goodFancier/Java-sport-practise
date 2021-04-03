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
				System.out.println(dynArray.getItem(0));
				/*assertEquals(node.value, 70);*/
		}

		@Test
		public void testInsertElement()
		{
				DynArray<Integer> dynArray = new DynArray<>(Integer.class);
				dynArray.append(1);
				dynArray.append(2);
				dynArray.append(3);
				dynArray.append(4);
				dynArray.insert(10, 2);
				Arrays.stream(dynArray.array).forEach(System.out::println);
		}
}
