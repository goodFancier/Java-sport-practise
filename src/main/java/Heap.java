import java.util.*;

class Heap
{
		public int[] HeapArray; // хранит неотрицательные числа-ключи

		public Heap()
		{
				HeapArray = null;
		}

		int depth;

		private int currentSize;

		public int getCurrentSize()
		{
				return currentSize;
		}

		public void MakeHeap(int[] a, int depth)
		{
				// создаём массив кучи HeapArray из заданного
				// размер массива выбираем на основе глубины depth
				// ...
				this.depth = depth;
				this.currentSize = 0;
				int tree_size = 0;
				for(int i = 0; i <= depth; i++)
						tree_size += (int)Math.pow(2, i);
				HeapArray = new int[tree_size];
				//	nodeList = new Node[tree_size];
				for(int value : a)
				{
						Add(value);
				}
		}

		private void displaceUp(int index)
		{
				int parentIndex = (index - 1) / 2;
				int bottom = HeapArray[index];
				while(index > 0 && HeapArray[parentIndex] < bottom)
				{
						HeapArray[index] = HeapArray[parentIndex];
						index = parentIndex;
						parentIndex = (parentIndex - 1) / 2;
				}
				HeapArray[index] = bottom;
		}

		private void displaceDown()
		{
				int index = 0;
				int largerChild;
				int top = HeapArray[0];
				while(index < currentSize / 2)
				{
						int leftChild = 2 * index + 1;
						int rightChild = leftChild + 1;
						if(rightChild < currentSize && HeapArray[leftChild] < HeapArray[rightChild])
						{
								largerChild = rightChild;
						}
						else
						{
								largerChild = leftChild;
						}
						if(top >= HeapArray[largerChild])
						{
								break;
						}
						HeapArray[index] = HeapArray[largerChild];
						index = largerChild;
				}
				HeapArray[index] = top;
		}

		public int GetMax()
		{
				// вернуть значение корня и перестроить кучу
				if(HeapArray.length <= 0)
						return -1; // если куча пуста
				int Root = HeapArray[0];
				HeapArray[0] = HeapArray[HeapArray.length - 1];
				HeapArray[HeapArray.length - 1] = 0;
				displaceDown();
				return Root;
		}

		private int getEmptyIndex()
		{
				for(int i = 0; i < HeapArray.length; i++)
						if(HeapArray[i] == 0)
								return i;
				return -1;
		}

		public boolean Add(int key)
		{
				// добавляем новый элемент key в кучу и перестраиваем её
				if(key < 0 || currentSize >= HeapArray.length)
						return false;
				int emptyIndex = getEmptyIndex();
				if(emptyIndex == -1)
						return false; // если куча вся заполнена
				HeapArray[emptyIndex] = key;
				displaceUp(currentSize++);
				return true;
		}
}