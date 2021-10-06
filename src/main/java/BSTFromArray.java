import java.util.*;

class BSTNode
{
		public int NodeKey; // ключ узла

		public BSTNode Parent; // родитель или null для корня

		public BSTNode LeftChild; // левый потомок

		public BSTNode RightChild; // правый потомок

		public int Level; // глубина узла

		public BSTNode(int key, BSTNode parent)
		{
				NodeKey = key;
				Parent = parent;
				LeftChild = null;
				RightChild = null;
		}
}

class BalancedBST
{
		public BSTNode Root; // корень дерева

		public BalancedBST()
		{
				Root = null;
		}

		private BSTNode sortedArrayToBST(int[] arr, int start, int end, BSTNode parent)
		{
				if(start > end)
				{
						return null;
				}
				int mid = (start + end) / 2;
				BSTNode node = new BSTNode(arr[mid], parent);
				if(parent == null)
						node.Level = 0;
				else
						node.Level = parent.Level + 1;
				node.LeftChild = sortedArrayToBST(arr, start, mid - 1, node);
				node.RightChild = sortedArrayToBST(arr, mid + 1, end, node);
				return node;
		}

		private int height(BSTNode node)
		{
				if(node == null)
						return 0;
				return 1 + Math.max(height(node.LeftChild), height(node.RightChild));
		}

		public void GenerateTree(int[] a)
		{
				// создаём дерево с нуля из неотсортированного массива a
				Arrays.sort(a);
				Root = sortedArrayToBST(a, 0, a.length - 1, null);
		}

		public boolean IsBalanced(BSTNode root_node)
		{
				if(root_node == null)
						return true;
				int lh = height(root_node.LeftChild);
				int rh = height(root_node.RightChild);
				// сбалансировано ли дерево с корнем root_node
				return Math.abs(lh - rh) <= 1 && IsBalanced(root_node.LeftChild) && IsBalanced(root_node.RightChild);
		}
}

