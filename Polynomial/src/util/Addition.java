package util;

import java.util.List;

import edu.*;
import edu.jas.arith.BigRational;
import edu.jas.arith.Product;
import edu.jas.gb.GroebnerBase;
import edu.jas.gbufd.RGroebnerBasePseudoSeq;
import edu.jas.poly.GenPolynomial;
import edu.jas.poly.GenPolynomialRing;
import edu.jas.poly.Residue;

public class Addition {
	List<GenPolynomial<Product<Residue<BigRational>>>> L;
	String[] vars = new String[] { "a", "b" };
	GenPolynomialRing<Product<Residue<BigRational>>> fac = new GenPolynomialRing<Product<Residue<BigRational>>>(pr, 2,
			vars);
	GenPolynomial<Product<Residue<BigRational>>> p;
	for(
	int i = 0;i<3;i++)
	{
		p = fac.random(2, 4, 4, 0.4f);
		L.add(p);
	}System.out.println("L = "+L);
	GroebnerBase<Product<Residue<BigRational>>> bb = new RGroebnerBasePseudoSeq<Product<Residue<BigRational>>>(pr);
	List<GenPolynomial<Product<Residue<BigRational>>>> G = bb.GB(L);System.out.println("G = "+G);
}
