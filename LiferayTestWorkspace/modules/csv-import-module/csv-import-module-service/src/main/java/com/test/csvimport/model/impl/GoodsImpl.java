/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.csvimport.model.impl;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the Goods service. Represents a row in the &quot;TEST_Goods&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.csvimport.model.Goods} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class GoodsImpl extends GoodsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a goods model instance should use the {@link com.test.csvimport.model.Goods} interface instead.
	 */
	public GoodsImpl() {
	}
}