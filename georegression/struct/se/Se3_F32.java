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

package georegression.struct.se;

import javax.annotation.Generated;
import georegression.geometry.ConvertRotation3D_F32;
import georegression.geometry.GeometryMath_F32;
import georegression.struct.EulerType;
import georegression.struct.GeoTuple2D_F32;
import georegression.struct.GeoTuple3D_F32;
import georegression.struct.RotationType;
import georegression.struct.point.Point3D_F32;
import georegression.struct.point.Vector3D_F32;
import georegression.transform.se.SePointOps_F32;
import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.ops.MatrixIO;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;


/**
 * A coordinate system transform composed of a rotation and translation.  This transform is
 * a rigid body transform and is a member of the special euclidean group.
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.se.Se3_F64")
public class Se3_F32 implements SpecialEuclidean<Se3_F32> {

	// serialization version
	public static final long serialVersionUID = 1L;

	// rotation matrix
	public FMatrixRMaj R;
	// translation vector
	public Vector3D_F32 T;

	/**
	 * Creates a new transform that does nothing.
	 */
	public Se3_F32() {
		R = CommonOps_FDRM.identity(3);
		T = new Vector3D_F32();
	}

	/**
	 * Initializes the transform with the provided rotation and translation.
	 *
	 * @param R Rotation matrix.
	 * @param T Translation.
	 */
	public Se3_F32(FMatrixRMaj R, Vector3D_F32 T) {
		this(R, T, false);
	}

	/**
	 * Initializes the Se3_F32 with the rotation matrix and translation vector.  If assign
	 * is true the reference to the provided parameters is saved, otherwise a copy is made.
	 *
	 * @param R      Rotation matrix.
	 * @param T      Translation.
	 * @param assign If a reference is saved (true) or a copy made (false).
	 */
	public Se3_F32(FMatrixRMaj R, Vector3D_F32 T, boolean assign) {
		if (assign) {
			this.R = R;
			this.T = T;
		} else {
			this.R = R.copy();
			this.T = T.copy();
		}
	}

	/**
	 * Set's 'this' Se3_F32 to be identical to the provided transform.
	 *
	 * @param se The transform that is being copied.
	 */
	@Override
	public void setTo(Se3_F32 se) {
		R.set(se.getR());
		T.setTo(se.getT());
	}

	/**
	 * Sets the rotation to R.
	 *
	 * @param R New rotation.
	 */
	public void setRotation(FMatrixRMaj R) {
		this.R.set(R);
	}

	/**
	 * Sets the translation to T
	 *
	 * @param T New translation
	 */
	public void setTranslation(Vector3D_F32 T) {
		this.T.setTo(T);
	}

	/**
	 * Sets the translation to (x,y,z)
	 *
	 * @param x x component of translation
	 * @param y y component of translation
	 * @param z z component of translation
	 */
	public void setTranslation(float x, float y, float z) {
		this.T.setTo(x, y, z);
	}

	/**
	 * Returns the rotation matrix
	 *
	 * @return rotation matrix
	 */
	public FMatrixRMaj getRotation() {
		return R;
	}

	/**
	 * Returns the translation vector
	 *
	 * @return translation vector
	 */
	public Vector3D_F32 getTranslation() {
		return T;
	}

	public FMatrixRMaj getR() {
		return R;
	}

	public Vector3D_F32 getT() {
		return T;
	}

	public float getX() {
		return T.getX();
	}

	public float getY() {
		return T.getY();
	}

	public float getZ() {
		return T.getZ();
	}

	@Override
	public int getDimension() {
		return 3;
	}

	@Override
	public Se3_F32 createInstance() {
		return new Se3_F32();
	}

	@Override
	public Se3_F32 concat(Se3_F32 second, @Nullable Se3_F32 result) {
		if (result == null)
			result = new Se3_F32();

		CommonOps_FDRM.mult(second.getR(), getR(), result.getR());
		GeometryMath_F32.mult(second.getR(), getT(), result.getT());
		GeometryMath_F32.add(second.getT(), result.getT(), result.getT());

		return result;
	}

	@Override
	public Se3_F32 invert(@Nullable Se3_F32 inverse) {

		if (inverse == null)
			inverse = new Se3_F32();

		// To derive the inverse transform solve for P
		// R*P+T = P'
		// P = R^T*P' - R^T*T

		// -R^T*T
		GeometryMath_F32.multTran(R, T, inverse.T);
		GeometryMath_F32.changeSign(inverse.T);

		// R^T
		CommonOps_FDRM.transpose(R, inverse.R);

		return inverse;
	}

	@Override
	public void reset() {
		CommonOps_FDRM.setIdentity(R);
		T.setTo(0, 0, 0);
	}

	/**
	 * Fully specify the transform using Euler angles
	 */
	public void set(float x, float y, float z, EulerType type, float rotA, float rotB, float rotC) {
		T.setTo(x, y, z);
		ConvertRotation3D_F32.eulerToMatrix(type, rotA, rotB, rotC, R);
	}

	/**
	 * Fully specifies the transform using Rodrigues (axis angle) or Quaternions.  If Rodrigues then A=axisX, B=axisY,
	 * C=axisZ, D=theta. If Quaternion then A=w, B=x, C=y, D=z.
	 */
	public void set(float x, float y, float z, RotationType type, float A, float B, float C, float D) {
		T.setTo(x, y, z);
		switch (type) {
			case RODRIGUES:
				ConvertRotation3D_F32.rodriguesToMatrix(A, B, C, D, R);
				break;

			case QUATERNION:
				ConvertRotation3D_F32.quaternionToMatrix(A, B, C, D, R);
				break;

			default:
				throw new IllegalArgumentException("Type is not supported. " + type);
		}
	}

	/**
	 * Applies the transform to the src point and stores the result in dst. src and dst can be the same instance
	 *
	 * @param src Input
	 * @param dst Output
	 * @return Output
	 * @see SePointOps_F32#transform(Se3_F32, Point3D_F32, Point3D_F32)
	 */
	public Point3D_F32 transform(Point3D_F32 src, @Nullable Point3D_F32 dst) {
		return SePointOps_F32.transform(this, src, dst);
	}

	/**
	 * Applies the reverse transform to the src point and stores the result in dst. src and dst can be the same instance
	 *
	 * @param src Input
	 * @param dst Output
	 * @return Output
	 * @see SePointOps_F32#transformReverse(Se3_F32, Point3D_F32, Point3D_F32)
	 */
	public Point3D_F32 transformReverse(Point3D_F32 src, @Nullable Point3D_F32 dst) {
		return SePointOps_F32.transformReverse(this, src, dst);
	}

	/**
	 * Applies the rotation to the src vector and stores the result in dst. src and dst can be the same instance
	 *
	 * @param src Input
	 * @param dst Output
	 * @see GeometryMath_F32#mult(FMatrixRMaj, GeoTuple2D_F32, GeoTuple2D_F32)
	 */
	public Vector3D_F32 transform(Vector3D_F32 src, @Nullable Vector3D_F32 dst) {
		return GeometryMath_F32.mult(R, src, dst);
	}

	/**
	 * Applies the reverse rotation to the src vector and stores the result in dst. src and dst can be the same instance
	 *
	 * @param src Input
	 * @param dst Output
	 * @see GeometryMath_F32#multTran(FMatrixRMaj, GeoTuple3D_F32, GeoTuple3D_F32)
	 */
	public Vector3D_F32 transformReverse(Vector3D_F32 src, @Nullable Vector3D_F32 dst) {
		return GeometryMath_F32.multTran(R, src, dst);
	}

	public Se3_F32 copy() {
		Se3_F32 ret = new Se3_F32();
		ret.setTo(this);

		return ret;
	}

	@Override
	public String toString() {
		String ret = "Se3_F32: T = " + T.toString() + "\n";
		ret += R;

		return ret;
	}

	/**
	 * More compact toString() where the rotation matrix is encoded in one of the specified formats.
	 */
	public String toString(RotationType type) {
		DecimalFormat format = new DecimalFormat("#");

		final int sig = 4; // number of significant digits
		String tx = UtilEjml.fancyString(T.x, format, false, MatrixIO.DEFAULT_LENGTH, sig);
		String ty = UtilEjml.fancyString(T.y, format, false, MatrixIO.DEFAULT_LENGTH, sig);
		String tz = UtilEjml.fancyString(T.z, format, false, MatrixIO.DEFAULT_LENGTH, sig);
		String ret = "Se3_F32: T=(" + tx + ", " + ty + ", " + tz + "), ";

		switch (type) {
			case EULER: {
				float[] euler = new float[3];
				ConvertRotation3D_F32.matrixToEuler(R, EulerType.XYZ, euler);
				ret += "EulerXYZ=(" +
						UtilEjml.fancyString(euler[0], format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(euler[1], format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(euler[2], format, false, MatrixIO.DEFAULT_LENGTH, sig) + ")";
			}
			break;

			case RODRIGUES: {
				var rod = ConvertRotation3D_F32.matrixToRodrigues(R, null);
				ret += "Rodrigues={n=(" +
						UtilEjml.fancyString(rod.unitAxisRotation.x, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(rod.unitAxisRotation.y, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(rod.unitAxisRotation.z, format, false, MatrixIO.DEFAULT_LENGTH, sig) + "), theta=" +
						UtilEjml.fancyString(rod.theta, format, false, MatrixIO.DEFAULT_LENGTH, sig) + "}";
			}
			break;

			case QUATERNION: {
				var quat = ConvertRotation3D_F32.matrixToQuaternion(R, null);
				ret += "Quaternion=(" +
						UtilEjml.fancyString(quat.x, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(quat.y, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(quat.z, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ", " +
						UtilEjml.fancyString(quat.w, format, false, MatrixIO.DEFAULT_LENGTH, sig) + ")";
			}
			break;
		}
		return ret;
	}

	public void print() {
		System.out.println(this);
	}

	public void print(RotationType type) {
		System.out.println(toString(type));
	}
}
