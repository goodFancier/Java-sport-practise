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
		public void testAdd()
		{
				aBST aBST = new aBST(3);
				assertEquals(0, aBST.AddKey(10));
				assertEquals(1, aBST.AddKey(5));
				assertEquals(2, aBST.AddKey(15));
				assertEquals(6, aBST.AddKey(20));
				assertEquals(0, aBST.AddKey(10));
				assertEquals(3, aBST.AddKey(-5));
				aBST.AddKey(25);
				aBST.AddKey(30);
				aBST.AddKey(35);
				aBST.AddKey(40);
				aBST.AddKey(36);
				aBST.AddKey(32);
				aBST.AddKey(28);
				aBST.AddKey(90);
				aBST.AddKey(100);
				aBST.AddKey(1000);
				aBST.AddKey(20);
				aBST.AddKey(33);
				aBST.AddKey(28);
				aBST.AddKey(16);
				aBST.AddKey(18);
				aBST.AddKey(4);
				aBST.AddKey(2);
				aBST.AddKey(1);
		}
}
