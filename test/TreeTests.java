import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeTests
{
		@Test
		public void testAddChild()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode = tree.new SimpleTreeNode<>(10, parentNode);
				simpleTree.AddChild(parentNode, childNode);
				assertEquals(parentNode.Children.get(0).NodeValue, childNode.NodeValue);
		}

		@Test
		public void testDeleteNode()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.DeleteNode(childNode1);
				assertTrue(simpleTree.Root.Children.get(0).NodeValue.equals(childNode2.NodeValue) && simpleTree.Root.Children.size() == 1);
		}

		@Test
		public void testGetAllNodes()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, childNode1);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode3);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode3);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode1);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode1);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, childNode1);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode2);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(childNode1, childNode3);
				simpleTree.AddChild(childNode3, childNode9);
				simpleTree.AddChild(childNode3, childNode10);
				simpleTree.AddChild(childNode1, childNode4);
				simpleTree.AddChild(childNode1, childNode5);
				simpleTree.AddChild(childNode1, childNode6);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode2, childNode8);
				assertEquals(simpleTree.GetAllNodes().size(), 11);
				assertEquals(simpleTree.GetAllNodes().size(), 11);
				assertNotEquals(simpleTree.GetAllNodes().size(), 12);
		}

		@Test
		public void testFindNodesByValue()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, childNode1);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode3);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode3);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode1);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode1);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, childNode1);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode2);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(childNode1, childNode3);
				simpleTree.AddChild(childNode3, childNode9);
				simpleTree.AddChild(childNode3, childNode10);
				simpleTree.AddChild(childNode1, childNode4);
				simpleTree.AddChild(childNode1, childNode5);
				simpleTree.AddChild(childNode1, childNode6);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode2, childNode8);
				assertEquals(simpleTree.FindNodesByValue(50).size(), 1);
				assertEquals((int)simpleTree.FindNodesByValue(50).get(0).NodeValue, 50);
		}

		@Test
		public void testMoveNode()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, childNode1);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode3);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode3);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode1);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode1);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, childNode1);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode2);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(childNode1, childNode3);
				simpleTree.AddChild(childNode3, childNode9);
				simpleTree.AddChild(childNode3, childNode10);
				simpleTree.AddChild(childNode1, childNode4);
				simpleTree.AddChild(childNode1, childNode5);
				simpleTree.AddChild(childNode1, childNode6);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode2, childNode8);
				simpleTree.MoveNode(parentNode, childNode10);
				assertEquals(simpleTree.GetAllNodes().size(), 11);
				simpleTree.MoveNode(childNode1, childNode2);
				assertEquals(childNode9.Parent.Parent.Parent, childNode2);
		}

		@Test
		public void testCountAllNodes()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, childNode1);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode3);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode3);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode1);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode1);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, childNode1);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode2);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(childNode1, childNode3);
				simpleTree.AddChild(childNode3, childNode9);
				simpleTree.AddChild(childNode3, childNode10);
				simpleTree.AddChild(childNode1, childNode4);
				simpleTree.AddChild(childNode1, childNode5);
				simpleTree.AddChild(childNode1, childNode6);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode2, childNode8);
				assertEquals(simpleTree.Count(), 11);
		}

		@Test
		public void testLeafCount()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(5, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode1 = tree.new SimpleTreeNode<>(10, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, childNode1);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode3);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode3);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode1);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode1);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, childNode1);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode2);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(childNode1, childNode3);
				simpleTree.AddChild(childNode3, childNode9);
				simpleTree.AddChild(childNode3, childNode10);
				simpleTree.AddChild(childNode1, childNode4);
				simpleTree.AddChild(childNode1, childNode5);
				simpleTree.AddChild(childNode1, childNode6);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode2, childNode8);
				assertEquals(simpleTree.LeafCount(), 7);
		}

		@Test
		public void testEvenTree()
		{
				Tree tree = new Tree();
				Tree.SimpleTreeNode<Integer> parentNode = tree.new SimpleTreeNode<>(10, null);
				Tree.SimpleTree<Integer> simpleTree = tree.new SimpleTree<>(parentNode);
				Tree.SimpleTreeNode<Integer> childNode2 = tree.new SimpleTreeNode<>(20, parentNode);
				Tree.SimpleTreeNode<Integer> childNode3 = tree.new SimpleTreeNode<>(30, parentNode);
				Tree.SimpleTreeNode<Integer> childNode6 = tree.new SimpleTreeNode<>(60, parentNode);
				Tree.SimpleTreeNode<Integer> childNode5 = tree.new SimpleTreeNode<>(50, childNode2);
				Tree.SimpleTreeNode<Integer> childNode7 = tree.new SimpleTreeNode<>(70, childNode2);
				Tree.SimpleTreeNode<Integer> childNode4 = tree.new SimpleTreeNode<>(40, childNode3);
				Tree.SimpleTreeNode<Integer> childNode8 = tree.new SimpleTreeNode<>(80, childNode6);
				Tree.SimpleTreeNode<Integer> childNode9 = tree.new SimpleTreeNode<>(90, childNode8);
				Tree.SimpleTreeNode<Integer> childNode10 = tree.new SimpleTreeNode<>(100, childNode8);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.AddChild(parentNode, childNode3);
				simpleTree.AddChild(parentNode, childNode6);
				simpleTree.AddChild(childNode2, childNode5);
				simpleTree.AddChild(childNode2, childNode7);
				simpleTree.AddChild(childNode3, childNode4);
				simpleTree.AddChild(childNode6, childNode8);
				simpleTree.AddChild(childNode8, childNode9);
				simpleTree.AddChild(childNode8, childNode10);
				List<Integer> resultList = simpleTree.EvenTrees();
				System.out.println(resultList);
		}
}
