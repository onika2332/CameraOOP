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

/**
 * Parametric form of parabola with 4 parameters.
 *
 * <p> x=A*t<sup>2</sup> + B*t + C<br>
 *     y=D*t<sup>2</sup> + E*t + F</p>
 *
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.curve.ParabolaParametric_F64")
public class ParabolaParametric_F32 {
	public float A,B,C,D,E,F;

	public ParabolaParametric_F32(){}

	public ParabolaParametric_F32(ParabolaParametric_F32 src){setTo(src);}

	public void setTo( ParabolaParametric_F32 src ) {
		this.A = src.A;
		this.B = src.B;
		this.C = src.C;
		this.D = src.D;
		this.E = src.E;
		this.F = src.F;
	}

	public void evaluate(float t , Point2D_F32 location ) {
		location.x = A*t*t + B*t + C;
		location.y = D*t*t + E*t + F;
	}

	public Point2D_F32 evaluate( float t ) {
		Point2D_F32 p = new Point2D_F32();
		evaluate(t,p);
		return p;
	}
}
