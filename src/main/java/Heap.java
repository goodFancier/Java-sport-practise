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
				for(int i = 1; i < a.length; i++)
				{
						if(a[i] > HeapArray[i - 1])
						{
								HeapArray = siftHeapToUp(HeapArray, a[i], i);
						}
						else
								HeapArray[i] = a[i];
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

		public boolean Add(int key)
		{
				// добавляем новый элемент key в кучу и перестраиваем её
				return false; // если куча вся заполнена
		}
}