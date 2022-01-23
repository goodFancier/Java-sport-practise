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
				while (3 * step + 1 < array_size)
				{
						step = 3 * step + 1;
						stepList.add(0, step);
				}
				return stepList;
		}
}