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
	public void displayShapes() throws Exception {
		int i = 0;
		if (shapeList.size() == 0) {
			System.out.println("No Shape present in the screen !!");
			throw new Exception("No data in the List");
		}

		Iterator<Shapes> iterator = shapeList.iterator();
		while (iterator.hasNext()) {
			Shapes shapes = shapeList.get(i);
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
	 * Function to display shapes in ascending order according to area of shapes
	 * 
	 * @return name of shapes
	 * @throws Exception
	 */
	public String[] displayinAscending() throws Exception {

		String shapeNames[] = new String[shapeList.size()];

		for (int i = 0; i < shapeNames.length; i++) {
			shapeNames[i] = shapeList.get(i).getShape();
		}
		if (shapeList.size() == 0) {
			System.out.println("No Shape present in the screen !!");
			throw new Exception("No data in the List");
		}
		int i = 0;
		while (i < shapeList.size()) {
			int j = 0;
			while (j < (shapeList.size() - 1) - i) {

				if (shapeList.get(j).getArea() > shapeList.get(j + 1).getArea()) {

					String temporary = shapeNames[j];
					shapeNames[j] = shapeNames[j + 1];
					shapeNames[j + 1] = temporary;

				}
				j++;
			}
			i++;
		}
		return shapeNames;
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
