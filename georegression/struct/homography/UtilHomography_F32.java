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

package georegression.struct.homography;


import javax.annotation.Generated;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.jetbrains.annotations.Nullable;

/**
 * Various useful functions related to homographies.
 *
 * @author Peter Abeles
 */
@Generated("georegression.struct.homography.UtilHomography_F64")
public class UtilHomography_F32 {

	/**
	 * Converts the provided 3x3 matrix into a {@link Homography2D_F32}.
	 *
	 * @param m Input 3x3 matrix.
	 * @param ret Storage for output.  If null then a new instance is created.
	 * @return Equivalent homography.
	 */
	public static Homography2D_F32 convert( FMatrixRMaj m , @Nullable Homography2D_F32 ret ) {
		if( m.numCols != 3 || m.numRows != 3)
			throw new IllegalArgumentException("Expected a 3 by 3 matrix.");

		if( ret == null )
			ret = new Homography2D_F32();

		ret.a11 = m.unsafe_get(0,0);
		ret.a12 = m.unsafe_get(0,1);
		ret.a13 = m.unsafe_get(0,2);
		ret.a21 = m.unsafe_get(1,0);
		ret.a22 = m.unsafe_get(1,1);
		ret.a23 = m.unsafe_get(1,2);
		ret.a31 = m.unsafe_get(2,0);
		ret.a32 = m.unsafe_get(2,1);
		ret.a33 = m.unsafe_get(2,2);

		return ret;
	}

	/**
	 * Converts a {@link Homography2D_F32} into a 3x3 matrix.
	 *
	 * @param m Homography
	 * @param ret Storage for output.  If null then a new instance is created.
	 * @return Equivalent matrix.
	 */
	public static FMatrixRMaj convert( Homography2D_F32 m , @Nullable FMatrixRMaj ret ) {
		if( ret == null ) {
			ret = new FMatrixRMaj(3,3);
		} else if( ret.numCols != 3 || ret.numRows != 3)
			throw new IllegalArgumentException("Expected a 3 by 3 matrix.");


		ret.unsafe_set(0,0,m.a11);
		ret.unsafe_set(0,1,m.a12);
		ret.unsafe_set(0,2,m.a13);
		ret.unsafe_set(1,0,m.a21);
		ret.unsafe_set(1,1,m.a22);
		ret.unsafe_set(1,2,m.a23);
		ret.unsafe_set(2,0,m.a31);
		ret.unsafe_set(2,1,m.a32);
		ret.unsafe_set(2,2,m.a33);

		return ret;
	}

	public static Homography2D_F32 invert( Homography2D_F32 orig , @Nullable Homography2D_F32 inverted ) {
		if( inverted == null )
			inverted = new Homography2D_F32();

		FMatrixRMaj A = new FMatrixRMaj(3,3);
		convert(orig,A);
		CommonOps_FDRM.invert(A);
		convert(A,inverted);

		return inverted;
	}

	public static void scale( Homography2D_F32 h , float scale ) {
		h.a11 *= scale;
		h.a12 *= scale;
		h.a13 *= scale;
		h.a21 *= scale;
		h.a22 *= scale;
		h.a23 *= scale;
		h.a31 *= scale;
		h.a32 *= scale;
		h.a33 *= scale;
	}

   public static void print(Homography2D_F32 h)
   {
      for( int y = 0; y < 3; y++ ) {
         for( int x = 0; x < 3; x++ ) {
            System.out.printf("%8.1fe ",h.get(x,y));
         }
         System.out.println();
      }
   }
}
