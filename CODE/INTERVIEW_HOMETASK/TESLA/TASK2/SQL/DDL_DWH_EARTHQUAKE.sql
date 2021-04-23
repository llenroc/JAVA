use DB_EarthQuake;     
   
--#############################################################
--DDL
--#############################################################

--#1.[dwh_geometry]
CREATE TABLE dwh_geometry
(
  sk_geometry bigint identity(1,1)
 ,id varchar(255)
 ,geotype varchar(255)
 ,coordinates_x decimal(20,12)
 ,coordinates_y decimal(20,12)
 ,coordinates_z decimal(20,12)
 ,etl_load_time datetime
);

ALTER TABLE dwh_geometry ADD CONSTRAINT pk_geometry PRIMARY KEY (sk_geometry);
CREATE UNIQUE INDEX ui_dwh_geometry_id ON dwh_geometry(id);   

--#2.[dwh_properties]
CREATE TABLE dwh_properties
(
  sk_properties bigint identity(1,1)
 ,id varchar(255)
 ,alert varchar(50)
 ,cdi decimal(20,12)
 ,code varchar(50)
 ,detail varchar(255)
 ,dmin decimal(20,12)
 ,felt bigint
 ,gap decimal(20,12)
 ,ids varchar(255)
 ,mag decimal(20,12)
 ,magType varchar(20)
 ,mmi varchar(20)
 ,net varchar(20)
 ,nst bigint				
 ,place varchar(255)
 ,rms decimal(20,12)
 ,sig bigint
 ,sources varchar(255)
 ,properties_status varchar(20)
 ,property_time bigint 	
 ,title varchar(255)
 ,tsunami bigint						
 ,property_type varchar(255)
 ,property_types varchar(255)
 ,tz bigint
 ,updated bigint
 ,properties_url varchar(255)    
 ,etl_load_time datetime
);
ALTER TABLE dwh_properties ADD CONSTRAINT pk_properties PRIMARY KEY (sk_properties);
CREATE UNIQUE INDEX ui_dwh_properties_id ON dwh_properties(id);   

--#3.[dwh_earthquake]
CREATE TABLE dwh_earthquake
(
  sk_earthquake bigint identity(1,1)
 ,sk_geometry int
 ,sk_properties int
 ,id varchar(255)
 ,earhquake_type varchar(255)
 ,etl_load_time datetime
);
ALTER TABLE dwh_earthquake ADD CONSTRAINT pk_earthquake PRIMARY KEY (sk_earthquake);
CREATE UNIQUE INDEX ui_dwh_earthquake_id ON dwh_earthquake(id);

