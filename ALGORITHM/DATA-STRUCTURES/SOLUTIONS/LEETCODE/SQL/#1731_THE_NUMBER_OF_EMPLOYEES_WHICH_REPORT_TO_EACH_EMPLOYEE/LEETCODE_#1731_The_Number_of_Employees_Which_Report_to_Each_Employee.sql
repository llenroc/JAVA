/* Write your PL/SQL query statement below */
/*
2020-May-10. Oleksii Saiun.
LeetCode_#1731. The Number of Employees Which Report to Each Employee
https://leetcode.com/problems/managers-with-at-least-5-direct-reports/

*/

SELECT 
       e2.employee_id
      ,e2.name
      ,count(*) as reports_count 
      ,round(avg(e1.age),0) as average_age 
FROM 
              Employees e1
    INNER JOIN
              Employees e2
             ON (e1.reports_to=e2.employee_id)
GROUP BY
       e2.employee_id
      ,e2.name
HAVING
       nvl(count(*),0)>0
ORDER BY employee_id;       
