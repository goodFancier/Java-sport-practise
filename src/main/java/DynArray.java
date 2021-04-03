import java.lang.reflect.Array;

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
				array = (T[])Array.newInstance(this.clazz, new_capacity);
				capacity = new_capacity;
				// ваш код
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
				if(index == count)
						array[count] = itm;
				else
				{
						for(int i = 0; i < array.length; i++)
						{
								if(i == index)
								{
										T oldItem = array[i];
										array[i] = itm;
										i++;
										T nextItem;
										while(i < array.length)
										{
												nextItem = array[i];
												if(oldItem == null)
														return;
												array[i] = oldItem;
												oldItem = nextItem;
												i++;
										}
								}
						}
				}
				count++;
		}

		public void remove(int index)
		{
				// ваш код
		}
}
