import java.util.*;

class Heap
{
		public int[] HeapArray; // хранит неотрицательные числа-ключи

		public Heap()
		{
				HeapArray = null;
		}

		int depth;

		public void MakeHeap(int[] a, int depth)
		{
				// создаём массив кучи HeapArray из заданного
				// размер массива выбираем на основе глубины depth
				// ...
				this.depth = depth;
				int tree_size = 0;
				for(int i = 0; i <= depth; i++)
						tree_size += (int)Math.pow(2, i);
				HeapArray = new int[tree_size];
				HeapArray[0] = a[0];
				System.arraycopy(a, 1, HeapArray, 1, a.length - 1);
				for(int j = 0; j < HeapArray.length; j++)
						for(int i = 0; i < HeapArray.length - 1; i++)
						{
								if(HeapArray[i] < HeapArray[i + 1])
								{
										int tmp = HeapArray[i];
										HeapArray[i] = HeapArray[i + 1];
										HeapArray[i + 1] = tmp;
								}
						}
		}

		private int[] siftHeapToUp(int[] existsHeap, int newElement, int newElementIndex)
		{
				if(existsHeap[newElementIndex - 1] < newElement)
				{
						int tmp = existsHeap[newElementIndex - 1];
						existsHeap[newElementIndex - 1] = newElement;
						existsHeap[newElementIndex] = tmp;
						if(newElementIndex - 1 > 0)
								siftHeapToUp(existsHeap, newElement, newElementIndex - 1);
				}
				return existsHeap;
		}

		public int GetMax()
		{
				// вернуть значение корня и перестроить кучу
				if(HeapArray.length <= 0)
						return -1; // если куча пуста
				int Root = HeapArray[0];
				HeapArray[0] = HeapArray[HeapArray.length - 1];
				HeapArray[HeapArray.length - 1] = 0;
				MakeHeap(HeapArray, depth);
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
				int emptyIndex = getEmptyIndex();
				if(emptyIndex == -1)
						return false; // если куча вся заполнена
				HeapArray[emptyIndex] = key;
				siftHeapToUp(HeapArray, key, emptyIndex);
				return true;
		}
}