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

package georegression.struct.trig;

import javax.annotation.Generated;
import georegression.struct.point.Point2D_F32;

/**
 * Describes a circle in 2D space using it's center and radius.
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.trig.Circle2D_F64")
public class Circle2D_F32 {
	/**
	 * Radius of the circle
	 */
	public float radius;
	/**
	 * Center of the circle
	 */
	public Point2D_F32 center = new Point2D_F32();

	public Circle2D_F32(float radius, Point2D_F32 center) {
		this.radius = radius;
		this.center.setTo(center);
	}

	public Circle2D_F32(float radius, float x , float y) {
		this.radius = radius;
		this.center.setTo(x,y);
	}

	public Circle2D_F32() {
	}
}
