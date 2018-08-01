import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import shapeModule.Point;
import shapeModule.Shapes;

public class Screen {

	List<Shapes> shapeList = new ArrayList<Shapes>();

	/**
	 * Function to add shape to screen
	 * 
	 * @param shapes
	 */
	public void addShape(Shapes shapes) {
		shapeList.add(shapes);
		System.out.println("Shape Added!!\n");
	}

	/**
	 * Function to display shapes present on screen
	 * 
	 * @throws Exception
	 */
	public void displayShapes(List<Shapes> listOfShapes) throws Exception {
		int i = 0;
		if (listOfShapes.size() == 0) {
			System.out.println("No Shape present in the screen !!\n");
		} else {

			Iterator<Shapes> iterator = listOfShapes.iterator();
			while (iterator.hasNext()) {
				Shapes shapes = listOfShapes.get(i);
				System.out.println("Index: " + i);
				System.out.println("Shape: " + shapes.getShape());
				System.out.println("Area: " + shapes.getArea());
				System.out.println("Perimeter: " + shapes.getPerimeter());
				System.out.println("Origin: " + shapes.getOrigin());
				System.out.println("Date: " + shapes.getDate());
				System.out.println();
				i++;
				iterator.next();
			}
		}
	}

	/**
	 * Function to remove shape from the screen
	 * 
	 * @param index
	 */
	public void removeShapes(int index) {
		Shapes shape = shapeList.get(index);
		shapeList.remove(shape);
		System.out.println("Shape Removed from screen!!");
	}

	/**
	 * Function to remove all the shapes from the screen
	 * 
	 * @throws Exception
	 */
	public void removeAllShapes() throws Exception {
		if (shapeList.size() == 0) {
			System.out.println("No Shape present in the screen !!\n");
		} else {
			shapeList.removeAll(shapeList);
			System.out.println("All Shape Removed from screen!!");
		}
	}

	/**
	 * Function to sort shapes in ascending order according to area
	 * 
	 * @return name of shapes
	 * @throws Exception
	 */
	public void sortUsingArea() throws Exception {
		List<Shapes> listOfSortedShapes = new ArrayList<Shapes>(shapeList);
		Comparator<Shapes> compareArea = new Comparator<Shapes>() {

			public int compare(Shapes shape1, Shapes shape2) {
				float area1 = shape1.getArea();
				float area2 = shape2.getArea();

				// sort in ascending order
				return (int) (area1 - area2);
			}
		};
		Collections.sort(listOfSortedShapes, compareArea);
		displayShapes(listOfSortedShapes);
	}

	/**
	 * Function to sort shapes in ascending order according to perimeter
	 * 
	 * @return name of shapes
	 * @throws Exception
	 */
	public void sortUsingPerimeter() throws Exception {
		List<Shapes> listOfSortedShapes = new ArrayList<Shapes>(shapeList);
		Comparator<Shapes> comparePerimeter = new Comparator<Shapes>() {

			public int compare(Shapes shape1, Shapes shape2) {
				float perimeter1 = shape1.getPerimeter();
				float perimeter2 = shape2.getPerimeter();

				// sort in ascending order
				return (int) (perimeter1 - perimeter2);
			}
		};
		Collections.sort(listOfSortedShapes, comparePerimeter);
		displayShapes(listOfSortedShapes);
	}

	/**
	 * Function to sort shapes in ascending order according to TimeStamp
	 * 
	 * @return name of shapes
	 * @throws Exception
	 */
	public void sortUsingTimeStamp() throws Exception {
		List<Shapes> listOfSortedShapes = new ArrayList<Shapes>(shapeList);
		Comparator<Shapes> compareTime = new Comparator<Shapes>() {

			public int compare(Shapes shape1, Shapes shape2) {
				Date date1 = shape1.getDate();
				Date date2 = shape2.getDate();

				// sort in ascending order
				return date1.compareTo(date2);
			}
		};
		Collections.sort(listOfSortedShapes, compareTime);
		displayShapes(listOfSortedShapes);
	}

	/**
	 * Function to remove all the shapes from the screen
	 */
	public void displayEnclosedShape(Point point) throws Exception {
		int i = 0;
		Iterator<Shapes> iterator = shapeList.iterator();
		System.out.println("Shape containing the point are:\n");
		while (iterator.hasNext()) {

			Shapes shapes = shapeList.get(i);
			if (shapes.isEnclosed(point)) {
				System.out.println("Shape: " + shapes.getShape());
				System.out.println("Area: " + shapes.getArea());
				System.out.println("Perimeter: " + shapes.getPerimeter());
				System.out.println("Origin: " + shapes.getOrigin());
				System.out.println("Date: " + shapes.getDate());
				System.out.println();
				i++;
			}
			iterator.next();
		}
	}
}
