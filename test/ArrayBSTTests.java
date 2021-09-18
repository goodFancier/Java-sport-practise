import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBSTTests
{
		@Test
		public void testAddInArrayBST()
		{
				aBST aBST = new aBST(3);
				assertEquals(0, aBST.AddKey(10));
				assertEquals(2, aBST.AddKey(20));
				assertEquals(4, aBST.AddKey(50));
				assertEquals(4, aBST.AddKey(50));
				assertEquals(6, aBST.AddKey(60));
				assertEquals(4, aBST.AddKey(50));
				assertEquals(4, aBST.AddKey(50));
				assertEquals(7, aBST.AddKey(55));
				assertEquals(aBST.Tree.length, 15);
		}

		@Test
		public void testFindKeyIndex()
		{
				aBST aBST = new aBST(3);
				assertEquals(aBST.AddKey(10), 0);
				assertEquals(aBST.AddKey(20), 2);
				assertEquals(aBST.AddKey(50), 6);
				assertEquals(aBST.AddKey(60), 14);
				assertEquals(aBST.AddKey(80), -1);
				assertEquals(aBST.AddKey(150), -1);
				assertNull(aBST.FindKeyIndex(80));
				assertNull(aBST.FindKeyIndex(100));
		}

		@Test
		public void testFindKeyIndexInElemArray()
		{
				aBST aBST = new aBST(3);
				aBST.AddKey(10);
				System.out.println(aBST.FindKeyIndex(40));
		}
}
