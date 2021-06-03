import org.junit.Test;

public class NativeCacheTests
{
		@Test
		public void testPutInNativeCache()
		{
				String[] slots = new String[5];
				slots[0] = "0";
			/*	slots[1] = "1";
				slots[2] = "2";
				slots[3] = "3";
				slots[4] = "4";*/
				String[] values = new String[5];
				values[0] = "0";
			/*	values[1] = "1";
				values[2] = "2";
				values[3] = "3";
				values[4] = "4";*/
				int[] hits = new int[5];
				hits[0] = 1;
			/*	hits[1] = 1;
				hits[2] = 0;
				hits[3] = 1;
				hits[4] = 1;*/
				NativeCache<String> nativeCache = new NativeCache<>(slots.length, slots, values, hits);
				nativeCache.put("10", "10");
				System.out.println(nativeCache);
		}
}
