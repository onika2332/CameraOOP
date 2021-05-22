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
import georegression.metric.Area2D_F32;
import georegression.struct.line.LineSegment2D_F32;
import georegression.struct.point.Point2D_F32;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A polygon with 4 vertices, a,b,c, and d.  The vertices are in order sequential order of a,b,c,d.
 *
 */
@Generated("georegression.struct.shapes.Quadrilateral_F64")
public class Quadrilateral_F32 implements Serializable {
	public Point2D_F32 a;
	public Point2D_F32 b;
	public Point2D_F32 c;
	public Point2D_F32 d;

	public Quadrilateral_F32() {
		a = new Point2D_F32();
		b = new Point2D_F32();
		c = new Point2D_F32();
		d = new Point2D_F32();
	}

	public Quadrilateral_F32( Quadrilateral_F32 quad ) {
		this();
		a.setTo(quad.a);
		b.setTo(quad.b);
		c.setTo(quad.c);
		d.setTo(quad.d);
	}

	public Quadrilateral_F32( float x0, float y0 , float x1, float y1 ,
							  float x2, float y2 , float x3, float y3 ) {
		a = new Point2D_F32(x0,y0);
		b = new Point2D_F32(x1,y1);
		c = new Point2D_F32(x2,y2);
		d = new Point2D_F32(x3,y3);
	}

	public Quadrilateral_F32(Point2D_F32 a, Point2D_F32 b, Point2D_F32 c, Point2D_F32 d ) {
		this(a,b,c,d,true);
	}

	public Quadrilateral_F32(Point2D_F32 a, Point2D_F32 b, Point2D_F32 c, Point2D_F32 d, boolean copy ) {
		if( copy ) {
			this.a = new Point2D_F32(a);
			this.b = new Point2D_F32(b);
			this.c = new Point2D_F32(c);
			this.d = new Point2D_F32(d);
		} else {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}

	/**
	 * Returns the area of this quadrilateral
	 * @return area
	 */
	public float area() {
		return Area2D_F32.quadrilateral(this);
	}

	public Point2D_F32 get( int index ) {
		switch( index ) {
			case 0: return a;
			case 1: return b;
			case 2: return c;
			case 3: return d;
		}
		throw new IllegalArgumentException("Requested index out of range. "+index);
	}

	public Point2D_F32 getA() {
		return a;
	}

	public void setA(Point2D_F32 a) {
		this.a = a;
	}

	public Point2D_F32 getB() {
		return b;
	}

	public void setB(Point2D_F32 b) {
		this.b = b;
	}

	public Point2D_F32 getC() {
		return c;
	}

	public void setC(Point2D_F32 c) {
		this.c = c;
	}

	public Point2D_F32 getD() {
		return d;
	}

	public void setD(Point2D_F32 d) {
		this.d = d;
	}

	public LineSegment2D_F32 getLine( int which , LineSegment2D_F32 storage ) {
		if( storage == null )
			storage = new LineSegment2D_F32();

		switch( which ) {
			case 0: storage.a.setTo(a);storage.b.setTo(b);break;
			case 1: storage.a.setTo(b);storage.b.setTo(c);break;
			case 2: storage.a.setTo(c);storage.b.setTo(d);break;
			case 3: storage.a.setTo(d);storage.b.setTo(a);break;
			default:
				throw new IllegalArgumentException("Requested index out of range. "+which);
		}
		return storage;
	}

	public float getSideLength( int which ) {
		return (float)Math.sqrt(getSideLength2(which));
	}

	public float getSideLength2( int which ) {
		switch( which ) {
			case 0: return a.distance2(b);
			case 1: return b.distance2(c);
			case 2: return c.distance2(d);
			case 3: return d.distance2(a);
			default:
				throw new IllegalArgumentException("Requested index out of range. "+which);
		}
	}

	public void setTo(Quadrilateral_F32 quad) {
		this.a.setTo(quad.a);
		this.b.setTo(quad.b);
		this.c.setTo(quad.c);
		this.d.setTo(quad.d);
	}

	/**
	 * Converts the polygon into a list.
	 *
	 * @param storage (Optional) storage to put the vertexes into
	 * @param copy If points will be copied otherwise a reference of points will be returned
	 * @return List of vertexes
	 */
	public List<Point2D_F32> convert(@Nullable List<Point2D_F32> storage , boolean copy ) {
		if( storage == null )
			storage = new ArrayList<>();
		else
			storage.clear();

		if( copy ) {
			for (int i = 0; i < 4; i++) {
				storage.add( get(i).copy() );
			}
		} else {
			for (int i = 0; i < 4; i++) {
				storage.add( get(i) );
			}
		}
		return storage;
	}

	/**
	 * Sets the polygon to be the same as the list. A true copy is created and no references
	 * to points in the list are saved.
	 * @param list List which the polygon will be set to
	 */
	public void setTo(List<Point2D_F32> list ) {
		if( list.size() != 4 )
			throw new IllegalArgumentException("List must have size of 4");

		a.setTo(list.get(0));
		b.setTo(list.get(1));
		c.setTo(list.get(2));
		d.setTo(list.get(3));
	}

	public Quadrilateral_F32 copy() {
		return new Quadrilateral_F32(this);
	}

	/**
	 * Returns true if the two quadrilaterals are equal to each other to within tolerance.  Equality is defined
	 * by seeing if the distance between two equivalent vertexes is within tolerance.
	 *
	 * @param quad The second quadrilateral
	 * @param tol Maximum allowed distance between vertexes.
	 * @return true if equals or false if not
	 */
	public boolean isEquals( Quadrilateral_F32 quad , float tol ) {
		tol *= tol;

		if( a.distance2(quad.a) > tol )
			return false;
		if( b.distance2(quad.b) > tol )
			return false;
		if( c.distance2(quad.c) > tol )
			return false;
		return d.distance2(quad.d) <= tol;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"{" +
				"a=" + a +
				", b=" + b +
				", c=" + c +
				", d=" + d +
				'}';
	}
}
