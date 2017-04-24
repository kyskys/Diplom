package util;

import java.util.ArrayList;

import model.Monomial;
import model.Polynomial;
import model.Variable;
import model.Vertice;

public class GraphToPolynomial {
	ArrayList<Vertice> vertices;
	ArrayList<Polynomial> polynomials;

	public GraphToPolynomial(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public void convert() {
		for (int i = 0; i < vertices.size(); i++) {
			Vertice vertice = vertices.get(i);
			Polynomial p = new Polynomial();
			Variable v = new Variable("x" + vertice.number);
			Monomial m = new Monomial(v,3);
			Monomial m1 = new Monomial(-1);
			p.monomials.add(m);
			p.monomials.add(m1);
			polynomials.add(p);
			for (int j = 0; j < vertice.neighbours.size();j++) {
				Polynomial _p = new Polynomial();
				Variable _v = new Variable()
			}
		}
	}
}
