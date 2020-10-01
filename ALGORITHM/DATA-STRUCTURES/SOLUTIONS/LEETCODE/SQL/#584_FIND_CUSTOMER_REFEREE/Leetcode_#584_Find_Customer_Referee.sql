# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#584. Find Customer Referee
https://leetcode.com/problems/find-customer-referee/
*/

SELECT NAME 
FROM customer 
WHERE COALESCE(REFEREE_ID,999) NOT IN (2)
