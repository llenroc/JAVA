# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#595. Big Countries
https://leetcode.com/problems/big-countries/
*/

SELECT name, population, area           
FROM
    World
WHERE  area > 3000000 OR population > 25000000;             
