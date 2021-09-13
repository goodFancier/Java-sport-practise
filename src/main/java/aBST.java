import java.util.*;

class aBST
{
		public Integer[] Tree; // массив ключей

		BSTNode<Integer> Root;

		class BSTFind<T>
		{
				// null если в дереве вообще нету узлов
				public BSTNode<T> Node;

				// true если узел найден
				public boolean NodeHasKey;

				// true, если родительскому узлу надо добавить новый левым
				public boolean ToLeft;

				public BSTFind()
				{
						Node = null;
				}
		}

		class BSTNode<T>
		{
				public int NodeKey; // ключ узла

				public T NodeValue; // значение в узле

				public BSTNode<T> Parent; // родитель или null для корня

				public BSTNode<T> LeftChild; // левый потомок

				public BSTNode<T> RightChild; // правый потомок

				public BSTNode(int key, T val, BSTNode<T> parent)
				{
						NodeKey = key;
						NodeValue = val;
						Parent = parent;
						LeftChild = null;
						RightChild = null;
				}

				public int getNodeKey()
				{
						return NodeKey;
				}
		}

		public aBST(int depth)
		{
				// правильно рассчитайте размер массива для дерева глубины depth:
				int tree_size = (int)Math.pow(2, depth);
				Tree = new Integer[tree_size];
				for(int i = 0; i < tree_size; i++)
						Tree[i] = null;
				if(Tree[0] != null)
						Root = new BSTNode<>(Tree[0], Tree[0], null);
				else
						Root = null;
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
				}
				else
				{
						if(Root.NodeKey == key)
						{
								rootNode.NodeHasKey = true;
								rootNode.Node = Root;
								return rootNode.Node.NodeKey;
						}
						rootNode.Node = Root;
						rootNode.ToLeft = key < Root.NodeKey;
						return findNodeByRecursion(rootNode, key);
				}
				return null; // не найден
		}

		private Integer findNodeByRecursion(BSTFind<Integer> parentNode, int key)
		{
				BSTFind<Integer> currentNode = new BSTFind<>();
				if(parentNode.ToLeft)
				{
						if(parentNode.Node.LeftChild == null)
								return null;
						currentNode.Node = parentNode.Node.LeftChild;
				}
				else
				{
						if(parentNode.Node.RightChild == null)
								return null;
						currentNode.Node = parentNode.Node.RightChild;
				}
				currentNode.ToLeft = key < currentNode.Node.NodeKey;
				if(currentNode.Node.NodeKey == key)
				{
						currentNode.NodeHasKey = true;
						return currentNode.Node.NodeKey;
				}
				else
						return findParentNodeByRecursion(currentNode, key).Node.NodeKey;
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

		public BSTFind<Integer> FindParentNodeByKey(int key)
		{
				// ищем в дереве узел и сопутствующую информацию по ключу
				BSTFind<Integer> rootNode = new BSTFind<>();
				if(Root == null)
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

		public int AddKey(int key)
		{
				BSTFind<Integer> node = FindParentNodeByKey(key);
				if(node == null || node.Node == null)
						Root = new BSTNode<>(key, key, null);
				else
				{
						if(node.Node.NodeKey == key)
								return key; // если ключ уже есть
						else
						{
								BSTNode<Integer> bstNode = new BSTNode<>(key, key, node.Node);
								if(node.ToLeft)
										node.Node.LeftChild = bstNode;
								else
										node.Node.RightChild = bstNode;
								return bstNode.NodeKey;
						}
				}
				return -1;
				// индекс добавленного/существующего ключа или -1 если не удалось
		}
}