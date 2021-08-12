import java.util.*;
import java.util.stream.Collectors;

public class Tree
{
		public class SimpleTreeNode<T>
		{
				public T NodeValue; // значение в узле

				public SimpleTreeNode<T> Parent; // родитель или null для корня

				public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

				public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
				{
						NodeValue = val;
						Parent = parent;
						Children = null;
				}
		}

		class SimpleTree<T>
		{
				public SimpleTreeNode<T> Root; // корень, может быть null

				public SimpleTree(SimpleTreeNode<T> root)
				{
						Root = root;
				}

				public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
				{
						// ваш код добавления нового дочернего узла существующему ParentNode
						if(ParentNode.Children == null)
								ParentNode.Children = new ArrayList<>();
						ParentNode.Children.add(NewChild);
				}

				public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
				{
						// ваш код удаления существующего узла NodeToDelete
						NodeToDelete.Children = null;
						for(int i = 0; i < NodeToDelete.Parent.Children.size(); i++)
								if(NodeToDelete.equals(NodeToDelete.Parent.Children.get(i)))
								{
										NodeToDelete.Parent.Children.remove(i);
										break;
								}
				}

				public List<SimpleTreeNode<T>> GetAllNodes()
				{
						// ваш код выдачи всех узлов дерева в определённом порядке;
						return getAllNodesByRecursion(new ArrayList<>(), Root);
				}

				public List<SimpleTreeNode<T>> getAllNodesByRecursion(List<SimpleTreeNode<T>> allNodes, SimpleTreeNode<T> headNode)
				{
						allNodes.add(headNode);
						if(headNode.Children != null)
								for(SimpleTreeNode<T> node : headNode.Children)
								{
										headNode = node;
										this.getAllNodesByRecursion(allNodes, headNode);
								}
						return allNodes;
				}

				public List<SimpleTreeNode<T>> FindNodesByValue(T val)
				{
						// ваш код поиска узлов по значению
						return GetAllNodes().stream().filter(o -> o.NodeValue.equals(val)).collect(Collectors.toList());
				}

				public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
				{
						// ваш код перемещения узла вместе с его поддеревом --
						// в качестве дочернего для узла NewParent
						OriginalNode.Parent.Children.remove(OriginalNode);
						OriginalNode.Parent = NewParent;
						NewParent.Children.add(OriginalNode);
				}

				public int Count()
				{
						// количество всех узлов в дереве
						return GetAllNodes().size();
				}

				public int LeafCount()
				{
						// количество листьев в дереве
						return (int)GetAllNodes().stream().filter(o -> o.Children == null || o.Children.isEmpty()).count();
				}
		}
}
