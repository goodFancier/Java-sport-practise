import java.io.*;
import java.util.*;

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
		}

		// промежуточный результат поиска
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

		class BST<T>
		{
				BSTNode<T> Root; // корень дерева, или null

				public BST(BSTNode<T> node)
				{
						Root = node;
				}

				public BSTFind<T> FindNodeByKey(int key)
				{
						// ищем в дереве узел и сопутствующую информацию по ключу
						BSTFind<T> bstFind = new BSTFind<>();
						if(Root == null)
						{
								bstFind.NodeHasKey = false;
								bstFind.ToLeft = false;
								bstFind.Node = null;
						}
						else
						{
								if(Root.NodeKey == key)
								{
										bstFind.NodeHasKey = true;
										bstFind.Node = Root;
										return bstFind;
								}
								bstFind.Node = Root;
								bstFind.ToLeft = key < Root.NodeKey;
								BSTFind<T> foundNode = findNodeByRecursion(bstFind, key);
								if(foundNode == null)
										bstFind.Node = null;
								else
										bstFind = findNodeByRecursion(bstFind, key);
						}
						return bstFind;
				}

				private BSTFind<T> findNodeByRecursion(BSTFind<T> node, int key)
				{
						BSTFind<T> currentNode = new BSTFind<>();
						if(node.ToLeft)
						{
								if(node.Node.LeftChild == null)
										return null;
								currentNode.Node = node.Node.LeftChild;
						}
						else
						{
								if(node.Node.RightChild == null)
										return null;
								currentNode.Node = node.Node.RightChild;
						}
						if(currentNode.Node.NodeKey == key)
						{
								currentNode.NodeHasKey = true;
								return currentNode;
						}
						else
								return findNodeByRecursion(currentNode, key);
				}

				public boolean AddKeyValue(int key, T val)
				{
						// добавляем ключ-значение в дерево
						BSTFind<T> node = FindNodeByKey(key);
						if(node.Node == null)
								Root = new BSTNode<>(key, val, null);
						else
						{
								if(node.NodeHasKey)
										return false; // если ключ уже есть
								else
								{
										BSTNode<T> bstNode = new BSTNode<>(key, val, node.Node);
										if(node.ToLeft)
												node.Node.LeftChild = bstNode;
										else
												node.Node.RightChild = bstNode;
								}
						}
						return true;
				}

				public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
				{
						// ищем максимальный/минимальный ключ в поддереве
						return null;
				}

				public boolean DeleteNodeByKey(int key)
				{
						// удаляем узел по ключу
						return false; // если узел не найден
				}

				public int Count()
				{
						return 0; // количество узлов в дереве
				}
		}

