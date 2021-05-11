/* Write your PL/SQL query statement below */
/*
2020-May-11. Oleksii Saiun.
LeetCode_#1355. Activity Participants
https://leetcode.com/problems/exchange-seats/
*/

WITH CTE AS 
(
SELECT
      activity
     ,count(*) as amt
FROM 
    Friends 
GROUP BY
      activity
)
,CTE2 AS
(
SELECT
     activity
    ,amt
    ,dense_rank() over(order by amt desc) rn_desc
    ,dense_rank() over(order by amt asc) rn_asc
FROM CTE
)
SELECT 
      activity
FROM CTE2
WHERE rn_desc!=1 and rn_asc!=1;
