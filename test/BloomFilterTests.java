import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BloomFilterTests
{
		@Test
		public void testAddInBloomFilter()
		{
				BloomFilter bloomFilter = new BloomFilter(32);
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
		}
}
