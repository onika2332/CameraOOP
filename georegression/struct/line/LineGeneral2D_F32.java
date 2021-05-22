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
import georegression.geometry.UtilLine2D_F32;
import org.ejml.FancyPrint;

import java.io.Serializable;

/**
 * <p>
 * Represents the line using three parameters such that any point on the line obeys the
 * following formula, A*x + B*y + C = 0.  Any 2D line can be represented using this notation.
 * This formulation is also known as standard and implicit.  The slope is -A/B.
 * </p>
 * <p>
 * If it is said the line is normalized that refers to it being scaled such that A*A + B*B = 1.  To
 * normalize a line call {@link #normalize()}.  After normalization several operations become less expensive.
 * </p>
 *
 * @see UtilLine2D_F32
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.line.LineGeneral2D_F64")
public class LineGeneral2D_F32 implements Serializable {

	/**
	 * Coefficients which define the line.
	 */
	public float A,B,C;

	/**
	 * A*x + B*y + C = 0
	 *
	 * @param a parameter A
	 * @param b parameter B
	 * @param c parameter C
	 */
	public LineGeneral2D_F32(float a, float b, float c) {
		setTo(a,b,c);
	}

	public LineGeneral2D_F32(LineGeneral2D_F32 line ) {
		setTo(line);
	}

	public LineGeneral2D_F32() {
	}

	public float getA() {
		return A;
	}

	public float getB() {
		return B;
	}

	public float getC() {
		return C;
	}

	public void setTo( LineGeneral2D_F32 original ) {
		this.A = original.A;
		this.B = original.B;
		this.C = original.C;
	}

	/**
	 * A*x + B*y + C = 0
	 *
	 * @param a parameter A
	 * @param b parameter B
	 * @param c parameter C
	 */
	public void setTo(float a, float b, float c) {
		this.A = a;
		this.B = b;
		this.C = c;
	}

	public void setA(float a) {
		A = a;
	}

	public void setB(float b) {
		B = b;
	}

	public void setC(float c) {
		C = c;
	}

	/**
	 * Ensures that A*A + B*B == 1
	 */
	public void normalize() {
		float d = (float)Math.sqrt(A*A + B*B);
		A /= d;
		B /= d;
		C /= d;
	}

	/**
	 * Returns the result of A*x + B*y + C.  If the line is normalized then this is also the signed distance
	 * away from the line.
	 *
	 * @param x x-coordinate of a point
	 * @param y y-coordinate of a point
	 * @return result of line equation
	 */
	public float evaluate( float x , float y ) {
		return A*x + B*y + C;
	}

	public LineGeneral2D_F32 copy() {
		return new LineGeneral2D_F32(this);
	}

	@Override
	public String toString() {
		FancyPrint f = new FancyPrint();
		return getClass().getSimpleName()+"{ A="+f.s(A)+" B="+f.s(B)+" C="+f.s(C)+" }";
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(!(obj instanceof LineGeneral2D_F32))
			return false;

		var o = (LineGeneral2D_F32) obj;
		return A==o.A && B==o.B && C==o.C;
	}

	@Override
	public int hashCode() {
		return Float.hashCode(A+B+C);
	}
}
