import org.junit.Test;

import static org.junit.Assert.*;

public class BSTFromArrayTests
{
		@Test
		public void testGenerateTree()
		{
				BSTFromArray.BalancedBST balancedBST = new BSTFromArray.BalancedBST();
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
				balancedBST.GenerateTree(array);
				balancedBST.Root = new BSTFromArray.BSTNode(10, null);
				balancedBST.IsBalanced(balancedBST.Root);
				System.out.println(balancedBST.Root);
		}
}
