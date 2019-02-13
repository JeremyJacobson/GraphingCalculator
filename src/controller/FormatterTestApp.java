package controller;

/**
 * Used to test the InputFormatter. Not necessary for calculator to work
 * 
 * @author jeremyjacobson
 *
 */
public class FormatterTestApp {

	public static void main(String[] args) {
		//PEMDAS
		
		//String unmodifiedEquation = "(2X^(2*log(4))+5)/ln(2X+5)";//2(X^(2*log(4)))+5/ln(2X+5)
		//String expectedReturn = "((2*(X^(2*(<L>(4))))+(10/2))/(<N>((2*X)+5)))";
		//String expectedReturn = "(((2*(X^(2*(<L>(4)))))+((10/2)))/(<N>((2*X)+5)))";
		
		//String expectedReturn = "(((2*(X^((2*(<L>(4))))))+(10/2))/(<N>((2*X)+5)))";
		String unmodifiedEquation = "sin(2/3.14)";
		InputFormatter myIF = new InputFormatter();
		myIF.formatString(unmodifiedEquation);
		
	}

}
