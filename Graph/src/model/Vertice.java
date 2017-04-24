package model;

import java.util.ArrayList;

public class Vertice {
	public int color;
	public int number;
	public ArrayList<Vertice> neighbours;

	public Vertice(int number, int color) {
		this.color = color;
		this.number = number;
	}
}
