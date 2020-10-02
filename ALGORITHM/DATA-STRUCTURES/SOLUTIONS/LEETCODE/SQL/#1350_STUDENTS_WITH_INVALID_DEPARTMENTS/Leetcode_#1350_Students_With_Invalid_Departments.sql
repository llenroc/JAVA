/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1350. Students With Invalid Departments
https://leetcode.com/problems/students-with-invalid-departments/
*/

SELECT 
      DISTINCT S.ID, S.NAME
FROM
       Students S LEFT JOIN Departments D
       ON(S.department_id=D.ID)
WHERE
     D.ID IS NULL;
