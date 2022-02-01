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

		@Test
		public void testInsertionSortStep()
		{
				int[] array = new int[]{7, 6, 5, 4, 3, 2, 1};
				SortLevel.InsertionSortStep(array, 3, 0);
				Arrays.stream(array).forEach(System.out::println);
				System.out.println();
				array = new int[]{10, 40, 30, 25};
				SortLevel.InsertionSortStep(array, 2, 1);
				Arrays.stream(array).forEach(System.out::println);
		}

		@Test
		public void testKnuthSequence()
		{
				SortLevel.KnuthSequence(13).forEach(System.out::println);
		}

		@Test
		public void testChunkArray()
		{
				System.out.println(SortLevel.ArrayChunk(new int[]{7, 5, 6, 4, 3, 1, 2}));
		}

		@Test
		public void testChunkArray1()
		{
				System.out.println(SortLevel.ArrayChunk(new int[]{1, 3, 4, 6, 5, 2, 8}));
		}
}
