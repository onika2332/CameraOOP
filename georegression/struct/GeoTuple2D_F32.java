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
 * Generic Tuple for geometric objects that store (x,y)
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.GeoTuple2D_F64")
public abstract class GeoTuple2D_F32 <T extends GeoTuple2D_F32> extends GeoTuple_F32<T> {
	public float x;
	public float y;

	protected GeoTuple2D_F32( float x, float y ) {
		this.x = x;
		this.y = y;
	}

	protected GeoTuple2D_F32() {}

	protected void _setTo(GeoTuple2D_F32 a ) {
		x = a.x;
		y = a.y;
	}

	public void setTo(float x, float y ) {
		this.x = x;
		this.y = y;
	}

	public boolean isIdentical( float x, float y ) {
		return this.x == x && this.y == y;
	}

	public boolean isIdentical( float x, float y, float tol ) {
		return ( (float)Math.abs( this.x - x ) <= tol && (float)Math.abs( this.y - y ) <= tol );
	}

	@Override
	public boolean isIdentical( T t, float tol ) {
		return ( (float)Math.abs( this.x - t.x ) <= tol && (float)Math.abs( this.y - t.y ) <= tol );
	}

	public void setX( float x ) {
		this.x = x;
	}

	public void setY( float y ) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	/**
	 * <p>In-place addition</p>
	 *
	 * this.x = this.x + a.x;
	 *
	 * @param a value which is to be added
	 */
	public void plusIP( GeoTuple2D_F32 a ) {
		x += a.x;
		y += a.y;
	}

	/**
	 * <p>Addition</p>
	 *
	 * ret.x = this.x + a.x;
	 *
	 * @param a value which is to be added
	 */
	public T plus( GeoTuple2D_F32 a ) {
		T ret = createNewInstance();
		ret.x = x + a.x;
		ret.y = y + a.y;
		return ret;
	}

	/**
	 * In-place scalar multiplication
	 * @param scalar value that it is multiplied by
	 */
	public void timesIP( float scalar ) {
		x *= scalar;
		y *= scalar;
	}

	/**
	 * In-place scalar multiplication
	 * @param scalar value that it is multiplied by
	 */
	public void scale( float scalar ) {
		x *= scalar;
		y *= scalar;
	}

	/**
	 * Scalar multiplication
	 * @param scalar value which is it multiplied by
	 * @return new matrix which is the original scaled
	 */
	public T times( float scalar ) {
		T ret = createNewInstance();
		ret.x = x*scalar;
		ret.y = y*scalar;
		return ret;
	}

	/**
	 * Euclidean distance from the point
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return distance
	 */
	public float distance( float x , float y ) {
		float dx = x - this.x;
		float dy = y - this.y;

		return (float)Math.sqrt(dx*dx + dy*dy);
	}

	/**
	 * Euclidean squared distance from the point
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return distance squared
	 */
	public float distance2( float x , float y ) {
		float dx = x - this.x;
		float dy = y - this.y;

		return dx*dx + dy*dy;
	}

	@Override
	public void setTo(T src) {
		this.x = src.x;
		this.y = src.y;
	}

	@Override
	public float distance( T t ) {
		float dx = t.x - x;
		float dy = t.y - y;

		return (float)Math.sqrt( dx * dx + dy * dy );
	}

	@Override
	public float distance2( T t ) {
		float dx = t.x - x;
		float dy = t.y - y;

		return dx * dx + dy * dy;
	}

	@Override
	public float getIdx(int index ) {
		switch( index ) {
			case 0:
				return x;

			case 1:
				return y;

			default:
				throw new IllegalArgumentException( "Invalid index" );
		}
	}

	@Override
	public void setIdx(int index, float value ) {
		switch( index ) {
			case 0:
				x = value;
				break;

			case 1:
				y = value;
				break;

			default:
				throw new IllegalArgumentException( "Invalid index" );
		}
	}

	@Override
	public float norm() {
		return (float)Math.sqrt( x * x + y * y );
	}

	@Override
	public float normSq() {
		return x * x + y * y;
	}

	@Override
	public int getDimension() {
		return 2;
	}

	public void print() {
		System.out.println( this );
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if( this.getClass() != obj.getClass() )
			return false;

		var o = (GeoTuple2D_F32)obj;
		return Float.compare(x,o.x)==0 && Float.compare(y,o.y)==0;
	}

	public boolean isNaN() {
		return ( Float.isNaN( x ) || Float.isNaN( y ));
	}

	protected String toString( String name ) {
		DecimalFormat format = new DecimalFormat("#");
		String sx = UtilEjml.fancyString(x,format, MatrixIO.DEFAULT_LENGTH,4);
		String sy = UtilEjml.fancyString(y,format, MatrixIO.DEFAULT_LENGTH,4);

		return name+"( " + sx + " " + sy + " )";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}