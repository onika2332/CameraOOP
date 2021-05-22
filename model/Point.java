package model;
import georegression.struct.point.Point3D_F32;
public class Point extends Point3D_F32 {
	public State state;
	
	Point(State newState) {
		super();
		this.state = newState.Available;
	}
}
