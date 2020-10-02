/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1082. Sales Analysis I
https://leetcode.com/problems/sales-analysis-i/
*/
SELECT SELLER_ID 
FROM
(
SELECT RANK() OVER(ORDER BY TOTAL DESC) AS RN,SELLER_ID,TOTAL
FROM(
     SELECT SELLER_ID, SUM(PRICE) AS TOTAL
     FROM SALES
     GROUP BY SELLER_ID
    )
    T1
)T2
WHERE RN=1;

