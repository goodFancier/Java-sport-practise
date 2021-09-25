import java.util.Arrays;

public class AlgorithmsDataStructures2
{
		public int[] Tree;

		BSTNode<Integer> Root;

		class BSTNode<T>
		{
				public Integer NodeKey;

				public T NodeValue;

				public BSTNode<T> Parent;

				public BSTNode<T> LeftChild;

				public BSTNode<T> RightChild;

				public BSTNode(Integer key, T val, BSTNode<T> parent)
				{
						NodeKey = key;
						NodeValue = val;
						Parent = parent;
						LeftChild = null;
						RightChild = null;
				}

				public Integer getNodeKey()
				{
						return NodeKey;
				}
		}

		private void fillElements(int[] a)
		{
				int midValue = a[a.length / 2];
				BSTNode<Integer> middleNode = new BSTNode<>(midValue, midValue, null);
				Tree[0] = midValue;
				int[] leftSubArray = new int[a.length / 2];
				System.arraycopy(a, 0, leftSubArray, 0, leftSubArray.length);
				int index = fillLeftSubArray(middleNode, leftSubArray, 1);
				int[] rightSubArray = new int[a.length / 2];
				System.arraycopy(a, a.length / 2 + 1, rightSubArray, 0, rightSubArray.length);
				fillRightSubArray(middleNode, rightSubArray, index);
		}

		private int fillLeftSubArray(BSTNode<Integer> parent, int[] a, int index)
		{
				int midValue = a[a.length / 2];
				BSTNode<Integer> middleNode = new BSTNode<>(midValue, midValue, parent);
				Tree[index] = midValue;
				int[] subArray = new int[a.length / 2];
				if(subArray.length <= 0)
						return index;
				System.arraycopy(a, 0, subArray, 0, subArray.length);
				index++;
				return fillLeftSubArray(middleNode, subArray, index);
		}

		private void fillRightSubArray(BSTNode<Integer> parent, int[] a, int index)
		{
				int midValue = a[a.length / 2];
				BSTNode<Integer> middleNode = new BSTNode<>(midValue, midValue, parent);
				index++;
				Tree[index] = midValue;
				int[] subArray = new int[a.length / 2];
				if(subArray.length <= 0)
						return;
				System.arraycopy(a, 0, subArray, 0, subArray.length);
				fillRightSubArray(middleNode, subArray, index);
		}

		public static int[] GenerateBBSTArray(int[] a)
		{
				Arrays.sort(a);
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				algorithmsDataStructures.Tree = new int[a.length];
				algorithmsDataStructures.fillElements(a);
				return algorithmsDataStructures.Tree;
		}
}