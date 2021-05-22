/*
 * Copyright (C) 2020, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Geometric Regression Library (GeoRegression).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package georegression.struct.shapes;

import javax.annotation.Generated;
import georegression.struct.point.Point3D_F32;

import java.io.Serializable;

/**
 * Specifies a Cylinder in 3D space which is bounded along the axis.  The axis line is specified using two points,
 * where the points are its end points.
 *
 * @author Peter Abeles
 */
@SuppressWarnings("NullAway.Init")
@Generated("georegression.struct.shapes.CylinderBounded3D_F64")
public class CylinderBounded3D_F32 implements Serializable {
	/**
	 * End points of the cylinder
	 */
	public Point3D_F32 endA, endB;

	/**
	 * Radius of the cylinder
	 */
	public float radius;

	public CylinderBounded3D_F32() {
		endA = new Point3D_F32();
		endB = new Point3D_F32();
	}

	public CylinderBounded3D_F32(float x_0, float y_0, float z_0,
								 float x_1, float y_1, float z_1,
								 float radius) {
		this();
		this.endA.setTo(x_0, y_0, z_0);
		this.endB.setTo(x_1, y_1, z_1);
		this.radius = radius;
	}

	public CylinderBounded3D_F32(Point3D_F32 endA, Point3D_F32 endB, float radius) {
		this();
		setTo(endA, endB,radius);
	}

	public CylinderBounded3D_F32(CylinderBounded3D_F32 o) {
		this();
		setTo(o);
	}

	/**
	 * Constructor which makes declaration of the two end points optional
	 *
	 * @param declare if true the end points will be declared, otherwise they will be initalized to null.
	 */
	public CylinderBounded3D_F32(boolean declare) {
		if( declare ) {
			endA = new Point3D_F32();
			endB = new Point3D_F32();
		}
	}

	public void setTo(float x_0, float y_0, float z_0,
					  float x_1, float y_1, float z_1,
					  float radius ) {
		this.endA.setTo(x_0, y_0, z_0);
		this.endB.setTo(x_1, y_1, z_1);
		this.radius = radius;
	}

	public void setTo(Point3D_F32 endA , Point3D_F32 endB , float radius ) {
		this.endA.setTo(endA);
		this.endB.setTo(endB);
		this.radius = radius;
	}

	public void setTo(CylinderBounded3D_F32 o ) {
		this.endA.setTo(o.endA);
		this.endB.setTo(o.endB);
		this.radius = o.radius;
	}

	public Point3D_F32 getEndA() {
		return endA;
	}

	public Point3D_F32 getEndB() {
		return endB;
	}

	public float getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" A( "+ endA.x+" "+ endA.y+" "+ endA.z+" ) B( "+ endB.x+" "+ endB.y+" "+ endB.z+" ) radius "+radius;
	}
}
