package model;

import java.util.ArrayList;

/**
 * Creates a list of X/Y points
 * 
 * @author jeremyjacobson
 *
 */
public class PointList {
	ArrayList<Point> pointList = new ArrayList<>();

	/**
	 * Creates the list
	 * 
	 * @param pointList
	 */
	public PointList(ArrayList<Point> pointList) {
		this.pointList = pointList;
	}

	/**
	 * Returns the list
	 * 
	 * @return
	 */
	public ArrayList<Point> getPointList() {
		return pointList;
	}
}
