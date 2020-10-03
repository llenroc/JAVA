# Write your MySQL query statement below
/*
2020-Oct-03. Oleksii Saiun.
LeetCode_#197. Rising Temperature
https://leetcode.com/problems/rising-temperature/
*/


SELECT
      ID
FROM(
SELECT
       ID
      ,Temperature - LAG(Temperature) OVER(ORDER BY recordDate  ASC) AS DIFF
      ,DATE_SUB(recordDate, INTERVAL 1 DAY) - LAG(recordDate) OVER(ORDER BY recordDate  ASC) AS   
       IS_PREV_DAY_EXIST /*[0]-EXISTS IN A TABLE, [ANOTHER VALUE] - NOT EXIST*/
FROM 
    Weather
)    
  T1
WHERE 
     IS_PREV_DAY_EXIST=0 AND DIFF > 0;
