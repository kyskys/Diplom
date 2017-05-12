package util;

import java.util.ArrayList;
import java.util.List;

import model.Edge;

public class GeneratePolynoms {

	public List<String> getPolynomial(List<Edge> edges) {
		List<String> polynomials = new ArrayList<String>();
		for (Edge e : edges) {
			String str = "x" + e.edgeNumber + "^3 - 1";
			polynomials.add(str);
		}
		for (Edge e : edges) {
			for (Edge _e : e.neighbours) {
				int num = e.edgeNumber;
				int _num = _e.edgeNumber;
				String str = "x" + num + "^2 + x" + _num + "^2 + x" + num + " * x" + _num;
				polynomials.add(str);
				_e.neighbours.remove(e);
				
			}
		}
		return polynomials;
	}
}
