package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointerTests
{
		@Test
		public void testHasCycleMethod()
		{
				TwoPointerTechnique linkedList = new TwoPointerTechnique();
				linkedList.addAtHead(10);
				linkedList.addAtHead(20);
				linkedList.addAtHead(30);
				linkedList.tail.setNext(linkedList.head);
				assertTrue(linkedList.hasCycle(linkedList.head));
		}

		@Test
		public void testHasCycleInEmpty()
		{
				TwoPointerTechnique linkedList = new TwoPointerTechnique();
				assertFalse(linkedList.hasCycle(linkedList.head));
		}

		@Test
		public void testHasNotCycle()
		{
				TwoPointerTechnique linkedList = new TwoPointerTechnique();
				linkedList.addAtHead(10);
				linkedList.addAtHead(20);
				linkedList.addAtHead(30);
				assertFalse(linkedList.hasCycle(linkedList.head));
		}

		@Test
		public void testDetectCycleMethod()
		{
				TwoPointerTechnique linkedList = new TwoPointerTechnique();
				linkedList.addAtHead(10);
				linkedList.addAtHead(20);
				linkedList.addAtHead(30);
				linkedList.tail.setNext(linkedList.head);
				assertEquals(linkedList.detectCycle(linkedList.head), linkedList.head);
		}
}
