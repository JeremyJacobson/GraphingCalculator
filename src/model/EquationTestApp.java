package model;

import java.util.ArrayList;

import controller.InputFormatter;

/**
 * Used to test the EquationSolver. Not necessary for calculator to work
 * 
 * @author jeremyjacobson
 *
 */
public class EquationTestApp {
	
	public static void main(String[] args) {
		//String modifiedEquation = "(((X^2)+5)/(<T>(X+5)))"; //"T" represents the tangent function being used on the following parenthesis

		//String modifiedEquation = "(((((2*((X^(((2*(<L>(4)))))))))+5)/(<N>(((2*X))+5))))";
		//String modifiedEquation = "((((X^(2)))))";
		//String modifiedEquation = "(X^(2))";
		String unmodifiedEquation = "X^(2)";
		//String unmodifiedEquation = "0.01^(2.0)";
		InputFormatter myIF = new InputFormatter();
		String modifiedEquation = myIF.formatString(unmodifiedEquation);
		EquationSolver myEQS = new EquationSolver();
		ArrayList<Point> pointList = myEQS.createXYPointsList(modifiedEquation, 5);
		
		for (Point el : pointList) {
			System.out.println(el);
			
		}
	}

}
