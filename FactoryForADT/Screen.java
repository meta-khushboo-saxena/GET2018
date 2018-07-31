import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shapeModule.Shapes;

public class Screen {

	List<Shapes> shapeList = new ArrayList<Shapes>();

	public void addShape(Shapes shapes) {
		shapeList.add(shapes);
		System.out.println("Shape Added!!");
	}

	public void displayShapes() throws Exception {
		int i=0;
		if(shapeList.size()==0){
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
	
	public void removeShapes(int index){
		Shapes shape = shapeList.get(index);
		shapeList.remove(shape);
		System.out.println("Shape Removed from screen!!");
	}
	
	public void removeAllShapes(){       
        shapeList.removeAll(shapeList);
        System.out.println("All Shape Removed from screen!!");
    }
	
	  public String[] displayinAscending() throws Exception {

	        String shapeNAmes[] = new String[shapeList.size()];

	        for (int i = 0; i < shapeNAmes.length; i++) {
	            shapeNAmes[i] = shapeList.get(i).getShape();
	        }
	        if(shapeList.size()==0){
	            System.out.println("No Shape present in the screen !!");
	            throw new Exception("No data in the List");
	        }
	        int i = 0;
	        while (i < shapeList.size()){
	            int j = 0;
	            while (j < (shapeList.size() - 1) - i) {

	                if (shapeList.get(j).getArea() > shapeList.get(j + 1)
	                        .getArea()) {

	                    String temporary = shapeNAmes[j];
	                    shapeNAmes[j] = shapeNAmes[j + 1];
	                    shapeNAmes[j + 1] = temporary;

	                }
	                j++;
	            }
	            i++;
	        }

	        return shapeNAmes;
	    }
}
