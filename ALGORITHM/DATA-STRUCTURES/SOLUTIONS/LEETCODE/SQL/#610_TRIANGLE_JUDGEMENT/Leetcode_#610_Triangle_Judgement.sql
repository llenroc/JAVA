/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#610. Triangle Judgement
https://leetcode.com/problems/triangle-judgement/
*/

SELECT
       X
      ,Y
      ,Z
      ,CASE 
           WHEN X_STATUS + Y_STATUS + Z_STATUS = 3 THEN 'Yes'
       ELSE 'No'
       END triangle       
FROM(
SELECT 
       X
      ,Y
      ,Z
      ,CASE 
           WHEN Y+Z>X THEN 1
       ELSE 0
       END X_STATUS
      ,CASE 
           WHEN X+Z>Y THEN 1
       ELSE 0
       END Y_STATUS   
      ,CASE 
           WHEN X+Y>Z THEN 1
       ELSE 0
       END Z_STATUS         
FROM TRIANGLE
    ) T
