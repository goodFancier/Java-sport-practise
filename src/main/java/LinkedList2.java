import java.util.ArrayList;

public class LinkedList2
{
		public Nodez head;

		public Nodez tail;

		public LinkedList2()
		{
				head = null;
				tail = null;
		}

		public void addInTail(Nodez _item)
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

		public Nodez find(int _value)
		{
				// здесь будет ваш код поиска
				Nodez node = this.head;
				while(node != null)
				{
						if(node.value == _value)
								return node;
						node = node.next;
				}
				return null;
		}

		public ArrayList<Nodez> findAll(int _value)
		{
				ArrayList<Nodez> nodes = new ArrayList<Nodez>();
				// здесь будет ваш код поиска всех узлов по заданному значению
				Nodez node = this.head;
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
								else
										this.head.prev = null;
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
										this.tail.next = null;
								return true;
						}
						Nodez node = this.head.next;
						Nodez prevNode = this.head;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
										if(prevNode.next == null)
												this.tail = prevNode;
										else
												prevNode.next.prev = prevNode;
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
						Nodez node = head;
						while(node != null)
						{
								if(this.head.value == _value)
								{
										this.head = node.next;
										if(this.head != null)
												this.head.prev = null;
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
						Nodez prevNode = this.head;
						node = this.head.next;
						while(node != null)
						{
								if(node.value == _value)
								{
										prevNode.next = node.next;
										if(prevNode.next != null)
												prevNode.next.prev = prevNode;
								}
								else
								{
										prevNode = node;
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
				this.head = null;
				this.tail = null;
		}

		public int count()
		{
				// здесь будет ваш код подсчёта количества элементов в списке
				int count = 0;
				Nodez node = this.head;
				while(node != null)
				{
						count++;
						node = node.next;
				}
				return count;
		}

		public void insertAfter(Nodez _nodeAfter, Nodez _nodeToInsert)
		{
				// здесь будет ваш код вставки узла после заданного узла
				// если _nodeAfter = null
				// добавьте новый элемент первым в списке
				if(this.head == null)
				{
						this.head = _nodeToInsert;
						this.tail = _nodeToInsert;
						return;
				}
				if(_nodeAfter == null)
				{
						Nodez oldHead = this.head;
						this.head = _nodeToInsert;
						this.head.next = oldHead;
						oldHead.prev = this.head;
						return;
				}
				Nodez node = this.head.next;
				Nodez prevNode = this.head;
				while(prevNode != null)
				{
						if(_nodeAfter.next == prevNode.next && _nodeAfter.value == prevNode.value)
						{
								prevNode.next = _nodeToInsert;
								_nodeToInsert.prev = prevNode;
								_nodeToInsert.next = node;
								if(node != null)
										node.prev = _nodeToInsert;
								else
										this.tail = _nodeToInsert;
								break;
						}
						node = node.next;
						prevNode = prevNode.next;
				}
		}
}

class Nodez
{
		public int value;

		public Nodez next;

		public Nodez prev;

		public Nodez(int _value)
		{
				value = _value;
				next = null;
				prev = null;
		}
}
