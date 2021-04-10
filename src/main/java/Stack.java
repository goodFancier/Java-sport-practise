import java.util.*;

public class Stack<T>
{
		List<T> stack;

		public Stack()
		{
				// инициализация внутреннего хранилища стека
				stack = new ArrayList<>();
		}

		public int size()
		{
				// размер текущего стека
				return stack.size();
		}

		public T pop()
		{
				// ваш код
				if(stack.size() > 0)
				{
						T lastElement = stack.get(stack.size() - 1);
						stack.remove(lastElement);
						return lastElement;
				}
				else
						return null;  // если стек пустой
		}

		public void push(T val)
		{
				// ваш код
				stack.add(val);
		}

		public T peek()
		{
				// ваш код
				return stack.size() > 0? stack.get(stack.size() - 1): null; // если стек пустой
		}
}
