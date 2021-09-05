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

				public BSTFind<T> FindParentNodeByKey(int key)
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
								return findParentNodeByRecursion(rootNode, key);
						}
						return rootNode;
				}

				private BSTFind<T> findParentNodeByRecursion(BSTFind<T> parentNode, int key)
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
								return findParentNodeByRecursion(currentNode, key);
				}

				private BSTFind<T> findNodeByRecursion(BSTFind<T> parentNode, int key)
				{
						BSTFind<T> currentNode = new BSTFind<>();
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
								return currentNode;
						}
						else
								return findParentNodeByRecursion(currentNode, key);
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
						BSTFind<T> node = FindParentNodeByKey(key);
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
						if(FindMax)
								return bstNodes.stream().max(Comparator.comparing(BSTNode::getNodeKey)).orElseThrow(NoSuchElementException::new);
						else
								return bstNodes.stream().min(Comparator.comparing(BSTNode::getNodeKey)).orElseThrow(NoSuchElementException::new);
				}

				public boolean DeleteNodeByKey(int key)
				{
						// удаляем узел по ключу
						if(FindNodeByKey(key) == null)
								return false;
						if(DeleteNodeByRecursion(Root, key) == null)
								Root = null;
						return true;
				}

				public BSTNode<T> DeleteNodeByRecursion(BSTNode<T> root, int key)
				{
						if(root == null)
								return null;
						if(key < root.getNodeKey())
								root.LeftChild = DeleteNodeByRecursion(root.LeftChild, key);
						else
								if(key > root.getNodeKey())
										root.RightChild = DeleteNodeByRecursion(root.RightChild, key);
								else
										if(root.LeftChild != null && root.RightChild != null)
										{
												root.NodeKey = FinMinMax(root.RightChild, false).NodeKey;
												root.NodeValue = FinMinMax(root.RightChild, false).NodeValue;
												root.RightChild = DeleteNodeByRecursion(root.RightChild, root.NodeKey);
										}
										else
												if(root.LeftChild != null)
												{
														BSTNode<T> parent = root.Parent;
														root = root.LeftChild;
														root.Parent = parent;
												}
												else
														if(root.RightChild != null)
														{
																BSTNode<T> parent = root.Parent;
																root = root.RightChild;
																root.Parent = parent;
														}
														else
																root = null;
						if(root != null && root.Parent == null)
								Root = root;
						return root;
				}

				public int Count()
				{
						// количество узлов в дереве
						List<BSTNode<T>> bstNodes = new ArrayList<>();
						postOrder(Root, bstNodes);
						return bstNodes.size();
				}

				public ArrayList<BSTNode<T>> WideAllNodes()
				{
						ArrayList<BSTNode<T>> queue = new ArrayList<>();
						ArrayList<BSTNode<T>> values = new ArrayList<>();
						queue.add(Root);
						while(queue.size() > 0)
						{
								BSTNode<T> tempNode = queue.remove(0);
								values.add(tempNode);
								if(tempNode.LeftChild != null)
								{
										queue.add(tempNode.LeftChild);
								}
								if(tempNode.RightChild != null)
								{
										queue.add(tempNode.RightChild);
								}
						}
						return values;
				}

				public ArrayList<BSTNode<T>> DeepAllNodes(Integer order)
				{
						ArrayList<BSTNode<T>> nodeList = new ArrayList<>();
						BSTNode<T> node = Root;
						if(order == 0)
						{
								inOrder(nodeList, Root);
						}
						else
								if(order == 1)
								{
										postOrder(Root, nodeList);
								}
								else
								{
										preOrder(nodeList, Root);
								}
						return nodeList;
				}

				private void inOrder(ArrayList<BSTNode<T>> nodeList, BSTNode<T> node)
				{
						if(node == null)
								return;
						inOrder(nodeList, node.LeftChild);
						nodeList.add(node);
						inOrder(nodeList, node.RightChild);
				}

				private void preOrder(ArrayList<BSTNode<T>> nodeList, BSTNode<T> node)
				{
						if(node == null)
								return;
						nodeList.add(node);
						preOrder(nodeList, node.LeftChild);
						preOrder(nodeList, node.RightChild);
				}
		}