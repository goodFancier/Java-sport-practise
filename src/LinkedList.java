import java.util.*;

public class LinkedList
{
		public Node head;

		public Node tail;

		public LinkedList()
		{
				head = null;
				tail = null;
		}

		public void addInTail(Node item)
		{
				if(this.head == null)
						this.head = item;
				else
						this.tail.next = item;
				this.tail = item;
		}

		public Node find(int value)
		{
				Node node = this.head;
				while(node != null)
				{
						if(node.value == value)
								return node;
						node = node.next;
				}
				return null;
		}

		public ArrayList<Node> findAll(int _value)
		{
				// здесь будет ваш код поиска всех узлов
				ArrayList<Node> nodes = new ArrayList<>();
				Node node = this.head;
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
								return true;
						}
						Node node = this.head.next;
						Node prevNode = this.head;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
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
						if(this.head.value == _value)
						{
								this.head = this.head.next;
						}
						Node node = this.head.next;
						Node prevNode = this.head;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
								}
								else
										prevNode = node;
								if(node.next == null)
										tail = prevNode;
								node = node.next;
						}
				}
		}

		public void clear()
		{
				// здесь будет ваш код очистки всего списка
				Node node = this.head;
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
				Node node = this.head;
				while(node != null)
				{
						count++;
						node = node.next;
				}
				return count;
		}

		public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
		{
				// здесь будет ваш код вставки узла после заданного
				// если _nodeAfter = null ,
				// добавьте новый элемент первым в списке
				if(this.head == null)
				{
						this.head = _nodeToInsert;
						return;
				}
				if(_nodeAfter == null)
				{
						Node oldHead = this.head;
						this.head = _nodeToInsert;
						this.head.next = oldHead;
						return;
				}
				Node node = this.head.next;
				Node prevNode = this.head;
				while(prevNode != null)
				{
						if(_nodeAfter.next == prevNode.next && _nodeAfter.value == prevNode.value)
						{
								prevNode.next = _nodeToInsert;
								_nodeToInsert.next = node;
								if (node == null)
										this.tail = _nodeToInsert;
								break;
						}
						node = node.next;
						prevNode = prevNode.next;
				}
		}
}

class Node
{
		public int value;

		public Node next;

		public Node(int _value)
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

		public Node getNext()
		{
				return next;
		}

		public void setNext(Node next)
		{
				this.next = next;
		}
}


