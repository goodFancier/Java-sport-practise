package leetcode;

import java.util.Arrays;

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

		Node[] linkedList;

		public MyLinkedList()
		{
				linkedList = new Node[10];
		}

		public int get(int index)
		{
				if(index >= linkedList.length)
						return -1;
				return linkedList[index].value;
		}

		public void addAtHead(int val)
		{
				addAtIndex(0, val);
		}

		public void addAtTail(int val)
		{
				addAtIndex(linkedList.length - 1, val);
		}

		public void addAtIndex(int index, int val)
		{
				Node node = new Node(val);
				if(head == null)
				{
						head = node;
						tail = node;
						linkedList[0] = node;
				}
				else
						if(index == 0)
						{
								Node oldHead = head;
								oldHead.prev = node;
								node.next = oldHead;
								head = node;
								if(linkedList[linkedList.length - 1] != null)
										linkedList = Arrays.copyOf(linkedList, linkedList.length + 1);
								if(linkedList.length - 1 >= 0)
										System.arraycopy(linkedList, 0, linkedList, 1, linkedList.length - 1);
								linkedList[0] = node;
						}
						else
								if(index == linkedList.length)
								{
										node.prev = linkedList[linkedList.length - 1];
										linkedList = Arrays.copyOf(linkedList, linkedList.length + 1);
										node.prev.next = node;
										linkedList[linkedList.length - 1] = node;
										tail = node;
								}
								else
								{
										if(index < linkedList.length)
										{
												if(linkedList[linkedList.length - 1] != null)
														linkedList = Arrays.copyOf(linkedList, linkedList.length + 1);
												if(linkedList[index] != null)
												{
														System.arraycopy(linkedList, index + 1 - 1, linkedList, index + 1, linkedList.length - index + 1);
														node.next = linkedList[index + 1];
														linkedList[index] = node;
														if(tail.next == null || tail == linkedList[index])
																tail = linkedList[index];
														linkedList[index + 1].prev = linkedList[index];
												}
												else
												{
														linkedList[index] = node;
														if(tail.next == null || tail == linkedList[index])
																tail = linkedList[index];
												}
										}
								}
		}

		public void deleteAtIndex(int index)
		{
		}
}