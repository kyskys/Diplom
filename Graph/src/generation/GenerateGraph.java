package generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Edge;

public class GenerateGraph {
	public static List<Edge> edges = new ArrayList<Edge>();
	public static List<Edge> temp = new ArrayList<Edge>();
	private static int n1;
	private static int n2;
	private static int n3;
	private static List<Edge> edge1 = new ArrayList<Edge>();
	private static List<Edge> edge2 = new ArrayList<Edge>();
	private static List<Edge> edge3 = new ArrayList<Edge>();

	public static void init(int num) {
		for (int i = 1; i <= num; i++) {
			edges.add(new Edge(i));
		}
		temp = edges;
	}

	public static boolean checkNeighbours(Edge e1, Edge e2) {
		if (e1.neighbours.contains(e2) || e2.neighbours.contains(e1)) {
			return false;
		} else
			return true;
	}

	public static void shuffle(int[] mas) {
		int n = mas.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int swap = mas[r];
			mas[r] = mas[i];
			mas[i] = swap;
		}
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

	public static void divideEdgeVariety(int num) {
		int q = (num / 10);
		System.out.println("q=" + q);
		int p = num / 3;
		n1 = (p - q) + (int) (Math.random() * (q * 2));
		num = num - n1;
		p = num / 2;
		n2 = (p - q) + (int) (Math.random() * (q * 2));
		n3 = num - n2;
	}

	public static void fillEdgeVariety() {
		Collections.shuffle(temp);
		int count = 0;
		for (int i = 0; i < n1; i++) {
			edge1.add(temp.get(i));
		}
		count+=n1;
		for (int i = 0; i < n2; i++) {
			edge2.add(temp.get(i+count));
		}
		count+=n2;
		for (int i = 0; i < n3; i++) {
			edge3.add(temp.get(i+count));
		}
	}
	public static void main(String[] args) {
		init(53);
		divideEdgeVariety(53);
		fillEdgeVariety();
		int z = 0;
		System.out.println(z);
	}
}
