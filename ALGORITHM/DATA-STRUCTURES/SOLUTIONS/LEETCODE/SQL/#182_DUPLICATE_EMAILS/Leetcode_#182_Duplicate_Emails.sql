/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#182. Duplicate Emails
https://leetcode.com/problems/duplicate-emails/
*/

SELECT EMAIL
FROM Person
GROUP BY EMAIL
HAVING COUNT(*)>1
