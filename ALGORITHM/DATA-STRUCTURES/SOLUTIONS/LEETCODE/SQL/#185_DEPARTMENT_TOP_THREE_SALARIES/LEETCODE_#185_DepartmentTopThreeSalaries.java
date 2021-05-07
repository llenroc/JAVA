/* Write your MySQL query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#185. Department Top Three Salaries
https://leetcode.com/problems/department-top-three-salaries/
*/
SELECT 
       Department
      ,Employee
      ,Salary  
FROM 
    (
SELECT
       d.name as Department
      ,e.name as Employee
      ,e.salary
      ,dense_rank() over(partition by e.Departmentid order by e.salary desc) as RN        
FROM
             Department d
    INNER JOIN
             Employee e
    ON (d.id=e.Departmentid)
)
 T
WHERE  RN<=3;
