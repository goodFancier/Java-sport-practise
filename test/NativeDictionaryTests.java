import org.junit.Test;

import static org.junit.Assert.*;

public class NativeDictionaryTests
{
		@Test
		public void testPutAndGetElements()
		{
				NativeDictionary<String> nativeDictionary = new NativeDictionary<>(16, String.class);
				nativeDictionary.put("1", "hello");
				nativeDictionary.put("2", "bye");
				nativeDictionary.put("3", "good evening");
				nativeDictionary.put("2", "it is not bye!");
				nativeDictionary.put("4", "4");
				nativeDictionary.put("5", "5");
				nativeDictionary.put("6", "6");
				nativeDictionary.put("7", "7");
				nativeDictionary.put("8", "8");
				nativeDictionary.put("9", "9");
				nativeDictionary.put("10", "10!");
				nativeDictionary.put("11", "11");
				nativeDictionary.put("12", "12");
				nativeDictionary.put("13", "13");
				nativeDictionary.put("14", "14");
				nativeDictionary.put("15", "15");
				nativeDictionary.put("16", "16");
				assertEquals(nativeDictionary.get("1"), "hello");
				assertEquals(nativeDictionary.get("2"), "it is not bye!");
				assertEquals(nativeDictionary.get("3"), "good evening");
				assertEquals(nativeDictionary.get("4"), "4");
		}

		@Test
		public void testIsKey()
		{
				NativeDictionary<String> nativeDictionary = new NativeDictionary<>(16, String.class);
				nativeDictionary.put("1", "hello");
				nativeDictionary.put("2", "bye");
				nativeDictionary.put("3", "good evening");
				assertTrue(nativeDictionary.isKey("3"));
				assertFalse(nativeDictionary.isKey("4"));
		}
}
