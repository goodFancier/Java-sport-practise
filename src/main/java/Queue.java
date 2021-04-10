import java.util.*;

public class Queue<T>
{
		List<T> queue;

		public Queue()
		{
				// инициализация внутреннего хранилища очереди
				queue = new ArrayList<>();
		}

		public void enqueue(T item)
		{
				// вставка в хвост
				queue.add(0, item);
		}

		public T dequeue()
		{
				// выдача из головы
				if(queue.size() > 0)
				{
						T firstElement = queue.get(queue.size() - 1);
						queue.remove(firstElement);
						return firstElement;
				}
				else
						return null; // null если очередь пустая
		}

		public int size()
		{
				return queue.size(); // размер очереди
		}
}
