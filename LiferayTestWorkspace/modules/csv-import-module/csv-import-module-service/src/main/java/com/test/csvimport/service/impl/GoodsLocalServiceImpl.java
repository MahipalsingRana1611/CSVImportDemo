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

package com.test.csvimport.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.test.csvimport.model.Goods;
import com.test.csvimport.model.impl.GoodsImpl;
import com.test.csvimport.service.base.GoodsLocalServiceBaseImpl;

/**
 * The implementation of the goods local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.test.csvimport.service.GoodsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GoodsLocalServiceBaseImpl
 * @see com.test.csvimport.service.GoodsLocalServiceUtil
 */
public class GoodsLocalServiceImpl extends GoodsLocalServiceBaseImpl {
	private static final Log log = LogFactoryUtil.getLog(GoodsLocalServiceImpl.class.getName());

	/**
	 * Method to save goods object
	 * 
	 * @param goodsData
	 * @return
	 */
	public Goods saveGoods(Goods goodsData) {
		Goods goods = createGoods(counterLocalService.increment(GoodsImpl.class.getName()));
		goods.setName(goodsData.getName());
		goods.setDescription(goodsData.getDescription());
		goods.setHeight(goodsData.getHeight());
		goods.setLength(goodsData.getLength());
		goods.setArea(goodsData.getHeight() * goodsData.getLength());
		goods.setNr(goodsData.getNr());
		log.debug("Saving Goods Object... --> " + goods);
		return goodsLocalService.addGoods(goods);
	}
}