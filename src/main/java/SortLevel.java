import java.util.*;

public class SortLevel
{
		public static void SelectionSortStep(int array[], int i)
		{
				if(i >= array.length - 1 || i < 0)
						return;
				int min = array[i];
				int resultIndex = i;
				if(i < array.length - 1)
				{
						for(int j = i + 1; j < array.length; j++)
						{
								if(j < array.length - 1)
								{
										if(array[j] < array[j + 1])
										{
												min = array[j];
												resultIndex = j;
										}
								}
								else
										if(array[j] < min)
										{
												min = array[j];
												resultIndex = j;
										}
						}
						if(min < array[i])
						{
								int c = array[i];
								array[i] = min;
								array[resultIndex] = c;
						}
				}
		}

		public static Boolean BubbleSortStep(int array[])
		{
				boolean resultOfSort = true;
				for(int i = 0; i < array.length - 1; i++)
						if(array[i] > array[i + 1])
						{
								int c = array[i];
								array[i] = array[i + 1];
								array[i + 1] = c;
								resultOfSort = false;
						}
				return resultOfSort;
		}

		public static void InsertionSortStep(int[] array, int step, int i)
		{
				int startIndex = i;
				while(i < array.length && step >= 1 && i >= 0)
				{
						if(i + step < array.length)
						{
								if(array[i] > array[i + step])
								{
										int c = array[i];
										array[i] = array[i + step];
										array[i + step] = c;
								}
								if(i - step >= 0 && array[i] < array[i - step])
								{
										i = startIndex;
										continue;
								}
						}
						i += step;
				}
		}

		public static ArrayList<Integer> KnuthSequence(int array_size)
		{
				ArrayList<Integer> stepList = new ArrayList<>();
				stepList.add(1);
				int step = 1;
				while(3 * step + 1 < array_size)
				{
						step = 3 * step + 1;
						stepList.add(0, step);
				}
				return stepList;
		}

		public static int ArrayChunk(int[] M, int left, int right)
		{
				int pivot = M[right];
				int i = (left - 1);
				for(int j = left; j < right; j++)
				{
						if(M[j] <= pivot)
						{
								i++;
								int swapTemp = M[i];
								M[i] = M[j];
								M[j] = swapTemp;
						}
				}
				int swapTemp = M[i + 1];
				M[i + 1] = M[right];
				M[right] = swapTemp;
				return i + 1;
		}

		public static void QuickSort(int[] array, int left, int right)
		{
				if(left < right && left <= array.length - 1 && right <= array.length - 1)
				{
						int N = ArrayChunk(array, left, right); // опорный элемент
						QuickSort(array, left, N - 1);
						QuickSort(array, N + 1, right);
				}
		}

		public static void QuickSortTailOptimization(int[] array, int left, int right)
		{
				while(left < right)
				{
						int N = ArrayChunk(array, left, right); // опорный элемент
						QuickSortTailOptimization(array, left, N - 1);
						left = N + 1;
				}
		}

		public static int ArrayChunkOrderStatistic(int[] M, int left, int right, int pivot)
		{
				int i = left - 1;
				for(int j = left; j <= right; j++)
				{
						if(M[j] <= pivot)
						{
								i++;
								int swapTemp = M[i];
								M[i] = M[j];
								M[j] = swapTemp;
						}
				}
				int swapTemp = M[i + 1];
				M[i + 1] = M[right];
				M[right] = swapTemp;
				return i + 1;
		}

		public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k)
		{
				return partition(Array, 0, Array.length - 1, k);
		}

		public static ArrayList<Integer> partition(int[] Array, int L, int R, int k)
		{
				if (Array.length <= 0 || k >= Array.length)
						return new ArrayList<>();
				ArrayList<Integer> resultList = new ArrayList<>();
				int N = ArrayChunkOrderStatistic(Array, L, R, (R+L)/2); // индекс опорного элемента
				if(N == k)
				{
						resultList.add(L);
						resultList.add(R);
						return resultList;
				}
				else
						if(N < k)
						{
								L = N + 1;
								return partition(Array, L, R, k);
						}
						else
						{
								R = N - 1;
								return partition(Array, L, R, k);
						}
		}
}
