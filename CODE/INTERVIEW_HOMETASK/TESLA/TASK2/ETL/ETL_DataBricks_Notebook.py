#-----------------------------------------------------
#This task is written in Notebook and will be running on Microsoft Azure DataBricks
#0. Mount folder on Azure Cloud storage where we store json format files loaded from https://earthquake.usgs.gov/ via Postman
#-----------------------------------------------------
%scala
val containerName = "containerearthquake"
val storageAccountName = "storageaccountoleksii"
val sas = "?sv=2020-02-10&ss=bfqt&srt=sco&sp=rwdlacupx&se=2021-05-01T10:27:19Z&st=2021-04-15T02:27:19Z&spr=https&sig=Jog7zcHqvSynMoeE4ryKALOKpa2xfqTsdd6LUQx6yzI%3D"

val url = "wasbs://" + containerName + "@" + storageAccountName + ".blob.core.windows.net/"
var config = "fs.azure.sas." + containerName + "." + storageAccountName + ".blob.core.windows.net"


dbutils.fs.mount(
  source = url,
  mountPoint = "/mnt/staging5",
  extraConfigs = Map(config -> sas))



dfInput.createOrReplaceTempView("table_input_earhquake")

#-----------------------------------------------------
#1. Creting Data Frames for each "logical" entity extracted from json
#-----------------------------------------------------
%python
import pandas as pd
import json

file_json="/mnt/staging5/equarthquake_2017.json"
dfInput = sqlContext.read.load(file_json, format="json")

#1.1. Earhquake DF
dfEarhquake = spark.sql("""
                  select 
                         id
                        ,type as earhquake_type
                  from 
                       table_input_earhquake
                  where
                       id is not null
                        """)
                        
#1.2. Geometry DF
dfGeometry = spark.sql("""
                  select 
                         id
                        ,geometry.type as geotype
                        ,cast(geometry.coordinates[0] as decimal(20,12)) as coordinates_x
                        ,cast(geometry.coordinates[1] as decimal(20,12)) as coordinates_y
                        ,cast(geometry.coordinates[2] as decimal(20,12)) as coordinates_z
                  from
                       table_input_earhquake
                  where
                       id is not null
                        """)
                        
#1.3. Properties DF
dfProperties = spark.sql("""
                  select 
                         id
                        ,properties.alert as alert
                        ,cast(properties.cdi as decimal(20,12)) as cdi
                        ,properties.code as code
                        ,properties.detail as detail
                        ,cast(properties.dmin as decimal(20,12)) as dmin
                        ,properties.felt as felt
                        ,cast(properties.gap as decimal(20,12)) as gap
                        ,properties.ids as ids
                        ,cast(properties.mag as decimal(20,12)) as mag
                        ,properties.magType as magType
                        ,cast(properties.mmi as decimal(20,12)) as mmi
                        ,properties.net as net   
                        ,properties.nst as nst				
                        ,properties.place as place
                        ,cast(properties.rms as decimal(20,12)) as rms
                        ,properties.sig as sig
                        ,properties.sources as	sources
                        ,properties.status as properties_status
                        ,properties.time as property_time	
                        ,properties.title as title
                        ,properties.tsunami as tsunami						
						,properties.type as property_type
						,properties.types as property_types
						,properties.tz as tz
						,properties.updated as updated
						,properties.url as properties_url                        
                  from
                       table_input_earhquake
                  where
                        id is not null
                        """)                  

#dfInputProperties.printSchema()

#-----------------------------------------------------
#2. Load data into RDBMS [MS Azure SQL]
# note: [MS Azure SQL] is the cloud implementation of MS SQL Server
#-----------------------------------------------------

jdbcHostname = "sqlserver005.database.windows.net"
jdbcDatabase = "DB_EarthQuake"
jdbcPort = 1433
jdbcUsername = "alesha"
jdbcPassword = "!fldjrfn21" #note: keep a password here is not good solution. The best solution is to store password in [Azure Key Vault] service. I hard coded the pass here to simplify development 
jdbcUrl = "jdbc:sqlserver://"+jdbcHostname+":"+str(jdbcPort)+";databaseName="+jdbcDatabase

tableEarthquake="dbo.stg_earthquake_2017"
tableGeometry="dbo.stg_geometry_2017"
tableProperties="dbo.stg_properties_2017"

dfEarhquake.write \
.format("jdbc")\
.option("url", jdbcUrl)\
.option("dbtable", tableEarthquake)\
.option("user", jdbcUsername)\
.option("password", jdbcPassword)\
.save()

dfGeometry.write \
.format("jdbc")\
.option("url", jdbcUrl)\
.option("dbtable", tableGeometry)\
.option("user", jdbcUsername)\
.option("password", jdbcPassword)\
.save()

dfProperties.write \
.format("jdbc")\
.option("url", jdbcUrl)\
.option("dbtable", tableProperties)\
.option("user", jdbcUsername)\
.option("password", jdbcPassword)\
.save()