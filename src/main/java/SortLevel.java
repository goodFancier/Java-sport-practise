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

		public static int ArrayChunk(int[] M)
		{
				int supportElement = M[M.length / 2];
				int supportIdx = M.length / 2;
				int i1 = 0;
				int i2 = M.length - 1;
				return chunkArrayRecursion(M, i1, i2, supportElement, supportIdx);
		}

		private static int chunkArrayRecursion(int[] M, int i1, int i2, int supportElement, int supportIdx)
		{
				while(M[i1] < supportElement)
						i1++;
				while(M[i2] > supportElement)
						i2--;
				if(i1 == i2 - 1 && M[i1] > M[i2])
				{
						int c = M[i1];
						M[i1] = M[i2];
						M[i2] = c;
						return ArrayChunk(M);
				}
				else
						if(i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2]))
								return supportIdx;
						else
						{
								if(i1 == supportIdx)
								{
										int c = supportElement;
										supportElement = M[i1];
										M[i1] = c;
								}
								if(i2 == supportIdx)
								{
										int c = supportElement;
										supportElement = M[i2];
										M[i2] = c;
								}
								int c = M[i1];
								M[i1] = M[i2];
								M[i2] = c;
								return chunkArrayRecursion(M, i1, i2, supportElement, supportIdx);
						}
		}
}