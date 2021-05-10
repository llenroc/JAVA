/* Write your PL/SQL query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#1270.  All People Report to the Given Manager
https://leetcode.com/problems/all-people-report-to-the-given-manager/

approach 1. connect by statement
*/

SELECT 
       DISTINCT employee_id   
FROM       
     Employees
WHERE 
     level != 1  
START WITH
          employee_id = 1
CONNECT BY
           NOCYCLE PRIOR employee_id = manager_id;
