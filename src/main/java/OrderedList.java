import java.util.*;

class Node<T>
{
		public T value;

		public Node<T> next, prev;

		public Node(T _value)
		{
				value = _value;
				next = null;
				prev = null;
		}
}

public class OrderedList<T>
{
		public Node<T> head, tail;

		private boolean _ascending;

		public OrderedList(boolean asc)
		{
				head = null;
				tail = null;
				_ascending = asc;
		}

		public int compare(T v1, T v2)
		{
				if(v1 instanceof Integer)
						return Integer.compare((Integer)v1, (Integer)v2);
				else
						if(v1 instanceof Long)
								return Long.compare((Long)v1, (Long)v2);
						else
								if(v1 instanceof Double)
										return Double.compare((Double)v1, (Double)v2);
								else
										if(v1 instanceof Float)
												return Float.compare((Float)v1, (Float)v2);
										else
												if(v1 instanceof Byte)
														return Float.compare((Byte)v1, (Byte)v2);
												else
														if(v1 instanceof Short)
																return Float.compare((Short)v1, (Short)v2);
														else
																return ((String)v1).trim().compareTo(((String)v2).trim());
				// -1 если v1 < v2
				// 0 если v1 == v2
				// +1 если v1 > v2
		}

		public void add(T value)
		{
				// автоматическая вставка value
				// в нужную позицию
				Node<T> node = tail;
				Node<T> newNode = new Node<>(value);
				if(node == null)
				{
						head = newNode;
						tail = newNode;
				}
				else
				{
						if(compare(value, node.value) < 0)
						{
								node = head;
								if(compare(value, head.value) < 0)
								{
										node.prev = newNode;
										head = newNode;
										head.next = node;
										return;
								}
								else
										while(node.next != null)
										{
												Node<T> nextNode = node.next;
												if(compare(value, node.value) >= 0 && compare(value, node.next.value) < 1)
												{
														node.next = newNode;
														nextNode.prev = newNode;
														newNode.next = nextNode;
														newNode.prev = node;
														return;
												}
												node = node.next;
										}
						}
						node.next = newNode;
						newNode.prev = node;
						this.tail = newNode;
				}
		}

		public Node<T> find(T val)
		{
				// здесь будет ваш код
				Node<T> node = head;
				while(node != null)
				{
						if(node.value == val)
								return node;
						node = node.next;
				}
				return null;
		}

		public void delete(T val)
		{
				// здесь будет ваш код
				if(this.head == null)
						return;
				if(this.head.value == val)
				{
						this.head = this.head.next;
						if(this.head == null)
								this.tail = null;
						else
								this.head.prev = null;
						return;
				}
				if(this.tail.value == val)
				{
						this.tail = this.tail.prev;
						if(this.tail == null)
						{
								this.head = null;
						}
						else
								this.tail.next = null;
						return;
				}
				Node node = this.head.next;
				Node prevNode = this.head;
				while(node != null)
				{
						if(node.value == val)
						{
								prevNode.next = node.next;
								if(prevNode.next == null)
										this.tail = prevNode;
								else
										prevNode.next.prev = prevNode;
								return;
						}
						prevNode = node;
						node = node.next;
				}
		}

		public void clear(boolean asc)
		{
				_ascending = asc;
				// здесь будет ваш код
				this.head = null;
				this.tail = null;
		}

		public int count()
		{
				int count = 0;
				Node<T> node = head;
				while(node != null)
				{
						count++;
						node = node.next;
				}
				return count; // здесь будет ваш код подсчёта количества элементов в списке
		}

		ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
		// списка в виде стандартного списка
		{
				ArrayList<Node<T>> r = new ArrayList<>();
				Node<T> node = head;
				while(node != null)
				{
						r.add(node);
						node = node.next;
				}
				return r;
		}
}
