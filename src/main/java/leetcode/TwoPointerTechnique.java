package leetcode;

import java.util.*;

public class TwoPointerTechnique
{
		protected class ListNode
		{
				private ListNode next;

				private ListNode tail;

				private ListNode head;

				private int value;

				public ListNode(int value)
				{
						this.value = value;
				}

				public int getValue()
				{
						return value;
				}

				public ListNode getNext()
				{
						return next;
				}

				public void setNext(ListNode next)
				{
						this.next = next;
				}
		}

		ListNode head;

		ListNode tail;

		List<ListNode> linkedList;

		public TwoPointerTechnique()
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
				TwoPointerTechnique.ListNode node = new TwoPointerTechnique.ListNode(val);
				if(linkedList.isEmpty())
				{
						linkedList.add(node);
						tail = node;
				}
				else
				{
						node.next = head;
						addAtIndex(0, val);
				}
				head = node;
		}

		public void addAtTail(int val)
		{
				TwoPointerTechnique.ListNode node = new TwoPointerTechnique.ListNode(val);
				if(head == null)
						head = node;
				linkedList.add(node);
				if(tail != null)
						tail.next = node;
				tail = node;
		}

		public void addAtIndex(int index, int val)
		{
				if(index > linkedList.size())
						return;
				TwoPointerTechnique.ListNode node = new TwoPointerTechnique.ListNode(val);
				if(head == null)
				{
						head = node;
						tail = node;
						linkedList.add(node);
				}
				else
						if(index == 0)
						{
								node.next = head;
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

		public boolean hasCycle(ListNode head)
		{
				if (head == null)
						return false;
				Set<ListNode> nodeSet = new HashSet<>();
				nodeSet.add(head);
				ListNode currentNode = head.next;
				while(currentNode != null)
				{
						if(nodeSet.contains(currentNode))
								return true;
						else
								nodeSet.add(currentNode);
						currentNode = currentNode.next;
				}
				return false;
		}
}
