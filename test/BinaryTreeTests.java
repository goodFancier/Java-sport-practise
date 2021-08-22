import org.junit.Test;

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
				bst.AddKeyValue(4, 40);
				bst.AddKeyValue(3, 30);
				bst.AddKeyValue(6, 60);
				System.out.println(bst.FindNodeByKey(6));
		}
}
