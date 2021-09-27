import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmsDataStructures2Tests
{
		@Test
		public void testFillArray()
		{
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				int[] array = new int[5];
				array[0] = 5;
				array[1] = 7;
				array[2] = 10;
				array[3] = 20;
				array[4] = 30;
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array).length, 5);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[0], 10);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[1], 5);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[2], 7);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[3], 20);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[4], 30);
		}

		@Test
		public void testAddOneElement()
		{
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				int[] array = new int[1];
				array[0] = 10;
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array).length, 1);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[0], 10);
		}

		@Test
		public void testAddInEmpty()
		{
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				int[] array = new int[0];
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array).length, 0);
		}

		@Test
		public void testAdd10Elements()
		{
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				int[] array = new int[10];
				array[0] = 10;
				array[1] = 20;
				array[2] = 30;
				array[3] = 40;
				array[4] = 50;
				array[5] = 60;
				array[6] = 70;
				array[7] = 80;
				array[8] = 90;
				array[9] = 100;
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array).length, 10);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[0], 50);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[1], 20);
				assertEquals(algorithmsDataStructures.GenerateBBSTArray(array)[2], 10);
		}
}
