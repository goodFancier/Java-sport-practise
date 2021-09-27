import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmsDataStructures2
{
		BSTNode<Integer> Root;

		private int index = 0;

		class BSTNode<T>
		{
				public Integer NodeKey; // ключ узла

				public T NodeValue; // значение в узле

				public BSTNode<T> Parent; // родитель или null для корня

				public BSTNode<T> LeftChild; // левый потомок

				public BSTNode<T> RightChild; // правый потомок

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

		private BSTNode<Integer> sortedArrayToBST(int[] arr, int start, int end)
		{
				if(start > end)
				{
						return null;
				}
				int mid = (start + end) / 2;
				BSTNode<Integer> node = new BSTNode<>(arr[mid], arr[mid], null);
				node.LeftChild = sortedArrayToBST(arr, start, mid - 1);
				node.RightChild = sortedArrayToBST(arr, mid + 1, end);
				return node;
		}

		private void preOrder(List<Integer> nodeList, BSTNode<Integer> node)
		{
				if(node == null)
						return;
				nodeList.add(node.getNodeKey());
				preOrder(nodeList, node.LeftChild);
				preOrder(nodeList, node.RightChild);
		}

		public static int[] GenerateBBSTArray(int[] a)
		{
				Arrays.sort(a);
				AlgorithmsDataStructures2 algorithmsDataStructures = new AlgorithmsDataStructures2();
				BSTNode<Integer> root = algorithmsDataStructures.sortedArrayToBST(a, 0, a.length - 1);
				List<Integer> resultList = new ArrayList<>();
				algorithmsDataStructures.preOrder(resultList, root);
				for(int i = 0; i < a.length; i++)
						a[i] = resultList.get(i);
				return a;
		}
}