--#############################################################
--INSERT DATA FROM STG TO DWH
--#############################################################
use DB_EarthQuake;

--1.[dwh_geometry]
INSERT INTO dwh_geometry
(
  id
 ,geotype
 ,coordinates_x
 ,coordinates_y
 ,coordinates_z
 ,etl_load_time
 )
 SELECT
        id
       ,geotype
       ,coordinates_x
       ,coordinates_y
       ,coordinates_z
	   ,getdate() as etl_load_time
FROM 
      stg_geometry;


--2.[dwh_properties]
INSERT INTO dwh_properties
(
  id
 ,alert
 ,cdi
 ,code
 ,detail
 ,dmin
 ,felt
 ,gap
 ,ids
 ,mag
 ,magType
 ,mmi
 ,net
 ,nst
 ,place
 ,rms
 ,sig
 ,sources
 ,properties_status
 ,property_time
 ,title
 ,tsunami
 ,property_type
 ,property_types
 ,tz
 ,updated
 ,properties_url
 ,etl_load_time
 )
 SELECT
        id
        ,alert
         ,cdi
         ,code
         ,detail
         ,dmin
         ,felt
         ,gap
         ,ids
         ,mag
         ,magType
         ,mmi
         ,net
         ,nst
         ,place
         ,rms
         ,sig
         ,sources
         ,properties_status
         ,property_time
         ,title
         ,tsunami
         ,property_type
         ,property_types
         ,tz
         ,updated
         ,properties_url
	   ,getdate() as etl_load_time
FROM 
      stg_properties;

--3.[dwh_earthquake]
INSERT INTO dwh_earthquake
(
  sk_geometry
 ,sk_properties
 ,id
 ,earhquake_type
 ,etl_load_time
 )
 SELECT
        g.sk_geometry
	   ,p.sk_properties
       ,e.id
       ,e.earhquake_type
	   ,getdate() as etl_load_time
 FROM 
                 stg_earthquake e 
	  INNER JOIN dwh_properties p
	             on e.id=p.id
      INNER JOIN dwh_geometry g
	             on g.id=e.id;