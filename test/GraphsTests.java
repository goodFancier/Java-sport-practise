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

		@Test
		public void testFindLinearWayInGraph()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				simpleGraph.AddVertex(20);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(3, 4);
				simpleGraph.AddEdge(4, 5);
				assertEquals(simpleGraph.DepthFirstSearch(2, 5).size(), 4);
		}

		@Test
		public void testFindRevertWayInGraph()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(10);
				simpleGraph.AddVertex(7);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(9);
				simpleGraph.AddVertex(20);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(3, 1);
				simpleGraph.AddEdge(1, 5);
				assertEquals(simpleGraph.DepthFirstSearch(2, 5).size(), 4);
				assertEquals(2, simpleGraph.DepthFirstSearch(2, 5).get(0).Value);
				assertEquals(20, simpleGraph.DepthFirstSearch(2, 5).get(simpleGraph.DepthFirstSearch(2, 5).size() - 1).Value);
		}

		@Test
		public void testDifficultWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(1, 3);
				simpleGraph.AddEdge(1, 5);
				simpleGraph.AddEdge(5, 4);
				assertEquals(simpleGraph.DepthFirstSearch(0, 4).size(), 4);
				assertEquals(simpleGraph.DepthFirstSearch(0, 5).size(), 3);
				assertEquals(simpleGraph.DepthFirstSearch(1, 4).size(), 3);
				assertEquals(1, simpleGraph.DepthFirstSearch(1, 5).get(0).Value);
				assertEquals(5, simpleGraph.DepthFirstSearch(1, 5).get(simpleGraph.DepthFirstSearch(1, 5).size() - 1).Value);
		}

		@Test
		public void testDuplicates()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(1, 2);
				simpleGraph.AddEdge(1, 3);
				simpleGraph.AddEdge(2, 5);
				simpleGraph.AddEdge(5, 4);
				assertEquals(simpleGraph.DepthFirstSearch(0, 4).size(), 5);
				assertEquals(simpleGraph.DepthFirstSearch(0, 5).size(), 4);
				assertEquals(simpleGraph.DepthFirstSearch(1, 4).size(), 4);
				assertEquals(1, simpleGraph.DepthFirstSearch(1, 5).get(0).Value);
				assertEquals(5, simpleGraph.DepthFirstSearch(1, 5).get(simpleGraph.DepthFirstSearch(1, 5).size() - 1).Value);
		}

		@Test
		public void testLongWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(1, 2);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(3, 4);
				simpleGraph.AddEdge(4, 5);
				assertEquals(simpleGraph.DepthFirstSearch(0, 5).size(), 6);
		}

		@Test
		public void testNoneWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(5, 4);
				simpleGraph.AddEdge(4, 3);
				simpleGraph.AddEdge(3, 2);
				simpleGraph.AddEdge(2, 1);
				simpleGraph.AddEdge(1, 0);
				assertEquals(simpleGraph.DepthFirstSearch(0, 5).size(), 0);
				assertEquals(simpleGraph.DepthFirstSearch(2, 5).size(), 0);
				assertEquals(simpleGraph.DepthFirstSearch(3, 5).size(), 0);
		}

		@Test
		public void testRevertWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(0, 2);
				simpleGraph.AddEdge(0, 3);
				simpleGraph.AddEdge(1, 3);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(1, 4);
				simpleGraph.AddEdge(3, 4);
				simpleGraph.AddEdge(3, 3);
				assertEquals(simpleGraph.DepthFirstSearch(0, 4).size(), 3);
		}

		@Test
		public void testBreadthFirstShortWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(0, 2);
				simpleGraph.AddEdge(0, 3);
				simpleGraph.AddEdge(1, 3);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(1, 4);
				simpleGraph.AddEdge(3, 4);
				simpleGraph.AddEdge(3, 3);
				assertEquals(simpleGraph.BreadthFirstSearch(0, 4).size(), 3);
		}

		@Test
		public void test5Vertex()
		{
				SimpleGraph simpleGraph = new SimpleGraph(5);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(0, 2);
				simpleGraph.AddEdge(0, 3);
				simpleGraph.AddEdge(1, 4);
				simpleGraph.AddEdge(2, 4);
				simpleGraph.AddEdge(3, 4);
				assertEquals(simpleGraph.BreadthFirstSearch(0, 4).size(), 3);
		}

		@Test
		public void testBreadthFirstLongWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(8);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddVertex(6);
				simpleGraph.AddVertex(7);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(0, 2);
				simpleGraph.AddEdge(0, 3);
				simpleGraph.AddEdge(1, 4);
				simpleGraph.AddEdge(2, 3);
				simpleGraph.AddEdge(3, 4);
				simpleGraph.AddEdge(3, 5);
				simpleGraph.AddEdge(4, 6);
				simpleGraph.AddEdge(5, 6);
				simpleGraph.AddEdge(5, 7);
				assertEquals(simpleGraph.BreadthFirstSearch(0, 7).size(), 5);
		}

		@Test
		public void testSimpleTopWay()
		{
				SimpleGraph simpleGraph = new SimpleGraph(6);
				simpleGraph.AddVertex(0);
				simpleGraph.AddVertex(1);
				simpleGraph.AddVertex(2);
				simpleGraph.AddVertex(3);
				simpleGraph.AddVertex(4);
				simpleGraph.AddVertex(5);
				simpleGraph.AddEdge(0, 1);
				simpleGraph.AddEdge(1, 2);
				simpleGraph.AddEdge(2, 4);
				simpleGraph.AddEdge(4, 3);
				simpleGraph.AddEdge(3, 5);
				assertEquals(simpleGraph.BreadthFirstSearch(0, 5).size(), 6);
		}
}
