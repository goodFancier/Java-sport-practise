class NativeCache<T>
{
		public int size;

		public String[] slots;

		public T[] values;

		public int[] hits;

		public NativeCache(int size, String[] slots, T[] values, int[] hits)
		{
				this.size = size;
				this.slots = slots;
				this.values = values;
				this.hits = hits;
		}

		public void put(String key, T value)
		{
				if(get(value) != null)
				{
						for(int i = 0; i < slots.length; i++)
						{
								if(slots[i] != null && slots[i].equals(key))
								{
										values[i] = value;
										return;
								}
						}
				}
				int index = seekSlot(key);
				if(index == -1)
						removeUselessElement();
				index = seekSlot(key);
				slots[index] = key;
				values[index] = value;
				size = 0;
				for(String slot : slots)
				{
						if(slot != null)
								size++;
				}
		}

		public int hashFun(String key)
		{
				// всегда возвращает корректный индекс слота
				return (key == null)? 0: key.getBytes().length % slots.length;
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

		private void removeUselessElement()
		{
				int indexOfMin = 0;
				for(int i = 1; i < hits.length; i++)
				{
						if(hits[i] < hits[i - 1])
						{
								indexOfMin = i;
						}
				}
				slots[indexOfMin] = null;
				values[indexOfMin] = null;
				hits[indexOfMin] = 0;
		}

		public T get(T key)
		{
				// возвращает value для key,
				// или null если ключ не найден
				for(int i = 0; i < slots.length; i++)
				{
						if(slots[i] != null && slots[i].equals(key))
						{
								hits[i] = hits[i] + 1;
								return values[i];
						}
				}
				return null;
		}
}
