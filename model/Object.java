package model;
import georegression.struct.point.Point3D_F32;
import java.util.List;
import java.util.ArrayList;
public class Object extends AbstractObject {
	
	// list of point on the top plane of object, we only need 4 point was the frame of plane, e.x 5,6,7,8
	List<Point3D_F32> topPlaneListPoint;
	
	// list of point on the 4 side plane of object, we only need 4 point was the frame of plane, e.x 1,2,3,4
	List<Point3D_F32> bottomPlaneListPoint;
	public Object(Point p1,
			Point p2,
			Point p3,
			Point p4,
			Point p5,
			Point p6,
			Point p7,
			Point p8) {
		super(p1,p2,p3,p4,p5,p6,p7,p8);
		// for() loop to assign point inside the object box is state.insideobject
		
		
		
	}
	
	
	
}
