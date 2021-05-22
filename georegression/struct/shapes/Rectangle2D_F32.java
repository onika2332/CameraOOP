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
import georegression.struct.point.Point2D_F32;

import java.io.Serializable;

/**
 * An axis aligned rectangle in 2D that is specified by its lower-extent p0, and upper-extent p1.
 */
@Generated("georegression.struct.shapes.Rectangle2D_F64")
public class Rectangle2D_F32 implements Serializable {
	/**
	 * Lower extent
	 */
	public Point2D_F32 p0 = new Point2D_F32();
	/**
	 * Upper extent
	 */
	public Point2D_F32 p1 = new Point2D_F32();

	public Rectangle2D_F32(float x0, float y0, float x1, float y1) {
		setTo(x0,y0,x1,y1);
	}

	public Rectangle2D_F32(Rectangle2D_F32 orig) {
		setTo(orig);
	}

	public void setTo(Rectangle2D_F32 orig ) {
		this.p0.setTo(orig.p0);
		this.p1.setTo(orig.p1);
	}

	public void setTo(float x0, float y0, float x1, float y1) {
		this.p0.setTo(x0,y0);
		this.p1.setTo(x1,y1);
	}

	public Rectangle2D_F32() { }

	/**
	 * Makes sure x0,y0 is the lower extent and x1,y1 is the upper extent
	 */
	public void enforceExtents() {
		if( p1.x < p0.x ) {
			float tmp = p1.x;
			p1.x = p0.x;
			p0.x = tmp;
		}
		if( p1.y < p0.y ) {
			float tmp = p1.y;
			p1.y = p0.y;
			p0.y = tmp;
		}
	}

	/**
	 * Returns true if all the extents are within tolerance.
	 * @param r Rectangle
	 * @param tol tolerance for equality. To be equal the difference must be less than or equal to this
	 * @return true if equal or false if not
	 */
	public boolean isEquals( Rectangle2D_F32 r , float tol ) {
		return isEquals(r.p0.x, r.p0.y, r.p1.x, r.p1.y, tol);
	}

	/**
	 * Returns true if all the extents are within tolerance.
	 * @param x0 lower extent. x-axis
	 * @param y0 lower extent. y-axis
	 * @param x1 upper extent. x-axis
	 * @param y1 upper extent. y-axis
	 * @param tol tolerance for equality. To be equal the difference must be less than or equal to this
	 * @return true if equal or false if not
	 */
	public boolean isEquals( float x0, float y0, float x1, float y1, float tol ) {
		if (Math.abs(x0-this.p0.x) > tol)
			return false;
		if (Math.abs(y0-this.p0.y) > tol)
			return false;
		if (Math.abs(x1-this.p1.x) > tol)
			return false;
		return !(Math.abs(y1 - this.p1.y) > tol);
	}


	public float getWidth() {
		return p1.x-p0.x;
	}

	public float getHeight() {
		return p1.y-p0.y;
	}

	public float area() {
		return ( p1.y-p0.y)*(p1.x-p0.x);
	}

	public Point2D_F32 getP0() {
		return p0;
	}

	public void setP0(Point2D_F32 p0) {
		this.p0 = p0;
	}

	public Point2D_F32 getP1() {
		return p1;
	}

	public void setP1(Point2D_F32 p1) {
		this.p1 = p1;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"{ p0("+p0.x+" "+p0.y+") p1("+p1.x+" "+p1.y+") }";
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(!(obj instanceof Rectangle2D_F32))
			return false;

		var o = (Rectangle2D_F32) obj;
		return p0.x==o.p0.x&&p0.y==o.p0.y&&p1.x==o.p1.x&&p1.y==o.p1.y;
	}

	@Override
	public int hashCode() {
		return p0.hashCode()+p1.hashCode();
	}
}
