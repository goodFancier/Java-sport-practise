import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BloomFilter
{
		public int filter_len;

		private final int[] bits;

		public BloomFilter(int f_len)
		{
				filter_len = f_len;
				bits = new int[filter_len];
				Arrays.fill(bits, 0);
		}

		// хэш-функции
		public int hash1(String str1)
		{
				// 17
				int prevResult = 0;
				if(str1.isEmpty())
						return prevResult;
				for(int i = 0; i < str1.length(); i++)
				{
						int code = str1.charAt(i);
						prevResult = (prevResult * 17 + code) % str1.length();
				}
				return prevResult;
		}

		public int hash2(String str1)
		{
				// 223
				int prevResult = 0;
				if(str1.isEmpty())
						return prevResult;
				for(int i = 0; i < str1.length(); i++)
				{
						int code = str1.charAt(i);
						prevResult = (prevResult * 223 + code) % str1.length();
				}
				return prevResult;
		}

		public void add(String key)
		{
				int bit = hash1(key); // получили
				int foundBit = bit << 5;
				for(int index : getPositiveIndexList(foundBit))
				{
						bits[index] = 1;
				}
				bit = hash2(key);
				int foundBit2 = bit << 5;
				for(int index : getPositiveIndexList(foundBit2))
				{
						bits[index] = 1;
				}
		}

		public List<Integer> getPositiveIndexList(int foundBit)
		{
				List<Integer> positiveIndexList = new ArrayList<>();
				String binaryString = Integer.toBinaryString(foundBit);
				for (int i = 0; i < binaryString.toCharArray().length; i++)
				{
						if (binaryString.charAt(i) == 49)
								positiveIndexList.add(binaryString.toCharArray().length - i - 1);
				}
				return positiveIndexList;
		}

		public boolean isValue(String str1)
		{
				// проверка, имеется ли строка str1 в фильтре
				int bit = hash1(str1);
				int foundBit1 = bit << 5;
				for (int index : getPositiveIndexList(foundBit1))
				{
						if (bits[index] != 1)
								return false;
				}
				bit = hash2(str1);
				int foundBit2 = bit << 5;
				for (int index : getPositiveIndexList(foundBit2))
				{
						if (bits[index] != 1)
								return false;
				}
				return true;
		}
}
