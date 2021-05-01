import java.lang.reflect.Array;

class NativeDictionary<T>
{
		public int size;

		public String[] slots;

		public T[] values;

		public NativeDictionary(int sz, Class clazz)
		{
				size = sz;
				slots = new String[size];
				values = (T[])Array.newInstance(clazz, this.size);
		}

		public int hashFun(String key)
		{
				// всегда возвращает корректный индекс слота
				return (key == null)? 0: key.getBytes().length % slots.length;
		}

		public boolean isKey(String key)
		{
				// возвращает true если ключ имеется,
				// иначе false
				for(String slot : slots)
				{
						if(slot != null && slot.equals(key))
								return true;
				}
				return false;
		}

		public void put(String key, T value)
		{
				// гарантированно записываем
				// значение value по ключу key
				if(get(key) != null)
						for(int i = 0; i < slots.length; i++)
						{
								if(slots[i] != null && slots[i].equals(key))
										values[i] = value;
						}
				else
				{
						int index = seekSlot(key);
						slots[index] = key;
						values[index] = value;
				}
		}

		public int seekSlot(String key)
		{
				// находит индекс пустого слота для значения, или -1
				int defIndex = hashFun(key);
				String val = slots[defIndex];
				if(val != null)
				{
						int newIndex = hashFun(key) + 1;
						while(true)
						{
								if(defIndex == newIndex)
										return -1;
								val = slots[newIndex];
								if(val == null)
										return newIndex;
								newIndex += 1;
								if(newIndex >= slots.length)
										newIndex = 0;
						}
				}
				return defIndex;
		}

		public T get(String key)
		{
				// возвращает value для key,
				// или null если ключ не найден
				for(int i = 0; i < slots.length; i++)
				{
						if(slots[i] != null && slots[i].equals(key))
								return values[i];
				}
				return null;
		}
}
