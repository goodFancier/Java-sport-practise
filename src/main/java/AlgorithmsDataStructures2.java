import java.util.Arrays;

public class AlgorithmsDataStructures2
{
		public Integer[] Tree;

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

		private void findRootElement(int[] a)
		{
				int middle = a[a.length / 2];
				Root = new BSTNode<>(middle, middle, null);
				Tree[0] = middle;
		}

		public static int[] GenerateBBSTArray(int[] a)
		{
				Arrays.sort(a);
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				algorithmsDataStructures.Tree = new Integer[a.length];
				algorithmsDataStructures.findRootElement(a);
				return a;
		}
}