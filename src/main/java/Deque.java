import java.util.*;

public class Deque<T>
{
		private List<T> deque;

		public Deque()
		{
				// инициализация внутреннего хранилища
				deque = new ArrayList<>();
		}

		public void addFront(T item)
		{
				// добавление в голову
				deque.add(0, item);
		}

		public void addTail(T item)
		{
				// добавление в хвост
				deque.add(item);
		}

		public T removeFront()
		{
				// удаление из головы
				if(deque.size() > 0)
				{
						T firstElement = deque.get(0);
						deque.remove(0);
						return firstElement;
				}
				else
						return null;
		}

		public T removeTail()
		{
				// удаление из хвоста
				if(deque.size() > 0)
				{
						T lastElement = deque.get(deque.size() - 1);
						deque.remove(deque.size() - 1);
						return lastElement;
				}
				else
						return null;
		}

		public int size()
		{
				return deque.size(); // размер очереди
		}
}
