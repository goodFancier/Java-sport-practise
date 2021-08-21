import org.junit.Test;

public class BinaryTreeTests
{
		@Test
		public void testFindElement()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(5, 50, null);
				BinaryTree.BSTNode<Integer> fourthNode = binaryTree.new BSTNode<>(4, 40, rootNode);
				BinaryTree.BSTNode<Integer> sixthNode = binaryTree.new BSTNode<>(6, 60, rootNode);
				rootNode.LeftChild = fourthNode;
				rootNode.RightChild = sixthNode;
				sixthNode.RightChild = binaryTree.new BSTNode<>(7, 70, sixthNode);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				System.out.println(bst.FindNodeByKey(7).Node.NodeKey);
		}

		@Test
		public void testFindNodeInEmptyTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(null);
				System.out.println(bst.FindNodeByKey(7).Node == null);
		}

		@Test
		public void testAddNodeInTree()
		{
				BinaryTree binaryTree = new BinaryTree();
				BinaryTree.BSTNode<Integer> rootNode = binaryTree.new BSTNode<>(5, 50, null);
				BinaryTree.BST<Integer> bst = binaryTree.new BST<>(rootNode);
				bst.AddKeyValue(6, 60);
				System.out.println(bst.FindNodeByKey(6));
		}
}
