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

package georegression.struct.plane;

import javax.annotation.Generated;
import georegression.struct.point.Point3D_F32;
import georegression.struct.point.Vector3D_F32;

import java.io.Serializable;
import java.util.Objects;

/**
 * Defines a plane using a point on the plane and the plane's normal.  N*(x-p0) = 0, where N is the plane's
 * normal, p0 is a point on the plane, and 'x' is another point on the plane.
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.plane.PlaneNormal3D_F64")
public class PlaneNormal3D_F32 implements Serializable {
	/** An arbitrary point in the plane */
	public Point3D_F32 p = new Point3D_F32();
	/** The plane's normal */
	public Vector3D_F32 n = new Vector3D_F32();

	public PlaneNormal3D_F32(PlaneNormal3D_F32 o) {
		setTo(o);
	}

	public PlaneNormal3D_F32(Point3D_F32 point, Vector3D_F32 normal) {
		setTo(point,normal);
	}

	public PlaneNormal3D_F32( float px , float py , float pz , float nx , float ny, float nz ) {
		setTo(px,py,pz,nx,ny,nz);
	}

	public PlaneNormal3D_F32() {
	}

	public Point3D_F32 getP() {
		return p;
	}

	public void setTo(float px , float py , float pz , float nx , float ny, float nz ) {
		this.p.setTo(px,py,pz);
		this.n.setTo(nx,ny,nz);
	}

	public void setTo(Point3D_F32 point, Vector3D_F32 normal ) {
		this.p.setTo(point);
		this.n.setTo(normal);
	}

	public void setTo(PlaneNormal3D_F32 o ) {
		this.p.setTo(o.p);
		this.n.setTo(o.n);
	}

	public void setP(Point3D_F32 p) {
		this.p.setTo(p);
	}

	public Vector3D_F32 getN() {
		return n;
	}

	public void setN(Vector3D_F32 n) {
		this.n.setTo(n);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"{" +
				"p=" + p +
				", n=" + n +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if( !(o instanceof PlaneNormal3D_F32)) return false;
		PlaneNormal3D_F32 that = (PlaneNormal3D_F32) o;
		return p.equals(that.p) && n.equals(that.n);
	}

	@Override
	public int hashCode() {
		return Objects.hash(p, n);
	}
}
