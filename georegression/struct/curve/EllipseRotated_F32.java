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

package georegression.struct.curve;

import javax.annotation.Generated;
import georegression.struct.point.Point2D_F32;

import java.io.Serializable;

/**
 * <p>
 * An ellipse described using its center, semi-axes, and orientation.<br>
 * (x'*cos(phi) + y'*sin(phi))^2/a^2 + (-x'*sin(phi) + y'*cos(phi))^2/b_2 = 1<br>
 * x' = x-x_0, y' = y-y_0<br>
 * where (x_0,y_0) is the center, (a,b) are major and minor axises, and phi is it's orientation.
 * </p>
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.curve.EllipseRotated_F64")
public class EllipseRotated_F32 implements Serializable {
	/**
	 * Center of the ellipse
	 */
	public Point2D_F32 center = new Point2D_F32();
	/**
	 * semi major-axis
	 */
	public float a;
	/**
	 * semi minor-axis
	 */
	public float b;
	/**
	 * counter clockwise angle of rotation from x-axis to the major axis.  Standard range is from -PI/2 to PI/2
	 */
	public float phi;

	/**
	 * Constructor
	 *
	 * @param center Ellipse center
	 * @param a major axis
	 * @param b minor axis
	 * @param phi orientation in radians
	 */
	public EllipseRotated_F32(Point2D_F32 center, float a, float b, float phi) {
		this.center.setTo(center);
		this.a = a;
		this.b = b;
		this.phi = phi;
	}

	/**
	 * Constructor
	 *
	 * @param x0 x coordinate of center
	 * @param y0 y coordinate of center
	 * @param a major axis
	 * @param b minor axis
	 * @param phi orientation in radians
	 */
	public EllipseRotated_F32( float x0 , float y0, float a, float b, float phi) {
		setTo(x0,y0,a,b,phi);
	}

	/**
	 * Copy constructor
	 *
	 * @param original Ellipse which is to be copied
	 */
	public EllipseRotated_F32( EllipseRotated_F32 original ) {
		this(original.center,original.getA(),original.getB(),original.getPhi());
	}

	public EllipseRotated_F32() {
	}

	public Point2D_F32 getCenter() {
		return center;
	}

	public void setCenter(Point2D_F32 center) {
		this.center.setTo(center);
	}

	/**
	 * Returns the major axis
	 * @return major axis
	 */
	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	/**
	 * Returns the minor axis
	 * @return minor axis
	 */
	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	/**
	 * Returns the orientation
	 * @return orientation is randians
	 */
	public float getPhi() {
		return phi;
	}

	public void setPhi(float phi) {
		this.phi = phi;
	}

	public void setTo(float x0 , float y0, float a, float b, float phi) {
		this.center.setTo(x0,y0);
		this.a = a;
		this.b = b;
		this.phi = phi;
	}

	public void setTo(EllipseRotated_F32 ellipse ) {
		this.center.setTo( ellipse.center );
		this.a = ellipse.a;
		this.b = ellipse.b;
		this.phi = ellipse.phi;
	}

	@Override
	public String toString() {
		return "EllipseRotated_F32{" +
				"center=" + center +
				", a=" + a +
				", b=" + b +
				", phi=" + phi +
				'}';
	}
}
