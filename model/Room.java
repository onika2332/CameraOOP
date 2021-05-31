package model;
import georegression.struct.point.Point3D_F32;
import java.util.List;
import java.util.ArrayList;

public class Room extends AbstractObject {
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
	
}
