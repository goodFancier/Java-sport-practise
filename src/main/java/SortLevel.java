import java.util.*;

public class SortLevel
{
		public static void SelectionSortStep(int array[], int i)
		{
				if (i >= array.length - 1 || i < 0)
						return;
				int min = array[i];
				int resultIndex = i;
				if (i < array.length - 1)
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
				for(int i = 0; i < array.length - 1; i++)
						if(array[i] > array[i + 1])
						{
								int c = array[i];
								array[i] = array[i + 1];
								array[i + 1] = c;
								return false;
						}
				return true;
		}
}