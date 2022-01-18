package leetcode;

public class MyLinkedList
{
		protected class Node
		{
				private Node prev;

				private Node next;

				private int value;

				public Node(int value)
				{
						this.value = value;
				}
		}

		Node head;

		Node tail;

		Node[] linkedList;

		public MyLinkedList()
		{
				linkedList = new Node[1000];
		}

		public int get(int index)
		{
				if(index >= linkedList.length)
						return -1;
				return linkedList[index].value;
		}

		public void addAtHead(int val)
		{
				Node node = new Node(val);
				node.next = head;
				head.prev = node;
		}

		public void addAtTail(int val)
		{
				Node node = new Node(val);
				node.prev = tail;
				tail.next = node;
		}

		public void addAtIndex(int index, int val)
		{
				Node newNode = new Node(val);
				linkedList[index].prev = newNode;
				newNode.next = linkedList[index];
				rebuildIndexes();
		}

		public void deleteAtIndex(int index)
		{
				
		}

		public void rebuildIndexes()
		{
				linkedList[0] = head;
				for (int i = 1; i < linkedList.length; i++)
				{
						linkedList[i] = linkedList[i - 1].next;
				}
		}
}