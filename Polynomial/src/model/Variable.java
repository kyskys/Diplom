package model;

public class Variable {
	public int degree;
	public String variable;

	public Variable(int deg, String var) {
		degree = deg;
		variable = var;
	}

	public Variable(String var) {
		variable = var;
		degree = 1;
	}
}
