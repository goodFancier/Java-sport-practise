import org.junit.Test;

import static org.junit.Assert.*;

public class GraphsTests
{
		@Test
		public void testAddVertex()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				assertNull(simpleGraph.vertex[5]);
				assertEquals(simpleGraph.vertex[2].Value, 2);
		}

		@Test
		public void testAddEdge()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				simpleGraph.AddEdge(2, 3);
				assertEquals(simpleGraph.m_adjacency[1][3], 0);
				assertEquals(simpleGraph.m_adjacency[2][3], 1);
				assertEquals(simpleGraph.m_adjacency[2][5], 0);
				assertTrue(simpleGraph.IsEdge(2, 3));
				assertFalse(simpleGraph.IsEdge(2, 5));
		}

		@Test
		public void testRemoveVertex()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				simpleGraph.AddEdge(2, 3);
				assertTrue(simpleGraph.IsEdge(2, 3));
				simpleGraph.AddEdge(2, 5);
				simpleGraph.RemoveVertex(2);
				assertFalse(simpleGraph.IsEdge(2, 3));
				assertFalse(simpleGraph.IsEdge(2, 5));
		}

		@Test
		public void testRemoveEdge()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(1, 4);
				simpleGraph.AddEdge(2, 5);
				simpleGraph.RemoveEdge(2, 3);
				assertFalse(simpleGraph.IsEdge(2, 3));
				assertTrue(simpleGraph.IsEdge(2, 5));
				assertTrue(simpleGraph.IsEdge(1, 4));
		}
}
