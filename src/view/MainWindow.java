package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;

/**
 * Creates the main window for the calculator. This window contains a JTabbedPane at the top. The JTabbedPane contains the graphPanel and the yEqualsPanel
 * 
 * @author jeremyjacobson
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel graphPanel;
	private JPanel yEqualsPanel;


	/**
	 * Creates the Main Window
	 * 
	 */
	public MainWindow(JPanel graphPanel, JPanel yEqualsPanel) {
		this.graphPanel = graphPanel;
		this.yEqualsPanel = yEqualsPanel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = createTabbedPane();
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		yEqualsPanel = createYEqualsPanel();
		tabbedPane.addTab("Y=", yEqualsPanel);
		
		graphPanel = createGraphPanel();
		tabbedPane.addTab("Graph", graphPanel);
	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		return tabbedPane;
	}

	private JPanel createGraphPanel() {
		JPanel graphPanel = this.graphPanel;
		return graphPanel;
	}

	private JPanel createYEqualsPanel() {
		JPanel yEqualsPanel = this.yEqualsPanel;
		return yEqualsPanel;
	}
}
