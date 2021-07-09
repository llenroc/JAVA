import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*2021-July-01. Oleksii Saiun. 
 * BFS and DFS traversal for the case when Graph represented as Adjacent List.
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
	private List<List<Vertex>> listGraph = new ArrayList<>();
	private HashMap<Vertex, Integer> mapOfElements = new HashMap<>();
	private int indexOfMap = 0;

	public Graph() {
	}

	public void addAdge(Vertex source, Vertex destin) {
		addElementToList(source, destin);
		addElementToList(destin, source);
	}

	public void displayGraph() {
		for (List<Vertex> list : listGraph) {
			for (Vertex j : list) {
				System.out.print(j.getValue() + "; ");
			}
			System.out.println();
		}
	}

	public void dfs(Vertex vertex) {
		Stack<Vertex> stack = new Stack<>();
		Set<Vertex> setOfSeenVertices = new HashSet<>();
		stack.push(vertex);

		while (!stack.isEmpty()) {
			Vertex currVertex = stack.pop();
			if (!setOfSeenVertices.contains(currVertex)) {
				setOfSeenVertices.add(currVertex);
				System.out.print(currVertex.getValue() + "; ");
			}
			int indexAtList = mapOfElements.get(currVertex);
			// System.out.println("indexAtList:"+indexAtList);
			for (Vertex adjVertex : listGraph.get(indexAtList)) {
				if (!setOfSeenVertices.contains(adjVertex)) {
					stack.push(adjVertex);
				}
			}
		}
	}

	public void bfs(Vertex vertex) {
		Queue<Vertex> queue = new ArrayDeque<>();
		Set<Vertex> setOfSeenVertices = new HashSet<>();
		queue.offer(vertex);

		while (!queue.isEmpty()) {
			Vertex currVertex = queue.poll();
			if (!setOfSeenVertices.contains(currVertex)) {
				setOfSeenVertices.add(currVertex);
				System.out.print(currVertex.getValue() + "; ");
			}
			int indexAtList = mapOfElements.get(currVertex);
			for (Vertex adjVertex : listGraph.get(indexAtList)) {
				if (!setOfSeenVertices.contains(adjVertex)) {
					queue.offer(adjVertex);
				}
			}

		}
	}

	private void addElementToList(Vertex source, Vertex destin) {
		if (mapOfElements.containsKey(source)) {
			int indexAtList = mapOfElements.get(source);
			listGraph.get(indexAtList).add(destin);

		} else {
			List<Vertex> listLevel = new ArrayList<>();
			mapOfElements.put(source, indexOfMap++);
			listLevel.add(source);
			listLevel.add(destin);
			listGraph.add(listLevel);
		}
	}
}

public class GraphList_TraversalApp {
	public static void main(String[] args) {
		Graph graph = new Graph();
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		Vertex vertexH = new Vertex("H");

		graph.addAdge(vertexA, vertexB);
		graph.addAdge(vertexA, vertexC);
		graph.addAdge(vertexA, vertexE);
		graph.addAdge(vertexA, vertexD);

		graph.addAdge(vertexB, vertexG);
		graph.addAdge(vertexB, vertexC);

		graph.addAdge(vertexC, vertexD);

		graph.addAdge(vertexD, vertexH);

		graph.addAdge(vertexF, vertexE);
		graph.addAdge(vertexF, vertexG);
		graph.addAdge(vertexF, vertexH);

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
