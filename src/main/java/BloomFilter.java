public class BloomFilter
{
		public int filter_len;

		private int[] bits;

		public BloomFilter(int f_len)
		{
				filter_len = (int)Math.pow(2, f_len);
				bits = new int[filter_len];
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

		public void add(String str1)
		{
				// добавляем строку str1 в фильтр
				int pos = hash1(str1);
				bits[(1 << pos)] = 1;
				int pos2 = hash2(str1);
				bits[(1 << pos2)] = 1;
		}

		public boolean isValue(String str1)
		{
				// проверка, имеется ли строка str1 в фильтре
				int pos = hash1(str1);
				int pos2 = hash2(str1);
				return bits[(1 << pos)] == 1 && bits[(1 << pos2)] == 1;
		}
}
