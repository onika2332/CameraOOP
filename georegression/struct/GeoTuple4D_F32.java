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

package georegression.struct;


import javax.annotation.Generated;
import org.ejml.UtilEjml;
import org.ejml.ops.MatrixIO;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Generic Tuple for geometric objects that store (x,y,z,w)
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.GeoTuple4D_F64")
public abstract class GeoTuple4D_F32 <T extends GeoTuple4D_F32> extends GeoTuple_F32<T> {
	public float x;
	public float y;
	public float z;
	public float w;

	protected GeoTuple4D_F32(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	protected GeoTuple4D_F32() {}

	@Override
	public int getDimension() {
		return 4;
	}

	protected void _setTo(GeoTuple4D_F32 a ) {
		x = a.x;
		y = a.y;
		z = a.z;
		w = a.w;
	}

	public void setTo(float x, float y, float z , float w ) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public boolean isIdentical( float x, float y, float z , float w ) {
		return ( this.x == x && this.y == y && this.z == z && this.w == w);
	}

	public boolean isIdentical( float x, float y, float z, float w , float tol ) {
		return ( (float)Math.abs( this.x - x ) <= tol && 
				(float)Math.abs( this.y - y ) <= tol && 
				(float)Math.abs( this.z - z ) <= tol && 
				(float)Math.abs( this.w - w ) <= tol );
	}

	@Override
	public boolean isIdentical( GeoTuple4D_F32 t, float tol ) {
		return ( (float)Math.abs( this.x - t.x ) <= tol && 
				(float)Math.abs( this.y - t.y ) <= tol && 
				(float)Math.abs( this.z - t.z ) <= tol &&
				(float)Math.abs( this.w - t.w ) <= tol );
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getW() {
		return w;
	}

	@Override
	public float getIdx(int index ) {
		switch( index ) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			case 3: return w;
			default: throw new IllegalArgumentException( "Invalid index" );
		}
	}

	@Override
	public void setIdx(int index, float value ) {
		switch( index ) {
			case 0: x = value; break;
			case 1: y = value; break;
			case 2: z = value; break;
			case 3: w = value; break;
			default: throw new IllegalArgumentException( "Invalid index "+index );
		}
	}

	public void scale( float scalar ) {
		x *= scalar;
		y *= scalar;
		z *= scalar;
		w *= scalar;
	}

	/**
	 * <p>In-place addition</p>
	 *
	 * this.x = this.x + a.x;
	 *
	 * @param a value which is to be added
	 */
	public void plusIP( GeoTuple4D_F32 a ) {
		x += a.x;
		y += a.y;
		z += a.z;
		w += a.w;
	}

	public T times( float scalar ) {
		T ret = createNewInstance();
		ret.x = x*scalar;
		ret.y = y*scalar;
		ret.z = z*scalar;
		ret.w = w*scalar;
		return ret;
	}

	/**
	 * In-place scalar multiplication
	 * @param scalar value that it is multiplied by
	 */
	public void timesIP( float scalar ) {
		x *= scalar;
		y *= scalar;
		z *= scalar;
		w *= scalar;
	}

	public void divideIP( float scalar ) {
		x /= scalar;
		y /= scalar;
		z /= scalar;
		w /= scalar;
	}

	public void normalize() {
		divideIP( norm() );
	}

	@Override
	public float norm() {
		return (float)Math.sqrt( x * x + y * y + z * z + w * w);
	}

	@Override
	public float normSq() {
		return x * x + y * y + z * z + w * w;
	}

	@Override
	public float distance( GeoTuple4D_F32 t ) {
		float dx = t.x - x;
		float dy = t.y - y;
		float dz = t.z - z;
		float dw = t.w - w;

		return (float)Math.sqrt( dx * dx + dy * dy + dz * dz + dw * dw);
	}

	public float distance( float x , float y , float z , float w ) {
		float dx = this.x - x;
		float dy = this.y - y;
		float dz = this.z - z;
		float dw = this.w - w;

		return (float)Math.sqrt( dx * dx + dy * dy + dz * dz + dw * dw);
	}

	@Override
	public float distance2( GeoTuple4D_F32 t ) {
		float dx = t.x - x;
		float dy = t.y - y;
		float dz = t.z - z;
		float dw = t.w - w;

		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	public float distance2( float x , float y , float z , float w ) {
		float dx = this.x - x;
		float dy = this.y - y;
		float dz = this.z - z;
		float dw = this.w - w;

		return dx * dx + dy * dy + dz * dz + dw * dw;
	}

	public void print() {
		System.out.println( this );
	}

	public boolean isNaN() {
		return ( Float.isNaN( x ) || Float.isNaN( y ) || Float.isNaN( z ) || Float.isNaN( w ));
	}

	public void setX( float x ) {
		this.x = x;
	}

	public void setY( float y ) {
		this.y = y;
	}

	public void setZ( float z ) {
		this.z = z;
	}

	public void setW( float w ) {
		this.w = w;
	}

	/**
	 * Returns the absolute value of the component with the largest absolute value
	 * @return max absolute value
	 */
	public float maxAbs() {
		float absX = (float)Math.abs(x);
		float absY = (float)Math.abs(y);
		float absZ = (float)Math.abs(z);
		float absW = (float)Math.abs(w);

		float found = (float)Math.max(absX,absY);
		if( found < absZ )
			found = absZ;
		if( found < absW )
			found = absW;
		return found;
	}

	@Override
	public void setTo(T src) {
		this.x = src.x;
		this.y = src.y;
		this.z = src.z;
		this.w = src.w;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(!(obj instanceof GeoTuple4D_F32))
			return false;

		var o = (GeoTuple4D_F32)obj;
		return Float.compare(x,o.x)==0 && Float.compare(y,o.y)==0 &&
				Float.compare(z,o.z)==0 && Float.compare(w,o.w)==0;
	}

	protected String toString( String name ) {
		DecimalFormat format = new DecimalFormat("#");
		String sx = UtilEjml.fancyString(x,format, MatrixIO.DEFAULT_LENGTH,4);
		String sy = UtilEjml.fancyString(y,format, MatrixIO.DEFAULT_LENGTH,4);
		String sz = UtilEjml.fancyString(z,format, MatrixIO.DEFAULT_LENGTH,4);
		String sw = UtilEjml.fancyString(w,format, MatrixIO.DEFAULT_LENGTH,4);

		return name+"( " + sx + " " + sy + " " + sz + " " + sw + " )";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z, w);
	}
}
