import java.util.ArrayList;
import java.util.List;

public class BloomFilter
{
		public int filter_len;

		private List<Integer> byteList;

		public BloomFilter(int f_len)
		{
				filter_len = f_len;
				// создаём битовый массив длиной f_len ...
				byteList = new ArrayList<>();
				for(int i = 0; i < filter_len; i++)
				{
						byteList.add(0);
				}
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
				// реализация ...
		}

		public int hash2(String str1)
		{
				// 223
				// реализация ...
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
				byteList.set(hash1(str1), 1);
				byteList.set(hash2(str1), 1);
		}

		public boolean isValue(String str1)
		{
				// проверка, имеется ли строка str1 в фильтре
				return byteList.get(hash1(str1)) == 1 && byteList.get(hash2(str1)) == 1;
		}
}
