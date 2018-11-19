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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.test.csvimport.model.Goods;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Goods in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Goods
 * @generated
 */
@ProviderType
public class GoodsCacheModel implements CacheModel<Goods>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GoodsCacheModel)) {
			return false;
		}

		GoodsCacheModel goodsCacheModel = (GoodsCacheModel)obj;

		if (id == goodsCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", length=");
		sb.append(length);
		sb.append(", height=");
		sb.append(height);
		sb.append(", area=");
		sb.append(area);
		sb.append(", nr=");
		sb.append(nr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Goods toEntityModel() {
		GoodsImpl goodsImpl = new GoodsImpl();

		if (uuid == null) {
			goodsImpl.setUuid(StringPool.BLANK);
		}
		else {
			goodsImpl.setUuid(uuid);
		}

		goodsImpl.setId(id);

		if (name == null) {
			goodsImpl.setName(StringPool.BLANK);
		}
		else {
			goodsImpl.setName(name);
		}

		if (description == null) {
			goodsImpl.setDescription(StringPool.BLANK);
		}
		else {
			goodsImpl.setDescription(description);
		}

		goodsImpl.setLength(length);
		goodsImpl.setHeight(height);
		goodsImpl.setArea(area);

		if (nr == null) {
			goodsImpl.setNr(StringPool.BLANK);
		}
		else {
			goodsImpl.setNr(nr);
		}

		goodsImpl.resetOriginalValues();

		return goodsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		length = objectInput.readDouble();

		height = objectInput.readDouble();

		area = objectInput.readDouble();
		nr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(length);

		objectOutput.writeDouble(height);

		objectOutput.writeDouble(area);

		if (nr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nr);
		}
	}

	public String uuid;
	public long id;
	public String name;
	public String description;
	public double length;
	public double height;
	public double area;
	public String nr;
}