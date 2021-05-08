/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#184. Department Highest Salary
https://leetcode.com/problems/department-highest-salary/
*/

SELECT
       Department
      ,Employee
      ,Salary
FROM
     (
SELECT
       d.Name As Department
      ,e.Name As Employee
      ,e.Salary
      ,DENSE_RANK() OVER(PARTITION BY d.Name ORDER BY e.Salary DESC) AS RN                        
FROM
              Department d
    INNER JOIN
              Employee e
             ON (d.Id=e.DepartmentId)
) T
WHERE 
     RN=1;
