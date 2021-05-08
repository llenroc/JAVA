/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#181. Employees Earning More Than Their Managers
https://leetcode.com/problems/employees-earning-more-than-their-managers/
*/

SELECT E1.Name AS Employee 
FROM Employee E1 LEFT JOIN Employee E2
     ON (E1.ManagerId=E2.ID)
WHERE E1.SALARY>E2.SALARY
