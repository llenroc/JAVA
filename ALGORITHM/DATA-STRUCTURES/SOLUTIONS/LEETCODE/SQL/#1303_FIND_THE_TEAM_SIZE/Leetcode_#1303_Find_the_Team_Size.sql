# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1303. Find the Team Size
https://leetcode.com/problems/find-the-team-size/
*/
SELECT
      E.EMPLOYEE_ID, S.TEAM_SIZE
FROM
    Employee E INNER JOIN
(
SELECT 
      TEAM_ID, COUNT(*) AS TEAM_SIZE
FROM
    Employee 
GROUP BY 
     TEAM_ID
    ) S
              ON (E.TEAM_ID=S.TEAM_ID);
