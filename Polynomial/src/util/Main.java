package util;

import edu.jas.arith.BigInteger;
import edu.jas.arith.BigRational;
import edu.jas.poly.GenPolynomial;
import edu.jas.poly.GenPolynomialRing;
import edu.jas.poly.TermOrder;

public class Main {

	public static void main(String[] args) {

		int num = 30;
		
		System.out.println("n1=" + n1);
		System.out.println("n2=" + n2);
		System.out.println("n3=" + n3);
		System.out.println("num=" + (n1 + n2 + n3));

		System.out.println("p=" + p);
	}

	public void asd() {
		System.out.println("\n\n example 1");

		BigRational cfac = new BigRational();
		System.out.println("cfac = " + cfac);
		GenPolynomialRing<BigRational> fac;
		fac = new GenPolynomialRing<BigRational>(cfac, 7);
		System.out.println("fac = " + fac);

		GenPolynomial<BigRational> a = fac.random(10);
		System.out.println("a = " + a);

		BigInteger z = new BigInteger();

		TermOrder to = new TermOrder();
		String[] vars = new String[] { "x1", "x2", "x3" };
		GenPolynomialRing<BigInteger> ring;
		ring = new GenPolynomialRing<BigInteger>(z, 3, to, vars);
		System.out.println("ring = " + ring);
		GenPolynomial<BigInteger> pol;
		pol = ring.parse("3 x1^2 x3^4 + 7 x2^5 - 61");
		System.out.println("pol = " + pol);
		System.out.println("pol = " + pol.toString(ring.getVars()));
	}
}
