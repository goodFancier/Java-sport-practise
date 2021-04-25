public class HashTable
{
		public int size;

		public int step;

		public String[] slots;

		public HashTable(int sz, int stp)
		{
				size = sz;
				step = stp;
				slots = new String[size];
				for(int i = 0; i < size; i++)
						slots[i] = null;
		}

		public int hashFun(String value)
		{
				// всегда возвращает корректный индекс слота
				return (value == null)? 0: value.getBytes().length % slots.length;
		}

		public int seekSlot(String value)
		{
				// находит индекс пустого слота для значения, или -1
				int defIndex = hashFun(value);
				String val = slots[defIndex];
				if(val != null)
				{
						int newIndex = hashFun(value) + step;
						for(int i = 0; i < slots.length; i++)
						{
								if(defIndex == newIndex)
										return -1;
								val = slots[newIndex];
								if(val == null)
										return newIndex;
								newIndex += step;
								if(newIndex >= slots.length)
										newIndex = newIndex - slots.length;
						}
				}
				return defIndex;
		}

		public int put(String value)
		{
				// записываем значение по хэш-функции
				// возвращается индекс слота или -1
				// если из-за коллизий элемент не удаётся разместить
				int index = seekSlot(value);
				if(index != -1)
				{
						slots[index] = value;
				}
				return index;
		}

		public int find(String value)
		{
				// находит индекс слота со значением, или -1
				int defIndex = hashFun(value);
				String val = slots[defIndex];
				if(!value.equals(val))
				{
						int newIndex = defIndex + step;
						for(int i = 0; i < slots.length; i++)
						{
								if(defIndex == newIndex)
										return -1;
								val = slots[newIndex];
								if(val.equals(value))
										return newIndex;
								newIndex += step;
								if(newIndex >= slots.length)
										newIndex = newIndex - slots.length;
						}
				}
				return defIndex;
		}
}
