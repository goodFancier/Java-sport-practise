import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTableTests
{
		@Test
		public void testPutValue()
		{
				HashTable hashTable = new HashTable(17, 1);
				hashTable.put("come1");
				hashTable.put("come2");
				hashTable.put("come3");
				hashTable.put("come4");
				hashTable.put("come5");
				hashTable.put("come6");
				hashTable.put("come7");
				hashTable.put("come8");
				hashTable.put("come9");
				hashTable.put("come10");
				hashTable.put("come11");
				hashTable.put("come12");
				hashTable.put("come13");
				hashTable.put("come14");
				hashTable.put("come15");
				hashTable.put("come16");
				hashTable.put("come17");
				hashTable.put("come18");
				System.out.println(hashTable.size);
		}

		@Test
		public void testFindValue()
		{
				HashTable hashTable = new HashTable(17, 1);
				hashTable.find("come1");
				int index = hashTable.put("come2");
				assertEquals(index, hashTable.find("come2"));
				index = hashTable.put("come3");
				assertEquals(index, hashTable.find("come3"));
				index = hashTable.put("come4");
				assertEquals(index, hashTable.find("come4"));
		}

		@Test
		public void testFindValueInEmptyTable()
		{
				HashTable hashTable = new HashTable(17, 1);
				int index = hashTable.find("kitty slow");
				assertEquals(index, -1);
		}

		@Test
		public void testFindNotExistsValue()
		{
				HashTable hashTable = new HashTable(17, 1);
				hashTable.put("come1");
				hashTable.put("come2");
				hashTable.put("come3");
				int index = hashTable.find("come4");
				assertEquals(index, -1);
		}

		@Test
		public void testFindValueInFullTable()
		{
				HashTable hashTable = new HashTable(17, 1);
				hashTable.put("come1");
				hashTable.put("come2");
				hashTable.put("come3");
				hashTable.put("come4");
				hashTable.put("come5");
				hashTable.put("come6");
				hashTable.put("come7");
				hashTable.put("come8");
				hashTable.put("come9");
				hashTable.put("come10");
				hashTable.put("come11");
				hashTable.put("come12");
				hashTable.put("come13");
				hashTable.put("come14");
				hashTable.put("come15");
				hashTable.put("come16");
				hashTable.put("come17");
				hashTable.put("come18");
				int index = hashTable.put("cryss flow");
				assertEquals(index, -1);
		}
}
