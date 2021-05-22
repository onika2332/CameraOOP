package model;
import georegression.struct.point.Point3D_F32;


public class Vector {
	private float param1;
	private float param2;
	private float param3;
	public float getParam1() {
		return param1;
	}
	public float getParam2() {
		return param2;
	}
	public float getParam3() {
		return param3;
	}
	
	public Vector(float x, float y, float z) {
		this.param1 = x;
		this.param2 = y;
		this.param3 = z;
	}
	
	public Vector(Point3D_F32 p1, Point3D_F32 p2) {
		this.param1 = p1.getX() - p2.getX();
		this.param2 = p1.getY() - p2.getY();
		this.param3 = p1.getZ() - p2.getZ();
	}
	
	
}
