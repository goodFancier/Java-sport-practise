import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EasySortTests
{
		@Test
		public void testSelectionSortStep()
		{
				int[] array = new int[]{10, 40, 30, 25};
				SortLevel.SelectionSortStep(array, 1);
				Arrays.stream(array).forEach(System.out::println);
		}

		@Test
		public void testBubbleSortStep()
		{
				int[] array = new int[]{4, 3, 1, 2};
				SortLevel.BubbleSortStep(array);
				Arrays.stream(array).forEach(System.out::println);
		}
}
