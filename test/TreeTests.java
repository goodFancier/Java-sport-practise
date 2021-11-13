import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeTests
{
		@Test
		public void testAddChild()
		{
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(10, parentNode);
				simpleTree.AddChild(parentNode, childNode);
				assertEquals(parentNode.Children.get(0).NodeValue, childNode.NodeValue);
		}

		@Test
		public void testDeleteNode()
		{
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				simpleTree.AddChild(parentNode, childNode1);
				simpleTree.AddChild(parentNode, childNode2);
				simpleTree.DeleteNode(childNode1);
				assertTrue(simpleTree.Root.Children.get(0).NodeValue.equals(childNode2.NodeValue) && simpleTree.Root.Children.size() == 1);
		}

		@Test
		public void testGetAllNodes()
		{
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, childNode1);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode3);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode3);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode1);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode1);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, childNode1);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode2);
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
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, childNode1);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode3);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode3);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode1);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode1);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, childNode1);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode2);
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
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, childNode1);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode3);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode3);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode1);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode1);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, childNode1);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode2);
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
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, childNode1);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode3);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode3);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode1);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode1);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, childNode1);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode2);
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
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(5, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode1 = new SimpleTreeNode<>(10, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, childNode1);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode3);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode3);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode1);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode1);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, childNode1);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode2);
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
				SimpleTreeNode<Integer> parentNode = new SimpleTreeNode<>(10, null);
				SimpleTree<Integer> simpleTree = new SimpleTree<>(parentNode);
				SimpleTreeNode<Integer> childNode2 = new SimpleTreeNode<>(20, parentNode);
				SimpleTreeNode<Integer> childNode3 = new SimpleTreeNode<>(30, parentNode);
				SimpleTreeNode<Integer> childNode6 = new SimpleTreeNode<>(60, parentNode);
				SimpleTreeNode<Integer> childNode5 = new SimpleTreeNode<>(50, childNode2);
				SimpleTreeNode<Integer> childNode7 = new SimpleTreeNode<>(70, childNode2);
				SimpleTreeNode<Integer> childNode4 = new SimpleTreeNode<>(40, childNode3);
				SimpleTreeNode<Integer> childNode8 = new SimpleTreeNode<>(80, childNode6);
				SimpleTreeNode<Integer> childNode9 = new SimpleTreeNode<>(90, childNode8);
				SimpleTreeNode<Integer> childNode10 = new SimpleTreeNode<>(100, childNode8);
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
