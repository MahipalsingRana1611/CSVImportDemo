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

package com.test.csvimport.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GoodsService}.
 *
 * @author Brian Wing Shun Chan
 * @see GoodsService
 * @generated
 */
@ProviderType
public class GoodsServiceWrapper implements GoodsService,
	ServiceWrapper<GoodsService> {
	public GoodsServiceWrapper(GoodsService goodsService) {
		_goodsService = goodsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _goodsService.getOSGiServiceIdentifier();
	}

	@Override
	public GoodsService getWrappedService() {
		return _goodsService;
	}

	@Override
	public void setWrappedService(GoodsService goodsService) {
		_goodsService = goodsService;
	}

	private GoodsService _goodsService;
}