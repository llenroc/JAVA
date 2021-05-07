/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#1479. Sales by Day of the Week
https://leetcode.com/problems/sales-by-day-of-the-week/
*/

WITH CTE1
AS (
SELECT
       I.ITEM_CATEGORY AS Category   
      ,DAYNAME(O.ORDER_DATE) AS DAY_OF_WEEK
      ,SUM(O.QUANTITY) AS QUANTITY
FROM 
             ITEMS I
    LEFT JOIN
             ORDERS O
	ON(I.ITEM_ID=O.ITEM_ID)
GROUP BY
       I.ITEM_NAME
      ,DAYNAME(O.ORDER_DATE)    
),
CTE2 AS
(
 SELECT 
      Category
	 ,CASE 
          WHEN DAY_OF_WEEK='Monday' THEN QUANTITY
	  END AS Monday
	 ,CASE 
          WHEN DAY_OF_WEEK='Tuesday' THEN QUANTITY
	  END AS Tuesday      
	 ,CASE 
          WHEN DAY_OF_WEEK='Wednesday' THEN QUANTITY
	  END AS Wednesday    
	 ,CASE 
          WHEN DAY_OF_WEEK='Thursday' THEN QUANTITY
	  END AS Thursday      
	 ,CASE 
          WHEN DAY_OF_WEEK='Friday' THEN QUANTITY
	  END AS Friday   
	 ,CASE 
          WHEN DAY_OF_WEEK='Saturday' THEN QUANTITY
	  END AS Saturday        
	 ,CASE 
          WHEN DAY_OF_WEEK='Sunday' THEN QUANTITY
	  END AS Sunday         
FROM CTE1
)
SELECT 
       Category
      ,SUM(IFNULL(Monday,0)) AS Monday
      ,SUM(IFNULL(Tuesday,0)) AS Tuesday
      ,SUM(IFNULL(Wednesday,0)) AS Wednesday
      ,SUM(IFNULL(Thursday,0)) AS Thursday
      ,SUM(IFNULL(Friday,0)) AS Friday
      ,SUM(IFNULL(Saturday,0)) AS Saturday      
      ,SUM(IFNULL(Sunday,0)) AS Sunday            
FROM CTE2
GROUP BY 
       Category
ORDER BY Category;  
       
