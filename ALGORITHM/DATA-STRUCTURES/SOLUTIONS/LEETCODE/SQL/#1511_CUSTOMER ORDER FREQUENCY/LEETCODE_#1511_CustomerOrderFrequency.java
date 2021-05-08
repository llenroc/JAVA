/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#1511. Customer Order Frequency
https://leetcode.com/problems/customer-order-frequency/
*/


WITH CTE_2020_JUNE 
AS
(
SELECT
       c.customer_id
      ,c.name
FROM
             Customers c
    INNER JOIN
             Orders o
             ON (c.customer_id=o.customer_id)
    INNER JOIN
             Product p
             ON (p.product_id=o.product_id)            
GROUP BY      
       c.customer_id
      ,c.name      
      ,to_char(o.order_date,'YYYY-MM')
HAVING 
       (sum(o.quantity*p.price) >= 100 and  to_char(o.order_date,'YYYY-MM') = '2020-06')
)
,
CTE_2020_JULY 
AS
(
SELECT
       c.customer_id
      ,c.name
FROM
             Customers c
    INNER JOIN
             Orders o
             ON (c.customer_id=o.customer_id)
    INNER JOIN
             Product p
             ON (p.product_id=o.product_id)            
GROUP BY      
       c.customer_id
      ,c.name      
      ,to_char(o.order_date,'YYYY-MM')
HAVING 
       (sum(o.quantity*p.price) >= 100 and  to_char(o.order_date,'YYYY-MM') = '2020-07')
)
--main query
SELECT c.customer_id, c.name FROM Customers c
WHERE 
     EXISTS
     (SELECT 1 FROM CTE_2020_JUNE cte WHERE cte.customer_id=c.customer_id)
  AND
     EXISTS
     (SELECT 1 FROM CTE_2020_JULY cte WHERE cte.customer_id=c.customer_id)
