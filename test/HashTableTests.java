import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTableTests
{
		@Test
		public void testHashFun()
		{
				HashTable hashTable = new HashTable(17, 3);
				System.out.println(hashTable.hashFun("Hello"));
		}

		@Test
		public void testSeekSlot()
		{
				HashTable hashTable = new HashTable(17, 3);
				System.out.println(hashTable.seekSlot("Hello"));
		}

		@Test
		public void testPutValue()
		{
				HashTable hashTable = new HashTable(17, 3);
				hashTable.put("kitty slow");
				hashTable.put("come throw");
				System.out.println(hashTable.size);
		}

		@Test
		public void testFindValue()
		{
				HashTable hashTable = new HashTable(17, 3);
				int index =	hashTable.put("kitty slow");
				assertEquals(index, hashTable.find("kitty slow"));
				index = hashTable.put("come throw");
				assertEquals(index, hashTable.find("come throw"));
				index = hashTable.put("cryss flow");
				assertEquals(index, hashTable.find("cryss flow"));
		}
}
