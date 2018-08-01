package shapeModule;

import java.util.Date;

public interface Shapes {

	public double getArea();

	public double getPerimeter();

	public String getOrigin();

	public String getShape();

	public boolean isEnclosed(Point point);

	public Date getDate();
}
