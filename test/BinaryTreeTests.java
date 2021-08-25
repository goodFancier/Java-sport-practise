import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTests
{
		@Test
		public void testFindElement()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(35, 35);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(20, 20);
				assertEquals(bst.Root.LeftChild.LeftChild.RightChild.NodeKey, 35);
				assertEquals(bst.Root.RightChild.RightChild.LeftChild.NodeKey, 65);
		}

		@Test
		public void testFindNodeInEmptyTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(null);
				assertNull(bst.FindNodeByKey(7).Node);
		}

		@Test
		public void testFindNodeInOneNodeTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				assertEquals(bst.FindNodeByKey(50).Node.NodeKey, 50);
		}

		@Test
		public void testAddExistsNodeInTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(35, 35);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(35, 35);
				assertEquals(bst.Count(), 9);
		}

		@Test
		public void testCount()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(35, 35);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(35, 35);
				assertEquals(bst.Count(), 9);
		}

		@Test
		public void testFindMinMax()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BSTNode<Integer> secondNode = binaryTree.new BSTNode<>(45, 45, rootNode);
				rootNode.LeftChild = secondNode;
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(48, 48);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(35, 35);
				assertEquals(bst.FinMinMax(rootNode, true).NodeKey, 75);
				assertEquals(bst.FinMinMax(rootNode, false).NodeKey, 15);
				assertEquals(bst.FinMinMax(secondNode, true).NodeKey, 48);
				assertEquals(bst.FinMinMax(secondNode, false).NodeKey, 15);
		}

		@Test
		public void testDeleteNode()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(35, 35);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(58, 58);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(62, 62);
				bst.AddKeyValue(57, 57);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(68, 68);
				bst.AddKeyValue(69, 69);
				bst.AddKeyValue(75, 75);
				bst.DeleteNodeByKey(75);
				assertEquals(bst.Count(), 13);
		}

		@Test
		public void testDeleteLastNode()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(55, 55);
				bst.DeleteNodeByKey(50);
				assertEquals(bst.Count(), 1);
		}

		@Test
		public void testDeleteLeftLastNode()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(45, 45);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(25, 25);
				bst.DeleteNodeByKey(30);
				assertEquals(bst.Count(), 4);
		}

		@Test
		public void testDeleteNodeInEmptyTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(null);
				bst.DeleteNodeByKey(50);
				assertEquals(bst.Count(), 0);
		}

		@Test
		public void testDeleteRoot()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(50, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.DeleteNodeByKey(50);
				bst.AddKeyValue(40, 40);
				bst.AddKeyValue(30, 30);
				bst.AddKeyValue(35, 35);
				assertEquals(bst.Count(), 3);
		}
}
