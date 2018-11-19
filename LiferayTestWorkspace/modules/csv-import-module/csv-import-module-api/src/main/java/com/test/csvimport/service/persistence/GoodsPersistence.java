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

package com.test.csvimport.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.test.csvimport.exception.NoSuchGoodsException;
import com.test.csvimport.model.Goods;

/**
 * The persistence interface for the goods service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.test.csvimport.service.persistence.impl.GoodsPersistenceImpl
 * @see GoodsUtil
 * @generated
 */
@ProviderType
public interface GoodsPersistence extends BasePersistence<Goods> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoodsUtil} to access the goods persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the goodses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching goodses
	*/
	public java.util.List<Goods> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the goodses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @return the range of matching goodses
	*/
	public java.util.List<Goods> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the goodses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching goodses
	*/
	public java.util.List<Goods> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns an ordered range of all the goodses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching goodses
	*/
	public java.util.List<Goods> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first goods in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goods
	* @throws NoSuchGoodsException if a matching goods could not be found
	*/
	public Goods findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Returns the first goods in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goods, or <code>null</code> if a matching goods could not be found
	*/
	public Goods fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns the last goods in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goods
	* @throws NoSuchGoodsException if a matching goods could not be found
	*/
	public Goods findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Returns the last goods in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goods, or <code>null</code> if a matching goods could not be found
	*/
	public Goods fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns the goodses before and after the current goods in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current goods
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next goods
	* @throws NoSuchGoodsException if a goods with the primary key could not be found
	*/
	public Goods[] findByUuid_PrevAndNext(long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Removes all the goodses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of goodses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching goodses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the goodses where name = &#63;.
	*
	* @param name the name
	* @return the matching goodses
	*/
	public java.util.List<Goods> findByName(java.lang.String name);

	/**
	* Returns a range of all the goodses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @return the range of matching goodses
	*/
	public java.util.List<Goods> findByName(java.lang.String name, int start,
		int end);

	/**
	* Returns an ordered range of all the goodses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching goodses
	*/
	public java.util.List<Goods> findByName(java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns an ordered range of all the goodses where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching goodses
	*/
	public java.util.List<Goods> findByName(java.lang.String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first goods in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goods
	* @throws NoSuchGoodsException if a matching goods could not be found
	*/
	public Goods findByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Returns the first goods in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching goods, or <code>null</code> if a matching goods could not be found
	*/
	public Goods fetchByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns the last goods in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goods
	* @throws NoSuchGoodsException if a matching goods could not be found
	*/
	public Goods findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Returns the last goods in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching goods, or <code>null</code> if a matching goods could not be found
	*/
	public Goods fetchByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns the goodses before and after the current goods in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current goods
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next goods
	* @throws NoSuchGoodsException if a goods with the primary key could not be found
	*/
	public Goods[] findByName_PrevAndNext(long id, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator)
		throws NoSuchGoodsException;

	/**
	* Removes all the goodses where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByName(java.lang.String name);

	/**
	* Returns the number of goodses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching goodses
	*/
	public int countByName(java.lang.String name);

	/**
	* Caches the goods in the entity cache if it is enabled.
	*
	* @param goods the goods
	*/
	public void cacheResult(Goods goods);

	/**
	* Caches the goodses in the entity cache if it is enabled.
	*
	* @param goodses the goodses
	*/
	public void cacheResult(java.util.List<Goods> goodses);

	/**
	* Creates a new goods with the primary key. Does not add the goods to the database.
	*
	* @param id the primary key for the new goods
	* @return the new goods
	*/
	public Goods create(long id);

	/**
	* Removes the goods with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the goods
	* @return the goods that was removed
	* @throws NoSuchGoodsException if a goods with the primary key could not be found
	*/
	public Goods remove(long id) throws NoSuchGoodsException;

	public Goods updateImpl(Goods goods);

	/**
	* Returns the goods with the primary key or throws a {@link NoSuchGoodsException} if it could not be found.
	*
	* @param id the primary key of the goods
	* @return the goods
	* @throws NoSuchGoodsException if a goods with the primary key could not be found
	*/
	public Goods findByPrimaryKey(long id) throws NoSuchGoodsException;

	/**
	* Returns the goods with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the goods
	* @return the goods, or <code>null</code> if a goods with the primary key could not be found
	*/
	public Goods fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Goods> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the goodses.
	*
	* @return the goodses
	*/
	public java.util.List<Goods> findAll();

	/**
	* Returns a range of all the goodses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @return the range of goodses
	*/
	public java.util.List<Goods> findAll(int start, int end);

	/**
	* Returns an ordered range of all the goodses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of goodses
	*/
	public java.util.List<Goods> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator);

	/**
	* Returns an ordered range of all the goodses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoodsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of goodses
	* @param end the upper bound of the range of goodses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of goodses
	*/
	public java.util.List<Goods> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Goods> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the goodses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of goodses.
	*
	* @return the number of goodses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}