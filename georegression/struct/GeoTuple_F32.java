/*
 * Copyright (C) 2011-2020, Peter Abeles. All Rights Reserved.
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
/**
 * Describes geometric objects that are composed of N float values.  Where N is the dimension
 * of space the object is contained in.  Points and vectors are two examples of a GeoTuple.  Each
 * value is the value of the object along a dimension in the space it occupies.
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.GeoTuple_F64")
public abstract class GeoTuple_F32 <T extends GeoTuple_F32> extends GeoTuple<T> {

	/**
	 * Checks to see if the two GeoTuple have values which are nearly the same.  False is always
	 * returned if the dimension is different.
	 *
	 * @param t   The GeoTuple it is being compared against.
	 * @param tol How similar each element must be for them to be considered identical.
	 * @return if they are identical or not.
	 */
	public boolean isIdentical( T t, float tol ) {
		if( t.getDimension() != getDimension() )
			return false;

		int N = getDimension();
		for( int i = 0; i < N; i++ ) {
			float diff = (float)Math.abs( getIdx( i ) - t.getIdx( i ) );

			if( diff > tol )
				return false;
		}

		return true;
	}

	/**
	 * Generic copy routine.  It is recommended that this be overridden with a faster implementation.
	 *
	 * @return An exact copy of this GeoTuple.
	 */
	@Override
	public T copy() {
		T ret = createNewInstance();

		int N = getDimension();
		for( int i = 0; i < N; i++ ) {
			ret.setIdx( i, getIdx( i ) );
		}

		return ret;
	}

	/**
	 * Computes the  Euclidean norm.
	 *
	 * @return norm.
	 */
	public float norm() {
		return (float) (float)Math.sqrt( normSq() );
	}

	/**
	 * Computes the square of the Euclidean norm.
	 *
	 * @return norm squared.
	 */
	public float normSq() {
		float total = 0;
		int N = getDimension();
		for( int i = 0; i < N; i++ ) {
			float a = getIdx( i );
			total += a * a;
		}

		return total;
	}

	public float distance( T t ) {
		return (float)Math.sqrt( distance2( t ) );
	}

	public float distance2( T t ) {
		if( t.getDimension() != getDimension() )
			throw new IllegalArgumentException( "Dimension of input tuple does not match" );

		float total = 0;
		final int N = getDimension();
		for( int i = 0; i < N; i++ ) {
			float diff = (float)Math.abs( getIdx( i ) - t.getIdx( i ) );

			total += diff * diff;
		}

		return total;
	}

	/**
	 * Returns the value of the tuple along the specified coordinate system axis.
	 *
	 * @param index Which axis in the coordinate system.
	 * @return Its value.
	 */
	public abstract float getIdx(int index );

	public abstract void setIdx(int index, float value );

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(!(obj instanceof GeoTuple_F32))
			return false;

		var o = (GeoTuple_F32)obj;
		final int N = getDimension();

		if( N != o.getDimension() )
			return false;
		for( int i = 0; i < N; i++ ) {
			if( getIdx(i) != o.getIdx(i))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int N = getDimension();
		int hash = 0;
		for (int i = 0; i < N; i++) {
			hash += Float.hashCode(getIdx(i));
		}
		return hash;
	}
}
