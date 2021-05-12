/* Write your PL/SQL query statement below */
/*
2020-May-11. Oleksii Saiun.
LeetCode_#183. Customers Who Never Order
https://leetcode.com/problems/customers-who-never-order/
*/

SELECT
       c.Name as Customers   
FROM 
    Customers c
WHERE NOT EXISTS
                (SELECT 1 FROM Orders o where o.CustomerId =c.Id);
