/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#579. Find Cumulative Salary of an Employee
https://leetcode.com/problems/find-cumulative-salary-of-an-employee/

NOTE(!)leetcode test case has a wrong test case
*/


SELECT
       ID AS Id
      ,MONTH AS Month 
      ,SUM(SALARY) OVER(PARTITION BY ID ORDER BY SALARY ASC) AS Salary 
FROM(      
  SELECT
         ID
        ,MONTH
        ,SALARY
        ,ROW_NUMBER() OVER(PARTITION BY ID ORDER BY MONTH DESC) AS RN_MONTH
  FROM Employee
)
 T
WHERE RN_MONTH>1
ORDER BY 1 ASC, 2 DESC
