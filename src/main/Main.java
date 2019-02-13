package main;

import java.awt.EventQueue;
import view.GraphPanel;
import view.MainWindow;
import view.YEqualsPanel;

/**
 * Contains the Main method that runs the Calculator.
 * Initializes the graphPanel and the yEqualsPanel.
 * 
 * @author jeremyjacobson
 *
 */
public class Main {

	public static void main(String[] args) {
		GraphPanel graphPanel = new GraphPanel(250);
		YEqualsPanel yEqualsPanel = new YEqualsPanel(graphPanel);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(graphPanel, yEqualsPanel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
