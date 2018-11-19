create table TEST_Goods (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	name VARCHAR(512) null,
	description TEXT null,
	length DOUBLE,
	height DOUBLE,
	area DOUBLE,
	nr TEXT null
);