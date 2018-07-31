package shapeModule;

import java.util.Date;

public interface Shapes {

	float getArea();
	float getPerimeter();
	String getOrigin();
	String getShape();
	boolean isEnclosed(Point point);
	Date getDate();
}
