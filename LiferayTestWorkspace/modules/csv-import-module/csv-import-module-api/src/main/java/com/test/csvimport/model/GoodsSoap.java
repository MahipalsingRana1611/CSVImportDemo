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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.csvimport.service.http.GoodsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.test.csvimport.service.http.GoodsServiceSoap
 * @generated
 */
@ProviderType
public class GoodsSoap implements Serializable {
	public static GoodsSoap toSoapModel(Goods model) {
		GoodsSoap soapModel = new GoodsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLength(model.getLength());
		soapModel.setHeight(model.getHeight());
		soapModel.setArea(model.getArea());
		soapModel.setNr(model.getNr());

		return soapModel;
	}

	public static GoodsSoap[] toSoapModels(Goods[] models) {
		GoodsSoap[] soapModels = new GoodsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GoodsSoap[][] toSoapModels(Goods[][] models) {
		GoodsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GoodsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GoodsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GoodsSoap[] toSoapModels(List<Goods> models) {
		List<GoodsSoap> soapModels = new ArrayList<GoodsSoap>(models.size());

		for (Goods model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GoodsSoap[soapModels.size()]);
	}

	public GoodsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public double getLength() {
		return _length;
	}

	public void setLength(double length) {
		_length = length;
	}

	public double getHeight() {
		return _height;
	}

	public void setHeight(double height) {
		_height = height;
	}

	public double getArea() {
		return _area;
	}

	public void setArea(double area) {
		_area = area;
	}

	public String getNr() {
		return _nr;
	}

	public void setNr(String nr) {
		_nr = nr;
	}

	private String _uuid;
	private long _id;
	private String _name;
	private String _description;
	private double _length;
	private double _height;
	private double _area;
	private String _nr;
}