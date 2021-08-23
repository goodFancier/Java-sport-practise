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
				bst.AddKeyValue(35, 35);
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(35, 35);
				assertEquals(bst.FinMinMax(rootNode, true).NodeKey, 75);
				assertEquals(bst.FinMinMax(rootNode, false).NodeKey, 15);
				assertEquals(bst.FinMinMax(secondNode, true).NodeKey, 45);
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
				bst.AddKeyValue(60, 60);
				bst.AddKeyValue(70, 70);
				bst.AddKeyValue(65, 65);
				bst.AddKeyValue(75, 75);
				bst.AddKeyValue(15, 15);
				bst.AddKeyValue(35, 35);
				bst.DeleteNodeByKey(30);
				assertEquals(rootNode.LeftChild.LeftChild.NodeKey, 35);
		}
}
