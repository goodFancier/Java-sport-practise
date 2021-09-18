import java.util.*;

class aBST
{
		public Integer[] Tree; // массив ключей

		BSTNode<Integer> Root;

		public aBST(int depth)
		{
				// правильно рассчитайте размер массива для дерева глубины depth:
				int tree_size = 0;
				for(int i = 0; i <= depth; i++)
						tree_size += (int)Math.pow(2, i);
				Tree = new Integer[tree_size];
				for(int i = 0; i < tree_size; i++)
						Tree[i] = null;
		}

		class BSTFind<T>
		{
				// null если в дереве вообще нету узлов
				public BSTNode<T> Node;

				// true если узел найден
				public boolean NodeHasKey;

				// true, если родительскому узлу надо добавить новый левым
				public boolean ToLeft;

				private int index;

				public BSTFind()
				{
						Node = null;
				}
		}

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

		private BSTFind<Integer> findParentNodeByRecursion(BSTFind<Integer> parentNode, int key)
		{
				BSTFind<Integer> currentNode = new BSTFind<>();
				if(parentNode.ToLeft)
				{
						if(parentNode.Node.LeftChild == null)
								return parentNode;
						currentNode.Node = parentNode.Node.LeftChild;
				}
				else
				{
						if(parentNode.Node.RightChild == null)
								return parentNode;
						currentNode.Node = parentNode.Node.RightChild;
				}
				currentNode.ToLeft = key < currentNode.Node.NodeKey;
				if(currentNode.Node.NodeKey == key)
				{
						currentNode.NodeHasKey = true;
						return currentNode;
				}
				else
						return findParentNodeByRecursion(currentNode, key);
		}

		public BSTFind<Integer> findParentNodeByKey(int key)
		{
				// ищем в дереве узел и сопутствующую информацию по ключу
				BSTFind<Integer> rootNode = new BSTFind<>();
				if(Root == null || Root.NodeKey == null)
				{
						rootNode.NodeHasKey = false;
						rootNode.ToLeft = false;
						rootNode.Node = null;
				}
				else
				{
						if(Root.NodeKey == key)
						{
								rootNode.NodeHasKey = true;
								rootNode.Node = Root;
								return rootNode;
						}
						rootNode.Node = Root;
						rootNode.ToLeft = key < Root.NodeKey;
						return findParentNodeByRecursion(rootNode, key);
				}
				return null; // не найден
		}

		private Integer findIndexByRecursion(BSTFind<Integer> parentNode, int key)
		{
				BSTFind<Integer> currentNode = new BSTFind<>();
				if(parentNode.ToLeft)
				{
						if(parentNode.Node.LeftChild == null)
								return -1 * (2 * parentNode.index + 1);
						currentNode.Node = parentNode.Node.LeftChild;
						currentNode.index = 2 * parentNode.index + 1;
				}
				else
				{
						if(parentNode.Node.RightChild == null)
								return -1 * (2 * parentNode.index + 2);
						currentNode.Node = parentNode.Node.RightChild;
						currentNode.index = 2 * parentNode.index + 2;
				}
				currentNode.ToLeft = key < currentNode.Node.NodeKey;
				if(currentNode.Node.NodeKey == key)
				{
						currentNode.NodeHasKey = true;
						return currentNode.index;
				}
				else
						return findIndexByRecursion(currentNode, key);
		}

		public Integer FindKeyIndex(int key)
		{
				// ищем в массиве индекс ключа
				BSTFind<Integer> rootNode = new BSTFind<>();
				if(Root == null)
				{
						rootNode.NodeHasKey = false;
						rootNode.ToLeft = false;
						rootNode.Node = null;
						return null; // не найден
				}
				else
				{
						rootNode.index = 0;
						if(Root.NodeKey == key)
						{
								rootNode.NodeHasKey = true;
								rootNode.Node = Root;
								return rootNode.index;
						}
						rootNode.Node = Root;
						rootNode.ToLeft = key < Root.NodeKey;
						int foundIndex = findIndexByRecursion(rootNode, key);
						return Math.abs(foundIndex) >= Tree.length? null: foundIndex;
				}
		}

		public int AddKey(int key)
		{
				if(Root != null && FindKeyIndex(key) == null)
						return -1;
				BSTFind<Integer> node = findParentNodeByKey(key);
				if(node == null || node.Node == null)
				{
						Root = new BSTNode<>(key, key, null);
						return 0;
				}
				else
				{
						if(node.Node.NodeKey != key)
						{
								BSTNode<Integer> bstNode = new BSTNode<>(key, key, node.Node);
								if(node.ToLeft)
										node.Node.LeftChild = bstNode;
								else
										node.Node.RightChild = bstNode;
						}
				}
				int foundIndex = FindKeyIndex(key);
				Tree[foundIndex] = key;
				return foundIndex;
				// индекс добавленного/существующего ключа или -1 если не удалось
		}
}