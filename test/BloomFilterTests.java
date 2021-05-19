import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloomFilterTests
{
		@Test
		public void testAddInBloomFilter()
		{
				BloomFilter bloomFilter = new BloomFilter(10);
				bloomFilter.add("0123456789");
				bloomFilter.add("1234567890");
				bloomFilter.add("2345678901");
				bloomFilter.add("3456789012");
				bloomFilter.add("4567890123");
				bloomFilter.add("5678901234");
				bloomFilter.add("6789012345");
				bloomFilter.add("7890123456");
				bloomFilter.add("8901234567");
				bloomFilter.add("9012345678");
				assertTrue(bloomFilter.isValue("7890123456"));
				assertTrue(bloomFilter.isValue("5678901234"));
				assertTrue(bloomFilter.isValue("6789012345"));
				assertTrue(bloomFilter.isValue("3456789012"));
				assertTrue(bloomFilter.isValue("0123456789"));
				assertTrue(bloomFilter.isValue("9012345678"));
				bloomFilter = new BloomFilter(10);
				bloomFilter.add("1");
				bloomFilter.add("2");
				bloomFilter.add("3");
				bloomFilter.add("20");
				bloomFilter.add("3323");
				bloomFilter.add("444");
				bloomFilter.add("333");
				bloomFilter.add("22222");
				bloomFilter.add("111");
				bloomFilter.add("4421");
				assertFalse(bloomFilter.isValue("7890123456"));
				assertFalse(bloomFilter.isValue("5678901234"));
				assertFalse(bloomFilter.isValue("6789012345"));
				assertFalse(bloomFilter.isValue("3456789012"));
				assertFalse(bloomFilter.isValue("0123456789"));
				assertFalse(bloomFilter.isValue("9012345678"));
		}
}
