package model;

import java.util.ArrayList;

public class Edge {
	public int edgeNumber;
	public ArrayList<Edge> neighbours = new ArrayList<Edge>();

	public Edge(int num) {
		edgeNumber = num;
	}

	@Override
	public int hashCode() {
	return edgeNumber;
	}

	@Override
	public boolean equals(Object obj) {
	return this.hashCode() == obj.hashCode();
	}
}
