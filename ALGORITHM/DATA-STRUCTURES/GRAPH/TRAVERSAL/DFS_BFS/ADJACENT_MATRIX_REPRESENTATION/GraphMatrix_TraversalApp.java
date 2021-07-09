import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*2021-July-01. Oleksii Saiun. 
 * BFS and DFS traversal for the case when Graph represented as Adjacent Matrix.
 * 
 *  Example,
 *  G--------B
 *  |        |\
 *  |        | \
 *  F----E---A--C
 *  |        | /
 *  |        |/
 *  H--------D
 *  
 *  
 * */

class Graph {
	private int[][] mt;
	private int lenOfMatrix;
	private Map<Vertex, Integer> mapOfVertices = new HashMap<>(); // it is a dictionary, it has an array of all unique
																	// vertices
	private Vertex[] arrOfVertices;//it also keep track of vertices
	/*
	 * [mapOfVertices] and [arrOfVertices] has duplicated functionality
	 * ,but i use both of them to find adjacent Vertices. It is simplified that process
	 * */
	private int indexOfVertex = 0;


	public Graph(int[][] mt) {
		this.mt = mt;
		lenOfMatrix = mt.length;
		arrOfVertices = new Vertex[lenOfMatrix];
	}

	public void displayMatrix() {
		for (int col = 0; col < mt.length; col++) {
			for (int row = 0; row < mt[col].length; row++) {
				System.out.print(mt[col][row] + "; ");
			}
			System.out.println();
		}
	}

	public void addVertex(Vertex vertex) {
		arrOfVertices[indexOfVertex] = vertex;
		mapOfVertices.put(vertex, indexOfVertex++);
	}

	public void bfs(Vertex startVertex) {
		Queue<Vertex> queue = new ArrayDeque<>();
		Set<Vertex> setOfVisitedVertices = new HashSet<>();
		queue.offer(startVertex);

		while (!queue.isEmpty()) {
			Vertex currVertex = queue.poll();
			if (!setOfVisitedVertices.contains(currVertex)) {
				System.out.print(currVertex.getValue() + "; ");
				setOfVisitedVertices.add(currVertex);
			}
			int positionVertexAtMap = mapOfVertices.get(currVertex);
			int[] rowAtMatrix = mt[positionVertexAtMap];

			for (int j = 0; j < rowAtMatrix.length; j++) {
				Vertex vertex = arrOfVertices[j];
				if (!setOfVisitedVertices.contains(vertex)) {
					queue.offer(vertex);
				}
			}
		}

	}

	public void dfs(Vertex startVertex) {
		Stack<Vertex> stack = new Stack<>();
		Set<Vertex> setOfVisitedVertices = new HashSet<>();
		stack.push(startVertex);

		while (!stack.isEmpty()) {
			Vertex currVertex = stack.pop();
			if (!setOfVisitedVertices.contains(currVertex)) {
				System.out.print(currVertex.getValue() + "; ");
				setOfVisitedVertices.add(currVertex);
			}
			int positionVertexAtMap = mapOfVertices.get(currVertex);
			int[] rowAtMatrix = mt[positionVertexAtMap];

			for (int j = 0; j < rowAtMatrix.length; j++) {
				Vertex vertex = arrOfVertices[j];
				if (!setOfVisitedVertices.contains(vertex)) {
					stack.push(vertex);
				}
			}
		}

	}
}

public class GraphMatrix_TraversalApp {
	public static void main(String[] args) {
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		Vertex vertexH = new Vertex("H");

		int[][] mt = new int[][] { 
			    { 0, 1, 1, 1, 1, 0, 0, 0 }
			   ,{ 1, 0, 1, 0, 0, 0, 1, 0 }
			   ,{ 1, 1, 0, 1, 0, 0, 0, 0 }
			   ,{ 1, 0, 1, 0, 0, 0, 0, 1 }
			   ,{ 1, 0, 0, 0, 0, 1, 0, 0 }
			   ,{ 0, 0, 0, 0, 1, 0, 1, 1 }
			   ,{ 0, 1, 0, 0, 0, 1, 0, 0 }
			   ,{ 0, 0, 0, 1, 0, 1, 0, 0 } 
			   };
			   
		Graph graph = new Graph(mt);
		graph.addVertex(vertexA);
		graph.addVertex(vertexB);
		graph.addVertex(vertexC);
		graph.addVertex(vertexD);
		graph.addVertex(vertexE);
		graph.addVertex(vertexF);
		graph.addVertex(vertexG);
		graph.addVertex(vertexH);
		
		System.out.println("BFS:");
        graph.bfs(vertexA);
		System.out.println();
		System.out.println("DFS:");
		graph.dfs(vertexA);
		
		/* 
		 *  Example:
		 *  G--------B
		 *  |        |\
		 *  |        | \
		 *  F----E---A--C
		 *  |        | /
		 *  |        |/
		 *  H--------D
		 *  
		 *  
		 * */		
	}

}
