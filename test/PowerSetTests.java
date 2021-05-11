import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PowerSetTests
{
		private String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		private Random rng = new Random();

		public String getRandomString()
		{
				char[] text = new char[10];
				for(int i = 0; i < 10; i++)
						text[i] = characters.charAt(rng.nextInt(characters.length()));
				return new String(text);
		}

		@Test
		public void testPutInSet()
		{
				PowerSet powerSet = new PowerSet();
				for(int i = 0; i < 20000; i++)
				{
						powerSet.put(getRandomString());
						powerSet.put("First");
				}
				assertTrue(powerSet.get("First"));
				assertEquals(20001, powerSet.getSet().size());
		}

		@Test
		public void testRemoveFromSet()
		{
				PowerSet powerSet = new PowerSet();
				powerSet.put("First");
				powerSet.put("Second");
				powerSet.put("Third");
				powerSet.remove("Second");
				assertEquals(0, powerSet.getSet().size());
		}

		@Test
		public void testIntersectionSets()
		{
				PowerSet powerSet = new PowerSet();
				powerSet.put("First");
				powerSet.put("Second");
				powerSet.put("Third");
				PowerSet powerSet1 = new PowerSet();
				powerSet1.put("Fourth");
				powerSet1.put("Fifth");
				powerSet1.put("Second");
				assertTrue(powerSet.intersection(powerSet1).get("Second"));
		}

		@Test
		public void testDifference()
		{
				PowerSet powerSet = new PowerSet();
				powerSet.put("First");
				powerSet.put("Second");
				powerSet.put("Third");
				PowerSet powerSet1 = new PowerSet();
				powerSet1.put("Fourth");
				powerSet1.put("Fifth");
				powerSet1.put("Second");
				assertTrue(powerSet.difference(powerSet1).get("Fourth"));
				assertTrue(powerSet.difference(powerSet1).get("Fifth"));
		}

		@Test
		public void testUnionSets()
		{
				PowerSet powerSet = new PowerSet();
				powerSet.put("1");
				powerSet.put("1");
				powerSet.put("1");
				powerSet.put("1");
				powerSet.put("2");
				PowerSet powerSet1 = new PowerSet();
				powerSet1.put("2");
				powerSet1.put("2");
				powerSet1.put("2");
				powerSet1.put("2");
				powerSet1.put("33");
				powerSet1.put("3");
				powerSet1.put("1");
				assertEquals(6, powerSet.union(powerSet1).getSet().size());
				powerSet = new PowerSet();
				powerSet.put("First");
				powerSet1 = new PowerSet();
				assertEquals(1, powerSet.union(powerSet1).getSet().size());
				powerSet = new PowerSet();
				powerSet1 = new PowerSet();
				assertEquals(0, powerSet.union(powerSet1).getSet().size());
		}

		@Test
		public void testIsSubset()
		{
				PowerSet powerSet = new PowerSet();
				powerSet.put("First");
				powerSet.put("Second");
				powerSet.put("Third");
				powerSet.put("Fourth");
				powerSet.put("Fifth");
				powerSet.put("Sixth");
				PowerSet powerSet1 = new PowerSet();
				powerSet1.put("Fourth");
				powerSet1.put("Fifth");
				powerSet1.put("Second");
				assertTrue(powerSet.isSubset(powerSet1));
		}
}
