createdb HIFI_THATTU_KADA

psql HIFI_THATTU_KADA

create schema admn;

create table admn.tbl_user(
  pki_user_id 	serial primary key not null,
  uvc_user_name varchar unique not null,
  uvc_email 	varchar unique not null,
  vc_passwd 	varchar not null,
  dt_time 	timestamp without time zone 
);

-- to retrive all the schemas for db
select schema_name from information_schema.schemata;
-- to retrive all the tables from schema
select * from information_schema.tables where table_schema='admn';
--Creating Sequence for incrementing by 1
create SEQUENCE userEntity_Seq start with 1 increment by 1;

