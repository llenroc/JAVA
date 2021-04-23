--*************************************************************************************************************
--TASK 2.1. Provide query/analysis to give biggest earthquake of 2017
--*************************************************************************************************************


--*************************************************************************************************************
--TASK 2.6.SQL. Provide query/analysis to give most probable hour of the day for the earthquakes bucketed by the range of magnitude.
--0-1,1-2,2-3,3-4,4-5,5-6,>6   For border values in the bucket, include them in the bucket where the value is a lower limit so for 1 include it in 1-2 bucket)
--*************************************************************************************************************

WITH 
    tmp(bucket,hourOfEarhquake,amount) AS
(
SELECT 
               CASE
                   WHEN mag >=0 and mag<1 THEN 0
                   WHEN mag >=1 and mag<2 THEN 1
				   WHEN mag >=2 and mag<3 THEN 3
				   WHEN mag >=3 and mag<4 THEN 4
				   WHEN mag >=4 and mag<5 THEN 5
				   WHEN mag >=6 THEN 6
				   ELSE -1
                END 
				   AS bucket
  			   ,datepart(hour,dateadd(S,convert(int,left(property_time,10)), '1970-01-01')) hourOfEarhquake
			   ,count(*) as amount
from dwh_properties
group by 
               CASE
                   WHEN mag >=0 and mag<1 THEN 0
                   WHEN mag >=1 and mag<2 THEN 1
				   WHEN mag >=2 and mag<3 THEN 3
				   WHEN mag >=3 and mag<4 THEN 4
				   WHEN mag >=4 and mag<5 THEN 5
				   WHEN mag >=6 THEN 6
				   ELSE -1
                END 
  			   ,datepart(hour,dateadd(S,convert(int,left(property_time,10)), '1970-01-01'))
),
    tmp2(bucket,hourOfEarhquake,amount,rn) 
AS (
SELECT 
       bucket
	  ,hourOfEarhquake
	  ,amount
	  ,row_number() over(partition by bucket order by amount desc) as rn 
FROM
     tmp
)
 --main part:
 SELECT        
       bucket
	  ,hourOfEarhquake
	  ,amount 
 FROM 
     tmp2
 WHERE
      rn=1;