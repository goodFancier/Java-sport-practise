import java.io.*;
import java.util.*;

public class BinaryTree
{
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
						BSTFind<T> rootNode = new BSTFind<>();
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
								return findNodeByRecursion(rootNode, key);
						}
						return rootNode;
				}

				private BSTFind<T> findNodeByRecursion(BSTFind<T> parentNode, int key)
				{
						BSTFind<T> currentNode = new BSTFind<>();
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
								return findNodeByRecursion(currentNode, key);
				}

				public void postOrder(BSTNode<T> node, List<BSTNode<T>> nodeList)
				{
						if(node == null)
								return;
						postOrder(node.LeftChild, nodeList);
						postOrder(node.RightChild, nodeList);
						nodeList.add(node);
				}

				public boolean AddKeyValue(int key, T val)
				{
						// добавляем ключ-значение в дерево
						BSTFind<T> node = FindNodeByKey(key);
						if(node.Node == null)
								Root = new BSTNode<>(key, val, null);
						else
						{
								if(node.Node.NodeKey == key)
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
						List<BSTNode<T>> bstNodes = new ArrayList<>();
						postOrder(FromNode, bstNodes);
				    if (FindMax)
				    		return bstNodes.stream().max(Comparator.comparing(BSTNode::getNodeKey)).orElseThrow(NoSuchElementException::new);
						else
								return bstNodes.stream().min(Comparator.comparing(BSTNode::getNodeKey)).orElseThrow(NoSuchElementException::new);
				}

				public boolean DeleteNodeByKey(int key)
				{
						// удаляем узел по ключу
						return false; // если узел не найден
				}

				public int Count()
				{
						// количество узлов в дереве
						List<BinaryTree.BSTNode<T>> bstNodes = new ArrayList<>();
						postOrder(Root, bstNodes);
						return bstNodes.size();
				}
		}
}

