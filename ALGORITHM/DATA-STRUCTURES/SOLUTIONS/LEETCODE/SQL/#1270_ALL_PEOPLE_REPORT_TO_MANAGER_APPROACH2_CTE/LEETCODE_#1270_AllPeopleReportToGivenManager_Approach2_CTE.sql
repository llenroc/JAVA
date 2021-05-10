/* Write your PL/SQL query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#1270.  All People Report to the Given Manager
https://leetcode.com/problems/all-people-report-to-the-given-manager/

approach 2. CTE statement
*/

WITH  CTE(employee_id,employee_name,manager_id,levelOfHierachy) AS 
(
 SELECT
       employee_id
      ,employee_name
      ,manager_id    
      ,1 as levelOfHierachy
 FROM 
     Employees
 WHERE     
     employee_id =1
UNION ALL    
 SELECT
       e.employee_id
      ,e.employee_name
      ,e.manager_id    
      ,levelOfHierachy + 1
 FROM 
               Employees e
     INNER JOIN
               CTE c
               ON(e.manager_id=c.employee_id)
 WHERE     
     e.employee_id != 1    
)
SELECT 
      DISTINCT employee_id
FROM CTE
WHERE 
      levelOfHierachy!=1
