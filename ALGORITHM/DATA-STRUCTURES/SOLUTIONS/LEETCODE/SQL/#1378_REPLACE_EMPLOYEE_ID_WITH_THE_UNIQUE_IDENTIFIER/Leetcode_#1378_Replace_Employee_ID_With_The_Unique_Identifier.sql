/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#1378. Replace Employee ID With The Unique Identifier
https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
*/

SELECT U.unique_id, E.NAME
FROM
                 Employees E                  
      LEFT JOIN EmployeeUNI U
                 ON (E.ID=U.ID);               

