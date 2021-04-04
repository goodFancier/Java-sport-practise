import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T>
{
		public T[] array;

		public int count;

		public int capacity;

		Class clazz;

		public DynArray(Class clz)
		{
				clazz = clz; // нужен для безопасного приведения типов
				// new DynArray<Integer>(Integer.class);
				count = 0;
				makeArray(16);
		}

		public void makeArray(int new_capacity)
		{
				// ваш код
				T[] oldArray = array;
				array = (T[])Array.newInstance(this.clazz, new_capacity);
				capacity = Math.max(new_capacity, 16);
				if(oldArray != null)
						array = Arrays.copyOf(
							oldArray,
							capacity);
		}

		public T getItem(int index)
		{
				// ваш код
				if(index >= count)
						throw new IndexOutOfBoundsException();
				return array[index];
		}

		public void append(T itm)
		{
				// ваш код
				if(count >= capacity)
				{
						makeArray(capacity * 2);
				}
				array[count] = itm;
				count++;
		}

		public void insert(T itm, int index)
		{
				// ваш код
				if(count >= capacity)
				{
						makeArray(capacity * 2);
				}
				if(index >= capacity)
				{
						throw new IndexOutOfBoundsException();
				}
				if(index == count)
						array[count] = itm;
				else
				{
						System.arraycopy(array, index, array, index + 1, count);
						array[index] = itm;
				}
				count++;
		}

		public void remove(int index)
		{
				// ваш код
				if(count > index)
				{
						System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
						count--;
						if(count * 100 / capacity < 50)
								makeArray((int)(capacity / 1.5));
				}
				else
				{
						throw new IndexOutOfBoundsException();
				}
		}
}
