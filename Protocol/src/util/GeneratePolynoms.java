package util;

import java.util.ArrayList;

public class GeneratePolynoms {

	public static ArrayList<Edge> edges = new ArrayList<Edge>();

	public ArrayList<int[]> polynoms = new ArrayList<int[]>();
	public static ArrayList<Edge> temp = new ArrayList<Edge>();
	public static ArrayList<int[]> connections = new ArrayList<int[]>();

	public static int _num = 0;
	public static int i = 0;

	public static Edge joinEdges(Edge remainingEdge) {
		Edge e1 = remainingEdge;
		if (e1 == null) {
			e1 = selectEdge();
			temp.remove(e1);
		}
		if (!temp.isEmpty()) {
			Edge e2 = selectEdge();
			if (checkNeighbours(e1, e2)) {
				addNeighbours(e1, e2);
				temp.remove(e2);
				return joinEdges(null);
			} else
				return joinEdges(e1);
		}
		if(temp.isEmpty()) {
			return e1;
		}
		return null;
	}

	public static void joinGroups(Edge remainingEdge) {
		Edge e1 = remainingEdge;
		if (e1 == null) {
			refresh();
			joinEdges(null);
		}
		else if(e1!=null) {
			refresh();
			temp.remove(e1);
			joinEdges(e1);
		}
	}
	
	public static void init(int num) {
		for (int i = 1; i <= num; i++) {
			edges.add(new Edge(i));
		}
		refresh();
	}

	public static void refresh() {
		temp = edges;
		edges = new ArrayList<Edge>();
	}

	public static boolean checkNeighbours(Edge e1, Edge e2) {
		if (e1.neighbours.contains(e2) || e2.neighbours.contains(e1)) {
			return false;
		} else
			return true;
	}

	public static void addNeighbours(Edge e1, Edge e2) {
		e1.neighbours.add(e2);
		e2.neighbours.add(e1);
		edges.add(e1);
		edges.add(e2);
	}

	public static Edge selectEdge() {
		Edge edge = temp.get((int) (Math.random() * temp.size()));
		return edge;
	}

	public static void main(String args[]) {
		int num = 9;
		System.out.println("end");
		init(num);
		Edge e =  joinEdges(null);
		joinGroups(e);
		System.out.println("end");
	}
}
