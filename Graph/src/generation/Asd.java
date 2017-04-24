package generation;

import java.util.ArrayList;

import model.Vertice;

public class Asd {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	ArrayList<Vertice> blue;
	ArrayList<Vertice> red;
	ArrayList<Vertice> green;

	public void init(int num) {
		for (int i = 0; i < num; i++) {
			vertices.add(new Vertice(i, 0));
		}
		for(int i=0;i<vertices.size();i++) {
			
		}
	}
	
}
