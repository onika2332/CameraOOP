/*
 * Copyright (C) 2011-2018, Peter Abeles. All Rights Reserved.
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

package georegression.struct.so;

import javax.annotation.Generated;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/**
 * @author Peter Abeles
 */
@Generated("georegression.struct.so.SpecialOrthogonalOps_F64")
public class SpecialOrthogonalOps_F32 {
	/**
	 * Finds the best fit matrix in SO(3) for the input matrix.
	 *
	 * @param A 3x3 matrix. Modified.
	 */
	public static void bestFit( FMatrixRMaj A ) {

		SingularValueDecomposition_F32<FMatrixRMaj> svd = DecompositionFactory_FDRM.svd(true,true,true);

		if( !svd.decompose(A))
			throw new RuntimeException("SVD Failed");

		CommonOps_FDRM.multTransB(svd.getU(null,false),svd.getV(null,false),A);

		// determinant should be +1
		float det = CommonOps_FDRM.det(A);

		if( det < 0 )
			CommonOps_FDRM.scale(-1,A);
	}
}
