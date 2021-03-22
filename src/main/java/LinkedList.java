import java.util.*;

public class LinkedList
{
		public LinkedListNode head;

		public LinkedListNode tail;

		public LinkedList()
		{
				head = null;
				tail = null;
		}

		public void addInTail(LinkedListNode item)
		{
				if(this.head == null)
						this.head = item;
				else
						this.tail.next = item;
				this.tail = item;
		}

		public LinkedListNode find(int value)
		{
				LinkedListNode node = this.head;
				while(node != null)
				{
						if(node.value == value)
								return node;
						node = node.next;
				}
				return null;
		}

		public ArrayList<LinkedListNode> findAll(int _value)
		{
				// здесь будет ваш код поиска всех узлов
				ArrayList<LinkedListNode> nodes = new ArrayList<>();
				LinkedListNode node = this.head;
				while(node != null)
				{
						if(node.value == _value)
								nodes.add(node);
						node = node.next;
				}
				return nodes;
		}

		public boolean remove(int _value)
		{
				// здесь будет ваш код удаления одного узла по заданному значению
				if(this.head == null)
						return true;
				else
				{
						if(this.head.value == _value)
						{
								this.head = this.head.next;
								if(this.head == null)
										this.tail = null;
								return true;
						}
						LinkedListNode node = this.head.next;
						LinkedListNode prevNode = this.head;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
										if(prevNode.next == null)
												this.tail = prevNode;
										node = null;
										return true;
								}
								prevNode = node;
								node = node.next;
						}
						return true; // если узел был удалён
				}
		}

		public void removeAll(int _value)
		{
				// здесь будет ваш код удаления всех узлов по заданному значению
				if(this.head != null)
				{
						LinkedListNode node = head;
						while(node != null)
						{
								if(this.head.value == _value)
								{
										this.head = this.head.next;
								}
								else
										break;
								node = node.next;
						}
						if(this.head == null)
						{
								this.tail = null;
								return;
						}
						LinkedListNode prevNode = this.head;
						node = this.head.next;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
								}
								else
								{
										prevNode = prevNode.next;
								}
								node = node.next;
								if(prevNode.next == null)
										tail = prevNode;
								else
										tail = node;
						}
				}
		}

		public void clear()
		{
				// здесь будет ваш код очистки всего списка
				LinkedListNode node = this.head;
				while(node != null)
				{
						while(node.next != null)
						{
								node.next = node.next.next;
						}
						node = null;
						this.head = null;
						this.tail = null;
				}
		}

		public int count()
		{
				// здесь будет ваш код подсчёта количества элементов в списке
				int count = 0;
				LinkedListNode node = this.head;
				while(node != null)
				{
						count++;
						node = node.next;
				}
				return count;
		}

		public void insertAfter(LinkedListNode _nodeAfter, LinkedListNode _nodeToInsert)
		{
				// здесь будет ваш код вставки узла после заданного
				// если _nodeAfter = null ,
				// добавьте новый элемент первым в списке
				if(this.head == null)
				{
						this.head = _nodeToInsert;
						this.tail = _nodeToInsert;
						return;
				}
				if(_nodeAfter == null)
				{
						LinkedListNode oldHead = this.head;
						this.head = _nodeToInsert;
						this.head.next = oldHead;
						return;
				}
				LinkedListNode node = this.head.next;
				LinkedListNode prevNode = this.head;
				while(prevNode != null)
				{
						if(_nodeAfter.next == prevNode.next && _nodeAfter.value == prevNode.value)
						{
								prevNode.next = _nodeToInsert;
								_nodeToInsert.next = node;
								if(node == null)
										this.tail = _nodeToInsert;
								break;
						}
						node = node.next;
						prevNode = prevNode.next;
				}
		}
}

class LinkedListNode
{
		public int value;

		public LinkedListNode next;

		public LinkedListNode(int _value)
		{
				value = _value;
				next = null;
		}

		public int getValue()
		{
				return value;
		}

		public void setValue(int value)
		{
				this.value = value;
		}

		public LinkedListNode getNext()
		{
				return next;
		}

		public void setNext(LinkedListNode next)
		{
				this.next = next;
		}
}


