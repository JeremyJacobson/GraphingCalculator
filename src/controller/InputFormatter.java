package controller;

import java.util.ArrayList;

/**
 * Formats a given String so that it is readable by the EquationSolver
 * 
 * @author jeremyjacobson
 *
 */
public class InputFormatter {
	String equation;
	
	/**
	 * Returns the formatted String after passing it through the modifyString method
	 * 
	 * @param equation
	 * @return
	 */
	public String formatString(String equation) {
		StringBuilder equationSB = new StringBuilder();
		
		for (char el : equation.toCharArray()) {
			equationSB.append(Character.valueOf(el).toString());
		}
		System.out.println("Unmodified: " + equation);
		System.out.println("Modified: " + modifyString(equationSB).toString());
		return modifyString(equationSB).toString();
	}
	
	/**
	 * Contains unimplemented if statements so that this code can be improved upon later. 
	 * This code works but it sometimes runs into errors based on user input.
	 * 
	 * @param equationSB
	 * @return
	 */
	private StringBuilder modifyString(StringBuilder equationSB) {
		
		//if nX where n is any integer
		if (equationSB.toString().contains("X")) {
			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of 'X' in equationSB
			for (int i = 0; i < equationSB.length();i++) {
				if (equationSB.charAt(i) == 'X') {
					indexes.add(i);
				}
			}
			for (int i = indexes.size() - 1; i >= 0; i--) {
				if ((!indexes.get(i).equals(equationSB.length()-1)) && 
						(equationSB.charAt(indexes.get(i) + 1) == '(' || Character.isDigit(equationSB.charAt(indexes.get(i) + 1)))) {
					System.out.println("rightX: " + equationSB.charAt(indexes.get(i) + 1));
					equationSB.insert((int)indexes.get(i) + 1, '*');
				}
				if ((!indexes.get(i).equals(0)) && 
						(equationSB.charAt(indexes.get(i) - 1) == ')' || Character.isDigit(equationSB.charAt(indexes.get(i) - 1)))) {
					System.out.println("leftX: " + equationSB.charAt(indexes.get(i) - 1));
					equationSB.insert((int)indexes.get(i), '*');
				}
			}
		}
		
		//if sqrt
		if (equationSB.toString().contains("√")) {
			String subEquation = equationSB.substring(equationSB.indexOf("√"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 1, "(<R>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("√"), equationSB.indexOf("√") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if sin
		if (equationSB.toString().contains("sin")) {
			String subEquation = equationSB.substring(equationSB.indexOf("sin"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 3, "(<S>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("sin"), equationSB.indexOf("sin") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if cos
		if (equationSB.toString().contains("cos")) {
			String subEquation = equationSB.substring(equationSB.indexOf("cos"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 3, "(<C>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("cos"), equationSB.indexOf("cos") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if tan
		if (equationSB.toString().contains("tan")) {
			String subEquation = equationSB.substring(equationSB.indexOf("tan"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 3, "(<T>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("tan"), equationSB.indexOf("tan") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if Log
		if (equationSB.toString().contains("log")) {
			String subEquation = equationSB.substring(equationSB.indexOf("log"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 3, "(<L>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("log"), equationSB.indexOf("log") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if Ln
		if (equationSB.toString().contains("ln")) {
			String subEquation = equationSB.substring(equationSB.indexOf("ln"), equationSB.length());
			subEquation = subEquation.substring(0, subEquation.indexOf(')') + 1);
			System.out.println("subEquation: " + subEquation);
			StringBuilder newSubEquation = new StringBuilder(subEquation);
			System.out.println("newSubEquation: " + newSubEquation);
			newSubEquation.replace(0, 2, "(<N>");
			newSubEquation.append(')');
			System.out.println("newSubEquation: " + newSubEquation);
			equationSB.replace(equationSB.indexOf("ln"), equationSB.indexOf("ln") + subEquation.length(), newSubEquation.toString());
			System.out.println("equationSB: " + equationSB);
		}
		//if ^
		if (equationSB.toString().contains("^")) {
			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of '^' in equationSB
			for (int i = 0; i < equationSB.length();i++) {
				if (equationSB.charAt(i) == '^') {
					indexes.add(i);
				}
			}
			for (int i = indexes.size() - 1; i >= 0; i--) {
				StringBuilder leftSide = new StringBuilder(equationSB.substring(0, indexes.get(i)));
				if (equationSB.charAt(equationSB.indexOf("^") - 1) != ')') {
					int startOfLeftSide = 0;
					for (int j = leftSide.length() - 1; j >= 0; j--) {
						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
							startOfLeftSide = j + 1;
							break;
						}
					}
					leftSide.delete(0, startOfLeftSide);
					System.out.println("leftSide: " + leftSide);
				}
				
				if (equationSB.charAt(equationSB.indexOf("^") - 1) == ')') {
					int parenthesisCounter = 0;
					int startOfLeftSide = 0;
					for (int j = leftSide.length()-1; j >= 0; j--) {
						if (leftSide.charAt(j) == ')') {
							parenthesisCounter++;
						}
						if (leftSide.charAt(j) == '(') {
							parenthesisCounter--;
						}
						if (parenthesisCounter == 0) {
							startOfLeftSide = j;
							break;
						}
					}
					leftSide.delete(0, startOfLeftSide);
					System.out.println("leftSide: " + leftSide);
				}
				StringBuilder rightSide = new StringBuilder(equationSB.substring(indexes.get(i) + 1, equationSB.length()));
				int parenthesisCounter = 0;
				int endOfRightSide = 0;
				for (int j = 0; j < rightSide.length(); j++) {
					if (rightSide.charAt(j) == '(') {
						parenthesisCounter++;
					}
					if (rightSide.charAt(j) == ')') {
						parenthesisCounter--;
					}
					if (parenthesisCounter == 0) {
						endOfRightSide = j;
						break;
					}
				}
				rightSide.delete(endOfRightSide + 1, rightSide.length());
				System.out.println("rightSide: " + rightSide);
				
				equationSB.insert(indexes.get(i) + rightSide.length() + 1, ')');
				equationSB.insert(indexes.get(i) - leftSide.length(), '(');
				System.out.println("equationSB: " + equationSB);
			}
		}
		
//		//if *
//		if (equationSB.toString().contains("*")) {
//			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of '+' in equationSB
//			for (int i = 0; i < equationSB.length();i++) {
//				if (equationSB.charAt(i) == '*') {
//					indexes.add(i);
//				}
//			}
//			
//			for (int i = indexes.size() - 1; i >= 0; i--) {
//				StringBuilder leftSide = new StringBuilder(equationSB.substring(0, indexes.get(i)));
//				StringBuilder rightSide = new StringBuilder(equationSB.substring(indexes.get(i) + 1, equationSB.length()));
//				System.out.println("LEngth: " + equationSB.length());
//				if (equationSB.charAt(equationSB.indexOf("*") - 1) == ')') {
//					int parenthesisCounter = 0;
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length()-1; j >= 0; j--) {
//						if (leftSide.charAt(j) == ')') {
//							parenthesisCounter++;
//						}
//						if (leftSide.charAt(j) == '(') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							startOfLeftSide = j;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				if (equationSB.charAt(equationSB.indexOf("*") - 1) != ')') {
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							startOfLeftSide = j + 1;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("*") + 1) == '(') {
//					int parenthesisCounter = 0;
//					int endOfRightSide = 0;
//					for (int j = 0; j < rightSide.length(); j++) {
//						if (rightSide.charAt(j) == '(') {
//							parenthesisCounter++;
//						}
//						if (rightSide.charAt(j) == ')') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("endrightSide: " + endOfRightSide);
//					System.out.println("rightSide!: " + rightSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("*") + 1) != '(') {
//					int endOfRightSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				equationSB.insert(indexes.get(i) + rightSide.length() + 1, ')');
//				equationSB.insert(indexes.get(i) - leftSide.length(), '(');
//				System.out.println("equationSB: " + equationSB);
//			}
//			
//		}
//		
//		//if /
//		if (equationSB.toString().contains("/")) {
//			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of '+' in equationSB
//			for (int i = 0; i < equationSB.length();i++) {
//				if (equationSB.charAt(i) == '/') {
//					indexes.add(i);
//				}
//			}
//			
//			for (int i = indexes.size() - 1; i >= 0; i--) {
//				StringBuilder leftSide = new StringBuilder(equationSB.substring(0, indexes.get(i)));
//				StringBuilder rightSide = new StringBuilder(equationSB.substring(indexes.get(i) + 1, equationSB.length()));
//				if (equationSB.charAt(equationSB.indexOf("/") - 1) == ')') {
//					int parenthesisCounter = 0;
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length()-1; j >= 0; j--) {
//						if (leftSide.charAt(j) == ')') {
//							parenthesisCounter++;
//						}
//						if (leftSide.charAt(j) == '(') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							startOfLeftSide = j;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				if (equationSB.charAt(equationSB.indexOf("/") - 1) != ')') {
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							startOfLeftSide = j + 1;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("/") + 1) == '(') {
//					int parenthesisCounter = 0;
//					int endOfRightSide = 0;
//					for (int j = 0; j < rightSide.length(); j++) {
//						if (rightSide.charAt(j) == '(') {
//							parenthesisCounter++;
//						}
//						if (rightSide.charAt(j) == ')') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("/") + 1) != '(') {
//					int endOfRightSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				equationSB.insert(indexes.get(i) + rightSide.length() + 1, ')');
//				equationSB.insert(indexes.get(i) - leftSide.length(), '(');
//				System.out.println("equationSB: " + equationSB);
//			}
//			
//		}
//				
//		//if +
//		if (equationSB.toString().contains("+")) {
//			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of '+' in equationSB
//			for (int i = 0; i < equationSB.length();i++) {
//				if (equationSB.charAt(i) == '+') {
//					indexes.add(i);
//				}
//			}
//			
//			for (int i = indexes.size() - 1; i >= 0; i--) {
//				StringBuilder leftSide = new StringBuilder(equationSB.substring(0, indexes.get(i)));
//				StringBuilder rightSide = new StringBuilder(equationSB.substring(indexes.get(i) + 1, equationSB.length()));
//				if (equationSB.charAt(equationSB.indexOf("+") - 1) == ')') {
//					int parenthesisCounter = 0;
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length()-1; j >= 0; j--) {
//						if (leftSide.charAt(j) == ')') {
//							parenthesisCounter++;
//						}
//						if (leftSide.charAt(j) == '(') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							startOfLeftSide = j;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				if (equationSB.charAt(equationSB.indexOf("+") - 1) != ')') {
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							startOfLeftSide = j + 1;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("+") + 1) == '(') {
//					int parenthesisCounter = 0;
//					int endOfRightSide = 0;
//					for (int j = 0; j < rightSide.length(); j++) {
//						if (rightSide.charAt(j) == '(') {
//							parenthesisCounter++;
//						}
//						if (rightSide.charAt(j) == ')') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("+") + 1) != '(') {
//					int endOfRightSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				equationSB.insert(indexes.get(i) + rightSide.length() + 1, ')');
//				equationSB.insert(indexes.get(i) - leftSide.length(), '(');
//				System.out.println("equationSB: " + equationSB);
//			}
//			
//		}
//		
//		//if _ (subtraction)
//		if (equationSB.toString().contains("_")) {
//			ArrayList<Integer> indexes = new ArrayList<>();//A list of all of the indexes of '+' in equationSB
//			for (int i = 0; i < equationSB.length();i++) {
//				if (equationSB.charAt(i) == '_') {
//					indexes.add(i);
//				}
//			}
//			
//			for (int i = indexes.size() - 1; i >= 0; i--) {
//				StringBuilder leftSide = new StringBuilder(equationSB.substring(0, indexes.get(i)));
//				StringBuilder rightSide = new StringBuilder(equationSB.substring(indexes.get(i) + 1, equationSB.length()));
//				if (equationSB.charAt(equationSB.indexOf("_") - 1) == ')') {
//					int parenthesisCounter = 0;
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length()-1; j >= 0; j--) {
//						if (leftSide.charAt(j) == ')') {
//							parenthesisCounter++;
//						}
//						if (leftSide.charAt(j) == '(') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							startOfLeftSide = j;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				if (equationSB.charAt(equationSB.indexOf("_") - 1) != ')') {
//					int startOfLeftSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							startOfLeftSide = j + 1;
//							break;
//						}
//					}
//					leftSide.delete(0, startOfLeftSide);
//					System.out.println("leftSide: " + leftSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("_") + 1) == '(') {
//					int parenthesisCounter = 0;
//					int endOfRightSide = 0;
//					for (int j = 0; j < rightSide.length(); j++) {
//						if (rightSide.charAt(j) == '(') {
//							parenthesisCounter++;
//						}
//						if (rightSide.charAt(j) == ')') {
//							parenthesisCounter--;
//						}
//						if (parenthesisCounter == 0) {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				if (equationSB.charAt(equationSB.indexOf("_") + 1) != '(') {
//					int endOfRightSide = 0;
//					for (int j = leftSide.length() - 1; j >= 0; j--) {
//						if (leftSide.charAt(j) == '^' || leftSide.charAt(j) == '*' || leftSide.charAt(j) == '/' ||
//							leftSide.charAt(j) == '+' || leftSide.charAt(j) == '_' || leftSide.charAt(j) == '(') {
//							endOfRightSide = j;
//							break;
//						}
//					}
//					rightSide.delete(endOfRightSide + 1, rightSide.length());
//					System.out.println("rightSide: " + rightSide);
//				}
//				
//				equationSB.insert(indexes.get(i) + rightSide.length() + 1, ')');
//				equationSB.insert(indexes.get(i) - leftSide.length(), '(');
//				System.out.println("equationSB: " + equationSB);
//			}
//			
//		}
				
		equationSB.insert(0, '(');
		equationSB.insert(equationSB.length(), ')');
		System.out.println("equationSB: " + equationSB);
		return equationSB;
	}
}
