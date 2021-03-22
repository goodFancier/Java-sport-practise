import java.util.ArrayList;

public class LinkedList2
{
		public Node head;

		public Node tail;

		public LinkedList2()
		{
				head = null;
				tail = null;
		}

		public void addInTail(Node _item)
		{
				if(head == null)
				{
						this.head = _item;
						this.head.next = null;
						this.head.prev = null;
				}
				else
				{
						this.tail.next = _item;
						_item.prev = tail;
				}
				this.tail = _item;
		}

		public Node find(int _value)
		{
				// здесь будет ваш код поиска
				Node node = this.head;
				while(node != null)
				{
						if(node.value == _value)
								return node;
						node = node.next;
				}
				return null;
		}

		public ArrayList<Node> findAll(int _value)
		{
				ArrayList<Node> nodes = new ArrayList<Node>();
				// здесь будет ваш код поиска всех узлов по заданному значению
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
								if(this.head == null)
										this.tail = null;
								return true;
						}
						if(this.tail.value == _value)
						{
								this.tail = this.tail.prev;
								if(this.tail == null)
								{
										this.head = null;
								}
								else
										if(this.tail == head)
										{
												this.head.next = null;
												this.head.prev = null;
										}
								return true;
						}
						Node node = this.head.next;
						while(node != null)
						{
								if(node.value == _value)
								{
										node.prev.next = node.next;
										if(node.prev.next == null)
												this.tail = node.prev;
										node = null;
										return true;
								}
								node.prev = node;
								node = node.next;
						}
						return true; // если узел был удалён
				}
		}

		public void removeAll(int _value)
		{
				// здесь будет ваш код удаления всех узлов по заданному значению
		}

		public void clear()
		{
				// здесь будет ваш код очистки всего списка
		}

		public int count()
		{
				return 0; // здесь будет ваш код подсчёта количества элементов в списке
		}

		public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
		{
				// здесь будет ваш код вставки узла после заданного узла
				// если _nodeAfter = null
				// добавьте новый элемент первым в списке
		}
}

class Node
{
		public int value;

		public Node next;

		public Node prev;

		public Node(int _value)
		{
				value = _value;
				next = null;
				prev = null;
		}
}
