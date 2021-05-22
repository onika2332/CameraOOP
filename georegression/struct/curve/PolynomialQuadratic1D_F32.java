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
import org.ejml.FancyPrint;

/**
 * Quadratic curve in 1D: f(x) = a + bx + c x<sup>2</sup>.
 *
 * <p>NOTE: The coefficient order is the reverse of what you will find for sake of consistency as the order
 * of the polynomial is increased.</p>
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.curve.PolynomialQuadratic1D_F64")
public class PolynomialQuadratic1D_F32 implements PolynomialCurve_F32 {
	/**
	 * Coefficients
	 */
	public float a,b,c;

	public PolynomialQuadratic1D_F32(){}

	public PolynomialQuadratic1D_F32(float a, float b , float c){
		this.a = a; this.b = b; this.c = c;
	}

	public float evaluate( float t ) {
		return a + b*t + c*t*t;
	}

	public void setTo(float a, float b , float c ) {
		this.a = a; this.b = b; this.c = c;
	}

	public void setTo(PolynomialQuadratic1D_F32 src ) {
		this.a = src.a; this.b = src.b; this.c = src.c;
	}

	@Override
	public String toString() {
		FancyPrint fp = new FancyPrint();
		return "PolynomialQuadratic1D_F32{" +
				"a=" + fp.p(a) +
				", b=" + fp.p(b) +
				", c=" + fp.p(c) +
				'}';
	}

	@Override
	public float get(int coefficient) {
		switch( coefficient ) {
			case 0: return a;
			case 1: return b;
			case 2: return c;
		}
		throw new IllegalArgumentException("Coefficient out of range. "+coefficient);
	}

	@Override
	public void set(int coefficient, float value) {
		switch( coefficient ) {
			case 0: a=value;return;
			case 1: b=value;return;
			case 2: c=value;return;
		}
		throw new IllegalArgumentException("Coefficient out of range. "+coefficient);
	}

	@Override
	public int size() {
		return 3;
	}

	@Override
	public int degree() {
		return 2;
	}
}
