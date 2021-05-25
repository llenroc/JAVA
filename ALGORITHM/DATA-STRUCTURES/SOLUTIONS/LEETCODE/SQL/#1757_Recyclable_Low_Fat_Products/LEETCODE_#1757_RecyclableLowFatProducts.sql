/* Write your PL/SQL query statement below */
/*
2021-May-24. Oleksii Saiun.
LeetCode_#1757. Recyclable and Low Fat Products
https://leetcode.com/problems/recyclable-and-low-fat-products/
*/

SELECT
       product_id
FROM 
     Products
WHERE
      low_fats ='Y' and recyclable ='Y'
