import org.junit.Test;

public class ArrayBSTTests
{
		@Test
		public void testAddInArrayBST()
		{
				aBST aBST = new aBST(3);
				aBST.AddKey(10);
				aBST.AddKey(20);
				aBST.AddKey(50);
				aBST.AddKey(60);
				aBST.AddKey(40);
				System.out.println(aBST.FindKeyIndex(30));
		}
}
