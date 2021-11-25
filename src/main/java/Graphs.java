import java.util.*;

class Vertex
{
		public int Value;

		public boolean Hit;

		public Vertex(int val)
		{
				Value = val;
				Hit = false;
		}
}

class SimpleGraph
{
		Vertex[] vertex;

		int[][] m_adjacency;

		int max_vertex;

		public SimpleGraph(int size)
		{
				max_vertex = size;
				m_adjacency = new int[size][size];
				vertex = new Vertex[size];
		}

		public void AddVertex(int value)
		{
				// ваш код добавления новой вершины
				// с значением value
				// в незанятую позицию vertex
				for(int i = 0; i < vertex.length; i++)
				{
						if(vertex[i] == null)
						{
								vertex[i] = new Vertex(value);
								break;
						}
				}
		}

		// здесь и далее, параметры v -- индекс вершины
		// в списке  vertex
		public void RemoveVertex(int v)
		{
				// ваш код удаления вершины со всеми её рёбрами
				vertex[v] = null;
				for(int i = 0; i < m_adjacency.length; i++)
				{
						m_adjacency[v][i] = 0;
				}
		}

		public boolean IsEdge(int v1, int v2)
		{
				// true если есть ребро между вершинами v1 и v2
				return m_adjacency[v1][v2] == 1;
		}

		public void AddEdge(int v1, int v2)
		{
				// добавление ребра между вершинами v1 и v2
				m_adjacency[v1][v2] = 1;
		}

		public void RemoveEdge(int v1, int v2)
		{
				// удаление ребра между вершинами v1 и v2
				m_adjacency[v1][v2] = 0;
		}

		private ArrayList<Vertex> findWayRecursion(int from, ArrayList<Vertex> vertexList, int VTo)
		{
				vertex[from].Hit = true;
				if(!vertexList.contains(vertex[from]))
						vertexList.add(vertex[from]);
				if(IsEdge(from, VTo))
				{
						vertexList.add(vertex[VTo]);
						vertex[VTo].Hit = true;
						return vertexList;
				}
				else
						for(int i = 0; i < vertex.length; i++)
								if(IsEdge(from, i) && !vertex[i].Hit)
										findWayRecursion(i, vertexList, VTo);
				if(vertexList.isEmpty())
						return vertexList;
				if(vertex[VTo].Value != vertexList.get(vertexList.size() - 1).Value)
				{
						vertexList.remove(vertexList.size() - 1);
						if(vertexList.isEmpty())
								return vertexList;
						else
						{
								for(int i = 0; i < vertex.length; i++)
								{
										if(vertex[i].Value == vertexList.get(vertexList.size() - 1).Value)
										{
												from = i;
												break;
										}
								}
								findWayRecursion(from, vertexList, VTo);
						}
				}
				return vertexList;
		}

		public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
		{
				// Узлы задаются позициями в списке vertex
				for(Vertex ver : vertex)
				{
						ver.Hit = false;
				}
				// Возвращается список узлов -- путь из VFrom в VTo.
				// Список пустой, если пути нету.
				return findWayRecursion(VFrom, new ArrayList<>(), VTo);
		}
}