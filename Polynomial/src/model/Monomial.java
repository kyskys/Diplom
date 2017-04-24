package model;

import java.util.ArrayList;

public class Monomial {
	ArrayList<Variable> variables = new ArrayList<Variable>();
	public int coefficient;

	public Monomial(int coefficient, ArrayList<Variable> variables) {
		this.variables = variables;
		this.coefficient = coefficient;
	}

	public Monomial(ArrayList<Variable> variables) {
		this.variables = variables;
		coefficient = 1;
	}
	public Monomial(Variable variable) {
		variables.add(variable);
	}
	public Monomial(int coefficient) {
		this.coefficient = coefficient;
	}
}
