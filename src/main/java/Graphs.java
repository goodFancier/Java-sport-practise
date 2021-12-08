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

		ArrayList<ArrayList<Vertex>> vertexChains;

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
										return findWayRecursion(i, vertexList, VTo);
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

		private void findWayBreadthFirstRecursion(int startPoint, int VFrom, int VTo)
		{
				for(Vertex adjustedVertex : getAdjustedVertices(VFrom))
				{
						for(Vertex ver : vertex)
						{
								ver.Hit = false;
						}
						fillChain(VFrom, adjustedVertex, new ArrayList<>(), VTo);
						ArrayList<Vertex> chain = resultChain;
						if(!chain.isEmpty())
						{
								chain.add(0, vertex[startPoint]);
								vertexChains.add(chain);
						}
				}
		}

		private ArrayList<Vertex> resultChain = new ArrayList<>();

		private void fillChain(int VFrom, Vertex adjustedVertex, ArrayList<Vertex> chain, int VTo)
		{
				chain.add(adjustedVertex);
				for(int i = 0; i < vertex.length; i++)
				{
						if(adjustedVertex.Value == vertex[i].Value && !adjustedVertex.Hit)
						{
								adjustedVertex.Hit = true;
								if(IsEdge(i, VTo))
								{
										chain.add(vertex[VTo]);
										vertex[VTo].Hit = true;
								}
								else
								{
										if(!getAdjustedVertices(i).isEmpty())
										{
												for(Vertex adjustVertex : getAdjustedVertices(i))
														fillChain(i, adjustVertex, chain, VTo);
										}
								}
						}
				}
				if(chain.get(chain.size() - 1).Value == vertex[VTo].Value)
						resultChain = chain;
		}

		private ArrayList<Vertex> getAdjustedVertices(int vertexIndex)
		{
				ArrayList<Vertex> adjustedVertices = new ArrayList<>();
				for(int i = 0; i < vertex.length; i++)
						if(IsEdge(vertexIndex, i) && !vertex[i].Hit)
								adjustedVertices.add(vertex[i]);
				return adjustedVertices;
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

		public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
		{
				// Узлы задаются позициями в списке vertex.
				// Возвращается список узлов -- путь из VFrom в VTo.
				// Список пустой, если пути нету.
				vertex[VFrom].Hit = true;
				if(IsEdge(VFrom, VTo))
				{
						vertex[VTo].Hit = true;
						return (ArrayList<Vertex>)Collections.singletonList(vertex[VFrom]);
				}
				vertexChains = new ArrayList<>();
				findWayBreadthFirstRecursion(VFrom, VFrom, VTo);
				return vertexChains.stream().min(Comparator.comparing(ArrayList::size)).orElse(new ArrayList<>());
		}
}