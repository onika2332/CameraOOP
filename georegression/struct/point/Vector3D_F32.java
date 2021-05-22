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

package georegression.struct.point;

import javax.annotation.Generated;
import georegression.geometry.GeometryMath_F32;
import georegression.geometry.UtilVector3D_F32;
import georegression.struct.GeoTuple3D_F32;

/**
 * Spacial vector in 3D
 *
 */
@Generated("georegression.struct.point.Vector3D_F64")
public class Vector3D_F32 extends GeoTuple3D_F32<Vector3D_F32> {

	public Vector3D_F32( GeoTuple3D_F32 orig ) {
		this(orig.x,orig.y,orig.z);
	}

	public Vector3D_F32( float x, float y, float z ) {
		super( x, y, z );
	}

	public Vector3D_F32() {}

	public Vector3D_F32( Point3D_F32 a, Point3D_F32 b ) {
		x = b.getX() - a.getX();
		y = b.getY() - a.getY();
		z = b.getZ() - a.getZ();
	}

	@Override
	public void setTo( Vector3D_F32 v ) {
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}

	/**
	 * In-place minus operation. this = a - b.
	 *
	 * @param a Point
	 * @param b Point
	 */
	public void minus( Point3D_F32 a , Point3D_F32 b ) {
		x = a.x - b.x;
		y = a.y - b.y;
		z = a.z - b.z;
	}

	/**
	 * In-place divide operation.  x /= value;
	 * @param value The value each component is divided by
	 */
	public void divide( float value ) {
		x /= value;
		y /= value;
		z /= value;
	}

	@Override
	public Vector3D_F32 copy() {
		return new Vector3D_F32( x, y, z );
	}

	/**
	 * In-place cross product operation.  this = a cross b
	 *
	 * @param a Vector
	 * @param b Vector
	 */
	public void cross( Vector3D_F32 a, Vector3D_F32 b ) {
		GeometryMath_F32.cross( a, b, this );
	}

	public Vector3D_F32 cross( Vector3D_F32 b ) {
		Vector3D_F32 c = new Vector3D_F32();
		GeometryMath_F32.cross( this, b, c );

		return c;
	}

	@Override
	public Vector3D_F32 createNewInstance() {
		return new Vector3D_F32();
	}

	@Override
	public String toString() {
		return toString("V");
	}

	public void normalize() {
		// carefully normalize to avoid numerical overflow
		float m = (float)Math.max(Math.max(Math.abs(x),Math.abs(y)),Math.abs(z));

		float x_n = x/m;
		float y_n = y/m;
		float z_n = z/m;
		float v = (float)Math.sqrt(x_n*x_n + y_n*y_n + z_n*z_n);

		x = x_n/v;
		y = y_n/v;
		z = z_n/v;
	}

	/**
	 * Dot product between this and 'a' = this.x * a.x + this.y * a.y + this.z * a.z
	 *
	 * @param a A vector
	 * @return dot product.
	 */
	public float dot( Vector3D_F32 a ) {
		return x * a.x + y * a.y + z * a.z;
	}

	/**
	 * Returns the acute angle between the two vectors.  Computed using the dot product.
	 * @param a Vector
	 * @return Acute angle in radians between 'this' and 'a'.
	 */
	public float acute( Vector3D_F32 a ) {
		return UtilVector3D_F32.acute(this,a);
	}
}
