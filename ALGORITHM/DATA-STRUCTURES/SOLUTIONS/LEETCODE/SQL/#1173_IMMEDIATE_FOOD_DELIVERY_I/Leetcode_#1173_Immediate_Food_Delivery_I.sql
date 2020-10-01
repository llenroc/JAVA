# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1173. Immediate Food Delivery I
https://leetcode.com/problems/immediate-food-delivery-i/
*/

SELECT ROUND(100*(T2.COUNT_IMMEDIATE / COUNT(T1.delivery_id)),2) AS IMMEDIATE_PERCENTAGE 
FROM 
Delivery T1 CROSS JOIN
(
SELECT 
       COUNT(*) AS COUNT_IMMEDIATE
FROM Delivery
WHERE 
     ORDER_DATE = CUSTOMER_PREF_DELIVERY_DATE
) T2;
