package model;
import georegression.struct.point.Point3D_F32;
import java.util.List;
import java.util.ArrayList;

public class Room extends AbstractObject {
	// we use length, width, height for count volume of room ( = length * width * height )
	private float length;
	private float width;
	private float height;
	List<Plane> walls;
	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Room() {
		super();
	}
	
	public Room(Point p1, Point p2, Point p3, Point p4,
				Point p5, Point p6, Point p7, Point p8) {
		super(p1,p2,p3,p4,p5,p6,p7,p8);
	}
	
}
