package leetcode;

import java.util.ArrayList;
import java.util.List;

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

				public int getValue()
				{
						return value;
				}

				public Node getPrev()
				{
						return prev;
				}

				public Node getNext()
				{
						return next;
				}
		}

		Node head;

		Node tail;

		List<Node> linkedList;

		public MyLinkedList()
		{
				linkedList = new ArrayList<>();
		}

		public int get(int index)
		{
				if(index >= linkedList.size())
						return -1;
				return linkedList.get(index).value;
		}

		public void addAtHead(int val)
		{
				Node node = new Node(val);
				if(linkedList.isEmpty())
						linkedList.add(node);
				else
						addAtIndex(0, val);
				if(head != null)
						head.prev = node;
				head = node;
		}

		public void addAtTail(int val)
		{
				Node node = new Node(val);
				if (head == null)
						head = node;
				linkedList.add(node);
				if(tail != null)
						tail.next = node;
				tail = node;
		}

		public void addAtIndex(int index, int val)
		{
				if (index > linkedList.size())
						return;
				Node node = new Node(val);
				if(head == null)
				{
						head = node;
						tail = node;
						linkedList.add(node);
				}
				else
						if(index == 0)
						{
								Node oldHead = head;
								oldHead.prev = node;
								node.next = oldHead;
								head = node;
								linkedList.add(0, node);
						}
						else
								if(index == linkedList.size())
								{
										tail = node;
										linkedList.add(node);
								}
								else
								{
										if(index < linkedList.size())
										{
												linkedList.add(index, node);
										}
								}
		}

		public void deleteAtIndex(int index)
		{
				if(linkedList.size() > index)
						linkedList.remove(index);
		}
}