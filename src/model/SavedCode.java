package model;

public class SavedCode {

}

//package view;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.util.ArrayList;
//
//import javax.swing.JPanel;
//
//import model.Point;
//import java.awt.Dimension;
//import java.awt.BorderLayout;
//
//public class GraphPanel extends JPanel {
//
//	private ArrayList<Point> points = new ArrayList<>();
//	private int halfSide;
//	//private int fullSide = halfSide * 2;
//	
//	public GraphPanel(ArrayList<Point> points, int halfSide) {
//		this.points = points;
//		this.halfSide = halfSide;
//		setLayout(new BorderLayout(0, 0));
//	}
//	
//	@Override
//	public void paintComponent(Graphics g) 
//	{
//		super.paintComponent(g);	
//		
//		//Set Background Color
//		this.setBackground(Color.WHITE);
//		
//		g.translate(halfSide, halfSide);
//		
//		//Draw Cartesian Plane and grid network
//		drawAxes(g);
//		
//		//Draw Graph
//		drawGraph(g, points);
//	}
//	
//	public void drawAxes(Graphics g) 
//	{
//		
//		//Draw x & y axis units
//		for( int i = -halfSide; i <= halfSide; i+=(halfSide/10) )
//		{
//			g.setColor(Color.LIGHT_GRAY);
//			//draw grid network
//			//condition prevents the grid from overlapping
//			//the x and y axis
//			if( i != halfSide )
//			{	
//				//draw vertical grid
//				g.drawLine(i, -halfSide, i, halfSide);
//				//draw horizontal grid
//				g.drawLine(-halfSide, i, halfSide, i);
//			}
//			
//			//Set paint color black for axes
//			g.setColor(Color.BLACK);
//			
//			//draw x axis units
//			g.drawLine(i, -(halfSide / 50), i, (halfSide / 50));
//			
//			//draw y axis units
//			g.drawLine(-(halfSide / 50), i, (halfSide / 50), i);
//				
//			//draw x point values
//			//g.drawString("(0.0)", x, y);
//			
//			//draw y point values
//			
//		}
//		
//		//draw axes
//		g.setColor(Color.BLACK);
//		
//		//draw y axis
//		g.drawLine(0, -halfSide, 0, halfSide);
//		
//		//draw x axis
//		g.drawLine(-halfSide, 0, halfSide, 0);
//	}
//	
//	//Draws The Graph
//	public void drawGraph(Graphics g, ArrayList<Point> points) 
//	{		
//		//Set paint to red
//		g.setColor(Color.RED);
//		
//		//g.translate(halfSide, halfSide);
//		//draws the points
//		for(int i = 0; i < points.size() - 1; i++) {
//			
//			//checks where values are infinite or NaN and shouldnt be graphed
//			if (!((Double.isInfinite(points.get(i).getX()) || Double.isInfinite(points.get(i).getY())) || 
//					(Double.isInfinite(points.get(i + 1).getX()) || Double.isInfinite(points.get(i + 1).getY())) || 
//					(Double.isNaN(points.get(i).getX()) || Double.isNaN(points.get(i).getY())) || 
//					(Double.isNaN(points.get(i + 1).getX()) || Double.isNaN(points.get(i + 1).getY())))) {
//				g.drawLine((int) points.get(i).getX(), (int) -points.get(i).getY(), (int) points.get(i + 1).getX(), (int) -points.get(i + 1).getY());
//			}
////			else {
////				g.drawLine((int) points.get(i).getX(), (int) -points.get(i).getY(), (int) points.get(i + 1).getX(), (int) -points.get(i + 1).getY());
////			}
//		}
//	}
//}





//package graphingCalculator;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Equation {
//	Character[] possibleIntsArray = {'0','1','2','3','4','5','6','7','8','9'};
//	Character[] possibleVariablesArray = {'X'}; //TODO change to be A - Z
//	Character[] possibleOperatorsArray = {'^','*','+','-','/','\\','|'};
//	Character[] possibleParenthesisArray = {'(',')','{','}','[',']'};
//	int Y;
//
//	public Equation(String equation, int iterations) {
//		ArrayList<Character> equationList = new ArrayList<>();
//		
//		//Removes spaces and checks that all chars are valid chars and then adds the elements to equationList in UpperCase
//		for (char el : equation.toCharArray()) {
//			if (el != ' ' || Arrays.asList(possibleIntsArray).contains(el) || Arrays.asList(possibleVariablesArray).contains(el) || 
//					Arrays.asList(possibleOperatorsArray).contains(el) || Arrays.asList(possibleParenthesisArray).contains(el)) {
//				equationList.add(Character.toUpperCase(el));
//			}
//		}
//		System.out.println("EquationList: " + equationList);//TODO remove
//		
//		//Assigns the index of each variable(x-value) to variableIndexesList
//		ArrayList<Integer> variableIndexesList = new ArrayList<>();
//		for (int i = 0; i < equationList.size(); i++) {
//			if (Arrays.asList(possibleVariablesArray).contains(equationList.get(i))) {
//				variableIndexesList.add(i);
//				
//			}
//		}
//		System.out.println("variableIndexesList: " + variableIndexesList);//TODO remove
//		
//		//Loops for the specified number of iterations
//		for (int i = 0; i < iterations; i++) {
//			
//			//changes each variable(x-value) in the equation to i
//			for (int j = 0; j < variableIndexesList.size(); j++) {
//				equationList.set(variableIndexesList.get(j), possibleIntsArray[i]);//uses possibleIntsArray to represent char values of i. Find better way to convert i to char TODO
//			}
//			
//			System.out.println("EquationList: " + equationList);//TODO remove
//			
//			//Groups based on parenthesis and then calls the solve method
//			int numberOfParenthesis = 0;
//			for (int j = 0; j < equationList.size(); j++) {
//				if (equationList.get(j) == '(') {
//					numberOfParenthesis += 1;
//					
//				}
//			}
//			
//			for (int j = 0; j < numberOfParenthesis; j++) {
//				int endBracket = equationList.indexOf(')');
//				ArrayList<Character> tempArray = new ArrayList<>();//Used to store all the chars before the endBracket to find the index of the firstBracket
//				for (int k = 0; k <= endBracket; k++) {
//					tempArray.add(equationList.get(k));
//				}
//				
//				int firstBracket = tempArray.lastIndexOf('(');//The last index of '(' will be the first instance of '(' starting from the endBracket and going to the left
//				
//				//System.out.println("tempArray: " + tempArray + " endBracket: " + endBracket + " firstBracket: " + firstBracket);//TODO remove
//				
//				ArrayList<Character> subEquation = new ArrayList<>();//Contains everything in between and including the firstBracket and endBracket
//				
//				for (int k = firstBracket; k < tempArray.size(); k++) {//Adds the chars between the firstBracket and endBracket from equationList to subEquation
//					subEquation.add(equationList.get(k));
//				}
//								
//				System.out.println("subEquation: " + subEquation);//TODO remove
//				System.out.println("EquationList: " + equationList);
//				
//			}
//			System.out.println("numberOfParenthesis: " + numberOfParenthesis + "\n");//TODO remove
//		}
//	}
//	
//	public String solve(String equation) {
//		
//		
//		return null;
//	}
//}
//







//package graphingCalculator;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Logic {
//	String yValueString = "((x^2) + 5)/(x+5)";
//	Character[] acceptedCharsArray = {'x','1','2','3','4','5','6','7','8','9','0','^',
//			'*','+','-','/','\\','(',')','{','}','[',']','|',' '};
//	
//	public double solve (String equation) {
//		int numberOfRuns = 0;//Used to determine how many different values of x should be plugged into y
//		
//		//Stringbuilder, set all x values to int, then go through for each x and do the math based on the surrounding +-*/
//		
//		return 0.0;
//	}
//	
//	public static void main(String[] args) {
////		Scanner input = new Scanner(System.in);
////		System.out.print("Enter Y: ");
////		int x = 1;
////		int y = input.nextInt();
////		System.out.println(y);
//		/*
//		 * Save user input into file and then change the string in the file by replacing x with an int and then
//		 * assign y to equal the int in the file
//		 */
//		
//		
//	}
//}





//package graphingCalculator;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class SolveForXAndY {
//	static ArrayList<ArrayList> subEquations = new ArrayList<>();
//	public static void main(String[] args) {
//		
//		String yValue = "((x^2) + 5)/(x+5)";
//		solve(yValue);
//		
//	}
//	
//	public static double solve(String equation) {
//		String yValue = equation;
//		ArrayList<Character> yValueList = new ArrayList<>();
//		for (char el : yValue.toCharArray()) {
//			if (el != ' ') {//Removes spaces
//				yValueList.add(el);
//			}
//		}
//		System.out.println("yValueList1: " + yValueList);
//		
//		int endBracket = yValueList.indexOf(')');
//		ArrayList<Character> tempArray = new ArrayList<>();//Used to store the chars between the brackets
//		for (int i = 0; i < endBracket; i++) {
//			tempArray.add(yValueList.get(i));
//		}
//		
//		int firstBracket = tempArray.lastIndexOf('(');
//		System.out.println(firstBracket);
//		ArrayList<Character> subEquation = new ArrayList<>();
//		for (int i = firstBracket + 1; i < tempArray.size(); i++) {
//			subEquation.add(yValueList.get(i));
//		}
//		
//		subEquations.add(subEquation);
//		
//		yValueList.subList(firstBracket, endBracket + 1).clear();//Clears list between firstBracket (inclusive) and endBracket (exclusive)
//		
//		yValueList.add(firstBracket, 'A');
//		
//		//Recurs the method until all of the brackets are gone and everything that was inside a bracket was stored in subEquations
//		if (yValueList.contains('(') ) {
//			solve(yValueList.toString());
//		}
//		else {
//			System.out.println("subEquations: " + subEquations);
//			System.out.println("yValueList: " + yValueList);
//		}
//
//		return 0.0;//TODO
//	}
//}


