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

package georegression.struct.line;

import javax.annotation.Generated;
import georegression.struct.point.Point3D_F32;

import java.io.Serializable;


/**
 * Defines a line segment by its two end points.
 *
 * @see georegression.geometry.UtilLine3D_F32
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.line.LineSegment3D_F64")
public class LineSegment3D_F32 implements Serializable {
	public Point3D_F32 a = new Point3D_F32();
	public Point3D_F32 b = new Point3D_F32();

	public LineSegment3D_F32() {
	}

	public LineSegment3D_F32(Point3D_F32 a, Point3D_F32 b) {
		setTo( a, b );
	}

	public LineSegment3D_F32(float x0, float y0, float z0, float x1, float y1 , float z1) {
		setTo( x0, y0, z0, x1, y1, z1 );
	}
	
	public static LineSegment3D_F32 wrap( Point3D_F32 a , Point3D_F32 b ) {
		LineSegment3D_F32 ret = new LineSegment3D_F32();
		ret.a = a;
		ret.b = b;
		return ret;
	}

	public void setTo(LineSegment3D_F32 l ) {
		this.a.setTo( l.a );
		this.b.setTo( l.b );
	}

	public void setTo(Point3D_F32 a, Point3D_F32 b ) {
		this.a.setTo( a );
		this.b.setTo( b );
	}

	public void setTo(float x0, float y0, float z0, float x1, float y1 , float z1 ) {
		a.setTo( x0, y0, z0 );
		b.setTo( x1, y1, z1 );
	}

	public Point3D_F32 getA() {
		return a;
	}

	public void setA( Point3D_F32 a ) {
		this.a = a;
	}

	public Point3D_F32 getB() {
		return b;
	}

	public void setB( Point3D_F32 b ) {
		this.b = b;
	}

	public float slopeX() {
		return b.x-a.x;
	}

	public float slopeY() {
		return b.y-a.y;
	}

	public float getLength() {
		return a.distance(b);
	}

	public float getLength2() {
		return a.distance2(b);
	}

	public LineSegment3D_F32 copy() {
		return new LineSegment3D_F32( a, b );
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"{" +
				"a=" + a +
				", b=" + b +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(!(obj instanceof LineSegment3D_F32))
			return false;

		var o = (LineSegment3D_F32) obj;
		return a.equals(o.a) && b.equals(o.b);
	}

	@Override
	public int hashCode() {
		return a.hashCode() + b.hashCode();
	}
}
