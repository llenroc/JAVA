/* Write your PL/SQL query statement below */

/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#586. Customer Placing the Largest Number of Orders
https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
*/

SELECT 
      customer_number
FROM
(
SELECT       
      customer_number, COUNT(*)
FROM 
    orders 
GROUP BY customer_number    
    ORDER BY 2 DESC
)
WHERE ROWNUM=1
