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

package com.test.csvimport.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Goods}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Goods
 * @generated
 */
@ProviderType
public class GoodsWrapper implements Goods, ModelWrapper<Goods> {
	public GoodsWrapper(Goods goods) {
		_goods = goods;
	}

	@Override
	public Class<?> getModelClass() {
		return Goods.class;
	}

	@Override
	public String getModelClassName() {
		return Goods.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("length", getLength());
		attributes.put("height", getHeight());
		attributes.put("area", getArea());
		attributes.put("nr", getNr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double length = (Double)attributes.get("length");

		if (length != null) {
			setLength(length);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double area = (Double)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String nr = (String)attributes.get("nr");

		if (nr != null) {
			setNr(nr);
		}
	}

	@Override
	public Goods toEscapedModel() {
		return new GoodsWrapper(_goods.toEscapedModel());
	}

	@Override
	public Goods toUnescapedModel() {
		return new GoodsWrapper(_goods.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _goods.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _goods.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _goods.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _goods.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Goods> toCacheModel() {
		return _goods.toCacheModel();
	}

	/**
	* Returns the area of this goods.
	*
	* @return the area of this goods
	*/
	@Override
	public double getArea() {
		return _goods.getArea();
	}

	/**
	* Returns the height of this goods.
	*
	* @return the height of this goods
	*/
	@Override
	public double getHeight() {
		return _goods.getHeight();
	}

	/**
	* Returns the length of this goods.
	*
	* @return the length of this goods
	*/
	@Override
	public double getLength() {
		return _goods.getLength();
	}

	@Override
	public int compareTo(Goods goods) {
		return _goods.compareTo(goods);
	}

	@Override
	public int hashCode() {
		return _goods.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _goods.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GoodsWrapper((Goods)_goods.clone());
	}

	/**
	* Returns the description of this goods.
	*
	* @return the description of this goods
	*/
	@Override
	public java.lang.String getDescription() {
		return _goods.getDescription();
	}

	/**
	* Returns the name of this goods.
	*
	* @return the name of this goods
	*/
	@Override
	public java.lang.String getName() {
		return _goods.getName();
	}

	/**
	* Returns the nr of this goods.
	*
	* @return the nr of this goods
	*/
	@Override
	public java.lang.String getNr() {
		return _goods.getNr();
	}

	/**
	* Returns the uuid of this goods.
	*
	* @return the uuid of this goods
	*/
	@Override
	public java.lang.String getUuid() {
		return _goods.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _goods.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _goods.toXmlString();
	}

	/**
	* Returns the ID of this goods.
	*
	* @return the ID of this goods
	*/
	@Override
	public long getId() {
		return _goods.getId();
	}

	/**
	* Returns the primary key of this goods.
	*
	* @return the primary key of this goods
	*/
	@Override
	public long getPrimaryKey() {
		return _goods.getPrimaryKey();
	}

	@Override
	public void persist() {
		_goods.persist();
	}

	/**
	* Sets the area of this goods.
	*
	* @param area the area of this goods
	*/
	@Override
	public void setArea(double area) {
		_goods.setArea(area);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_goods.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this goods.
	*
	* @param description the description of this goods
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_goods.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_goods.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_goods.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_goods.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the height of this goods.
	*
	* @param height the height of this goods
	*/
	@Override
	public void setHeight(double height) {
		_goods.setHeight(height);
	}

	/**
	* Sets the ID of this goods.
	*
	* @param id the ID of this goods
	*/
	@Override
	public void setId(long id) {
		_goods.setId(id);
	}

	/**
	* Sets the length of this goods.
	*
	* @param length the length of this goods
	*/
	@Override
	public void setLength(double length) {
		_goods.setLength(length);
	}

	/**
	* Sets the name of this goods.
	*
	* @param name the name of this goods
	*/
	@Override
	public void setName(java.lang.String name) {
		_goods.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_goods.setNew(n);
	}

	/**
	* Sets the nr of this goods.
	*
	* @param nr the nr of this goods
	*/
	@Override
	public void setNr(java.lang.String nr) {
		_goods.setNr(nr);
	}

	/**
	* Sets the primary key of this goods.
	*
	* @param primaryKey the primary key of this goods
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_goods.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_goods.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this goods.
	*
	* @param uuid the uuid of this goods
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_goods.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoodsWrapper)) {
			return false;
		}

		GoodsWrapper goodsWrapper = (GoodsWrapper)obj;

		if (Objects.equals(_goods, goodsWrapper._goods)) {
			return true;
		}

		return false;
	}

	@Override
	public Goods getWrappedModel() {
		return _goods;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _goods.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _goods.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_goods.resetOriginalValues();
	}

	private final Goods _goods;
}