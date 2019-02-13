package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import model.Point;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * A graph panel represents the cartesian plane on which we draw the graph
 * of our function.
 * 
 * @authors Michael Payne and Jeremy Jacobson
 */
@SuppressWarnings("serial")
public class GraphPanel extends JPanel 
{
	//Fields
	
	private int halfSide;
	private BufferedImage graphImage;
	private Graphics g;
	private Graphics2D g2;
	
	
	//Constructor
	
	/**
	 * Constructs and initializes a JPanel, BufferedImage, graphics artist
	 * for our buffered image (g2). Translates the coordinate system to center using
	 * halfside and draws the cartesian plane.
	 * 
	 * @param halfSide - Half side length of the panel. Panel always a square.
	 */
	public GraphPanel(int halfSide) 
	{
		this.halfSide = halfSide;
		setLayout(new BorderLayout(0, 0));		
		
		JPanel controlPanel = createControlPanel();
		add(controlPanel, BorderLayout.NORTH);
		
		JPanel graphAreaPanel = createGraphAreaPanel();
		add(graphAreaPanel, BorderLayout.CENTER);
	}


	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		controlPanel.setLayout(new GridLayout(1,0,0,0));
		JButton saveGraphBtn = new JButton("Save Graph Image");
		saveGraphBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		saveGraphBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		controlPanel.add(saveGraphBtn);
		
		JButton loadGraphBtn = new JButton("Load List of Points");
		loadGraphBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		loadGraphBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Point> loadedList = readTextList();
				
				drawFunction(loadedList,Color.RED);
				repaint();
			}
		});
		controlPanel.add(loadGraphBtn);
		return controlPanel;
	}


	private JPanel createGraphAreaPanel() {
		JPanel graphAreaPanel = new JPanel();
		graphAreaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		graphImage = new BufferedImage((2*halfSide)+2, 2*halfSide, BufferedImage.TYPE_3BYTE_BGR);
		g2 = (Graphics2D) graphImage.getGraphics();
		g2.translate(halfSide, halfSide);
		drawCartesianPlane();
		JLabel graph = new JLabel(new ImageIcon(graphImage));
		graphAreaPanel.add(graph);
		return graphAreaPanel;
	}
	
	
	//Methods
	
	/**
	 * Draws the cartesian coordinate system on our buffered image.
	 */
	public void drawCartesianPlane() 
	{
		//paint the background white using a rectangle due to buffered
		//image constraint
		g2.fillRect(-halfSide, -halfSide, (2*halfSide) + 2, 2*halfSide );
		
		//draw Cartesian Plane and grid network
		drawAxes();
	}
	
	
	/**
	 * Erases the graphed functions from the cartesian plane
	 */
	public void clearGraph()
	{
		g2.setColor(Color.WHITE);
		drawCartesianPlane();
	}
	
	
	//g graphics artist places the buffered image over the panel
	public void paintComponent(Graphics g) 
	{
		g.drawImage(graphImage, 0,0, null);	
	}
	
	
	/**
	 * Places the loaded graph image over the panel.
	 * 
	 * @param newImage - Buffered image to be placed on panel.
	 */
	public void hangLoadedGraph(BufferedImage newImage)
	{
		g.drawImage(newImage, 0,0, null);	
	}
	
	
	/**
	 * Draws x-axis, y-axis, and grid network
	 */
	public void drawAxes() 
	{
		//draw x & y axis units
		for( int i = -halfSide; i <= halfSide; i+=(halfSide/10) )
		{
			g2.setColor(Color.LIGHT_GRAY);
			//draw grid network
			//condition prevents the grid from overlapping
			//the x and y axis
			if( i != halfSide )
			{	
				//draw vertical grid
				g2.drawLine(i, -halfSide, i, halfSide);
				//draw horizontal grid
				g2.drawLine(-halfSide, i, halfSide, i);
			}
			
			//set paint color black for axes
			g2.setColor(Color.BLACK);
			
			//draw x axis units
			g2.drawLine(i, -(halfSide / 50), i, (halfSide / 50));
			
			//draw y axis units
			g2.drawLine(-(halfSide / 50), i, (halfSide / 50), i);
		}	
		
		//draw x-axis values
		g2.drawString("-10", -halfSide, -halfSide/50);
		g2.drawString("-5", -halfSide/2, -halfSide/50);
		g2.drawString("0", halfSide/50, -halfSide/50);
		g2.drawString("5", halfSide/2, -halfSide/50);
		g2.drawString("10", (int) (halfSide - halfSide/12.5), -halfSide/50);
		g2.drawString("x", (int) (halfSide - halfSide/12.5), halfSide/25);
		
		//draw y-axis values	
		g2.drawString("10", halfSide/50, -(halfSide - halfSide/25));
		g2.drawString("5", halfSide/50, -halfSide/2);
		g2.drawString("-5", halfSide/50, halfSide/2);
		g2.drawString("-10", halfSide/50, (halfSide - halfSide/50));
		g2.drawString("y", -halfSide/25, -(halfSide - halfSide/25));
	
		//draw axes
		g2.setColor(Color.BLACK);
		
		//draw y axis
		g2.drawLine(0, -halfSide, 0, halfSide);
		
		//draw x axis
		g2.drawLine(-halfSide, 0, halfSide, 0);
	}
	
	
	/**
	 * Draws the graph of our function using its point set and allows for
	 * color choice of graph.
	 * 
	 * @param points - Point set for our function.
	 * @param graphColor - Color of graph.
	 */
	public void drawFunction( ArrayList<Point> points, Color graphColor ) 
	{		
		//set paint to red
		g2.setColor(graphColor);
		
		//g.translate(halfSide, halfSide);
		//draws the points
		for(int i = 0; i < points.size() - 1; i++) 
		{
			//points.get(i).translate(halfSide, -halfSide);
			
			//Java will turn NaN or infinite results to 0 when drawing a line, 
			//this makes it so NaN and infinite results are drawn with a transparent color
			if ((Double.isNaN(points.get(i).getX()) || Double.isNaN(points.get(i).getY())) || 
				(Double.isNaN(points.get(i + 1).getX()) || Double.isNaN(points.get(i + 1).getY())) ||
				(Double.isInfinite(points.get(i).getX()) || Double.isInfinite(points.get(i).getY())) || 
				(Double.isInfinite(points.get(i + 1).getX()) || Double.isInfinite(points.get(i + 1).getY()))) {
				g2.setColor(new Color(0,0,0,0));
			} else {
				g2.setColor(graphColor);
			}
			
			g2.drawLine((int) points.get(i).getX(), (int) -points.get(i).getY(), 
					    (int) points.get(i + 1).getX(), (int) -points.get(i + 1).getY());
			
			System.out.printf("%f, %f%n", points.get(i).getX(), points.get(i).getY());
		}
	}
	
	
	/**
	 * Saves the graph image as a png file.
	 * 
	 */
	public void save() 
	{
        try 
        {
        	ImageIO.write(graphImage, "PNG", new File("src/view/Resources/GraphPicture.png"));
        }	
        catch(IOException e)
        {
        	System.out.println("File Error");
        }
        System.out.println("Save successful");
    }
	
	/**
	 * Returns the list of points from the file
	 * 
	 * @return
	 */
	public ArrayList<Point> readTextList()
	{
		ArrayList<Point> pointList = new ArrayList<>();
		
		try( Scanner input = new Scanner(new File("src/view/Resources/PointList.txt")))
		{
			while( input.hasNextLine() )
			{
				double x = input.nextDouble();
				double y = input.nextDouble();
				pointList.add(new Point(x, y));
				
				input.nextLine();
			}
			System.out.println("File read and List has been created");
			System.out.println(pointList);	
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("The File does Not Exist");
		}
		
		return pointList;
	}
}