/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#579. Find Cumulative Salary of an Employee
https://leetcode.com/problems/find-cumulative-salary-of-an-employee/

NOTE(!)leetcode test case has a wrong test case
*/


SELECT
       ID
      ,MONTH
      ,SUM(SALARY) OVER(PARTITION BY ID ORDER BY MONTH ASC ROWS BETWEEN 2 PRECEDING AND 0 FOLLOWING) As Salary 
FROM(      
  SELECT
         ID
        ,MONTH
        ,SALARY
        ,DENSE_RANK() OVER(PARTITION BY ID ORDER BY MONTH DESC) AS RN_MONTH /* i use the condition [2 PRECEDING AND 0 FOLLOWING], because the task requires to calc only for 3 month*/
  FROM Employee
)
 T
WHERE RN_MONTH>1
ORDER BY 1 ASC, 2 DESC;
