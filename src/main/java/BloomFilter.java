public class BloomFilter
{
		public int filter_len;

		private int bitArray;


		public BloomFilter(int f_len)
		{
				filter_len = f_len;
				bitArray = 0;
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
				bitArray = bitArray | hash1(key);
				bitArray = bitArray | hash2(key);
		}

		public boolean isValue(String str1)
		{
				// проверка, имеется ли строка str1 в фильтре
				return (bitArray & hash1(str1)) > 0 && (bitArray & hash2(str1)) > 0;
		}
}
