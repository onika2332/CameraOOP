package model;
import georegression.struct.point.Point3D_F32;
import java.util.List;
import java.util.ArrayList;
public class Object extends AbstractObject {
	
	// list of point on the top plane of object
	List<Point3D_F32> topPlaneListPoint;
	
	// list of point on the 4 side plane of object
	List<Point3D_F32> sidePlaneListPoint;
	public Object(Point3D_F32 p1,
			Point3D_F32 p2,
			Point3D_F32 p3,
			Point3D_F32 p4,
			Point3D_F32 p5,
			Point3D_F32 p6,
			Point3D_F32 p7,
			Point3D_F32 p8) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.p8 = p8;
		
		
	}
	
	
	
}
