package model;
import georegression.struct.point.Point3D_F32;

public class Camera extends Point3D_F32 {
	private int angle; 
	private int longitude;
	public int getAngle() {
		return angle;
	}

	public int getLongitude() {
		return longitude;
	}
	
	public Camera(float x, float y, float z, int angle, int longitude) {
		super(x,y,z);
		this.angle = angle;
		this.longitude = longitude;
	}
	
	
}
