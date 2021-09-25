import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmsDataStructures2Tests
{
		@Test
		public void testFillArray()
		{
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				int[] array = new int[5];
				array[0] = 10;
				array[1] = 20;
				array[2] = 7;
				array[3] = 30;
				array[4] = 5;
				algorithmsDataStructures.GenerateBBSTArray(array);
		}
}
