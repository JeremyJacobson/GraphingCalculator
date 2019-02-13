package model;

import java.util.ArrayList;

/**
 * Takes a String of an equation and by breaking it down into subEquations solves it
 * 
 * @author jeremyjacobson
 *
 */
public class EquationSolver {
	String equation;
	double numberOfXValues;
	
	/**
	 * Returns a list of X/Y points by solving the given equation
	 * 
	 * @param equation
	 * @param numberOfXValues
	 * @return
	 */
	public ArrayList<Point> createXYPointsList(String equation, double numberOfXValues) {
		ArrayList<Point> pointList = new ArrayList<>();
		
		//Loops for the specified number of XValues
		for (double i = (numberOfXValues * -1); i <= numberOfXValues; i++) {
			double xDecimals = Math.round((0.01 * i) * 1000.0) / 1000.0;//TODO
			//double xDecimals = i * 0.01;
			
			StringBuilder equationSB = new StringBuilder();
			for (char el : equation.toCharArray()) {
				equationSB.append(Character.valueOf(el).toString());
			}
			
			//Assigns the index of each variable(x-value) to variableIndexesList. This is down to change the value of the variable later
			ArrayList<Integer> variableIndexesList = new ArrayList<>();
			
			for (int j = 0; j < equationSB.length(); j++) {
				if (equationSB.charAt(j) == 'X') {
					variableIndexesList.add(j);
				}
			}
			
			//changes each variable(x-value) in the equation to i
			int t = variableIndexesList.size() - 1;
				
			for (int k = variableIndexesList.size() - 1; k >= 0; k--) {
				//checks for negative X value
				boolean xIsNegative = false;
				//System.out.println("variableT: " + equationSB.charAt(variableIndexesList.get(t)));
				if (equationSB.charAt(variableIndexesList.get(t) - 1) == '-') {
					xIsNegative = true;
				}
				if (xIsNegative == true) {
					equationSB.replace(variableIndexesList.get(t), variableIndexesList.get(t) + 1, Double.toString(xDecimals * -1));
					equationSB.deleteCharAt(variableIndexesList.get(t) - 1);
				} else {
					equationSB.replace(variableIndexesList.get(t), variableIndexesList.get(t) + 1, Double.toString(xDecimals));
				}
				t--;
			}
			
			//Groups based on parenthesis and then calls the solve method returning a double
			createSubEquations(equationSB);
			
			
			Point point = new Point(xDecimals * 25, Double.valueOf(equationSB.toString()) * 25);//TODO * 25
			pointList.add(point);
			
		}
		
		return pointList;
	}

	private void createSubEquations(StringBuilder equationSB) {
		int numberOfParenthesis = 0;
		for (int j = 0; j < equationSB.length(); j++) {
			if (equationSB.charAt(j) == '(') {
				numberOfParenthesis += 1;
				
			}
		}
		
		for (int j = 0; j < numberOfParenthesis; j++) {
			int endBracket = equationSB.indexOf(")");

			ArrayList<Character> tempArray = new ArrayList<>();//Used to store all the chars before the endBracket to find the index of the firstBracket
			for (int k = 0; k <= endBracket; k++) {
				tempArray.add(equationSB.charAt(k));
			}
			
			int firstBracket = tempArray.lastIndexOf('(');//The last index of '(' will be the first instance of '(' starting from the endBracket and going to the left
			
			ArrayList<Character> subEquation = new ArrayList<>();//Contains everything in between and including the firstBracket and endBracket
			
			for (int k = firstBracket; k < tempArray.size(); k++) {//Adds the chars between the firstBracket and endBracket from equationList to subEquation
				
				subEquation.add(equationSB.charAt(k));
			}
			
			//System.out.println("subEquation: " + subEquation);
			//System.out.println("EquationSB: " + equationSB);
			
			if (Double.valueOf(solve(subEquation)).isNaN()) {
				equationSB.delete(0, equationSB.length());
				equationSB.append("NaN");
				equationSB.trimToSize();
				break;
			} else {
				equationSB.replace(firstBracket, endBracket + 1, String.valueOf(solve(subEquation)));
				subEquation.clear();
			}
		}
	}
	
	private static double solve(ArrayList<Character> subEquation) {
		//SquareRoot
		if (subEquation.contains('R')) {
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.sqrt(Double.parseDouble(rightSide.toString()));
		}
		//Sin
		if (subEquation.contains('S')) {
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.sin(Double.parseDouble(rightSide.toString()));//answer in radians
		}
		//Cos
		if (subEquation.contains('C')) {
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.cos(Double.parseDouble(rightSide.toString()));//answer in radians
		}
		//Tan
		if (subEquation.contains('T')) {//Cannot tell where Tangent is undefined
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.tan(Double.parseDouble(rightSide.toString()));//answer in radians
		}
		//Power
		if (subEquation.contains('^')) {
			StringBuilder leftSide = new StringBuilder();
			for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf('^'); i++) {
				leftSide.append(subEquation.get(i));
			}
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('^') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			
			return Math.pow(Double.parseDouble(leftSide.toString()), Double.parseDouble(rightSide.toString()));
		}
		//Log
		if (subEquation.contains('L')) {
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.log10(Double.parseDouble(rightSide.toString()));
		}
		//Ln
		if (subEquation.contains('N')) {
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('>') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Math.log(Double.parseDouble(rightSide.toString()));
		}
		//Addition
		if (subEquation.contains('+')) {
			StringBuilder leftSide = new StringBuilder();
			for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf('+'); i++) {
				leftSide.append(subEquation.get(i));
			}
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('+') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Double.parseDouble(leftSide.toString()) + Double.parseDouble(rightSide.toString());
		}
		//Subtraction
		if (subEquation.contains('_')) {//Subtraction is represented by _ to differentiate between Subtraction and negative
			StringBuilder leftSide = new StringBuilder();
			for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf('_'); i++) {
				leftSide.append(subEquation.get(i));
			}
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('_') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Double.parseDouble(leftSide.toString()) - Double.parseDouble(rightSide.toString());
		}
		//Multiplication
		if (subEquation.contains('*')) {
			StringBuilder leftSide = new StringBuilder();
			for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf('*'); i++) {
				leftSide.append(subEquation.get(i));
			}
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('*') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			return Double.parseDouble(leftSide.toString()) * Double.parseDouble(rightSide.toString());
		}
		//Division
		if (subEquation.contains('/')) {
			StringBuilder leftSide = new StringBuilder();
			for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf('/'); i++) {
				leftSide.append(subEquation.get(i));
			}
			StringBuilder rightSide = new StringBuilder();
			for (int i = subEquation.indexOf('/') + 1; i < subEquation.indexOf(')'); i++) {
				rightSide.append(subEquation.get(i));
			}
			
			return Double.parseDouble(leftSide.toString()) / Double.parseDouble(rightSide.toString());
		}
		//If no operators
		StringBuilder subEquationSB = new StringBuilder();
		for (int i = subEquation.indexOf('(') + 1; i < subEquation.indexOf(')'); i++) {
			subEquationSB.append(subEquation.get(i));
		}
		return Double.parseDouble(subEquationSB.toString());
	}
}
