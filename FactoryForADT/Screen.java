import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shapeModule.Point;
import shapeModule.Shapes;

public class Screen {

	List<Shapes> shapeList = new ArrayList<Shapes>();
	Point point = new Point();

	/**
	 * Function to add shape to screen
	 * 
	 * @param shapes
	 */
	public void addShape(Shapes shapes) {
		shapeList.add(shapes);
		System.out.println("Shape Added!!");
	}

	/**
	 * Function to display shapes present on screen
	 * 
	 * @throws Exception
	 */
	public void displayShapes(List<Shapes> listOfShapes) throws Exception {
		int i = 0;
		if (listOfShapes.size() == 0) {
			System.out.println("No Shape present in the screen !!");
			throw new Exception("No data in the List");
		}

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
	 */
	public void removeAllShapes() {
		shapeList.removeAll(shapeList);
		System.out.println("All Shape Removed from screen!!");
	}

	/**
	 * Function to sort shapes in ascending order according to area
	 * 
	 * @return name of shapes
	 * @throws Exception
	 */
	public void sortUsingArea() throws Exception {

		List<Shapes> listOfSortedShapes = new ArrayList<Shapes>(shapeList);
		for (int i = 0; i < (listOfSortedShapes.size() - 1); i++) {
			for (int j = 0; j < (listOfSortedShapes.size() - i - 1); j++) {
				if (listOfSortedShapes.get(j).getArea() > listOfSortedShapes
						.get(j + 1).getArea()) {
					Shapes shape = listOfSortedShapes.get(j);
					listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
					listOfSortedShapes.set(j + 1, shape);
				}
			}
		}
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
		for (int i = 0; i < (listOfSortedShapes.size() - 1); i++) {
			for (int j = 0; j < (listOfSortedShapes.size() - i - 1); j++) {
				if (listOfSortedShapes.get(j).getPerimeter() > listOfSortedShapes
						.get(j + 1).getPerimeter()) {
					Shapes shape = listOfSortedShapes.get(j);
					listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
					listOfSortedShapes.set(j + 1, shape);
				}
			}
		}
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
		for (int i = 0; i < (listOfSortedShapes.size() - 1); i++) {
			for (int j = 0; j < (listOfSortedShapes.size() - i - 1); j++) {
				if (listOfSortedShapes.get(j).getDate().after( listOfSortedShapes
						.get(j + 1).getDate()) ) {
					Shapes shape = listOfSortedShapes.get(j);
					listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
					listOfSortedShapes.set(j + 1, shape);
				}
			}
		}
		displayShapes(listOfSortedShapes);
	}

	/**
	 * Function to remove all the shapes from the screen
	 */
	public void displayEnclosedShape(Point point) throws Exception {
		int i = 0;
		if (shapeList.size() == 0) {
			System.out.println("No Shape present in the screen !!");
			throw new Exception("No data in the List");
		}

		Iterator<Shapes> iterator = shapeList.iterator();
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
