/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1571. Warehouse Manager
https://leetcode.com/problems/warehouse-manager/
*/

SELECT 
       W.NAME AS WAREHOUSE_NAME, SUM(W.UNITS*P.WIDTH*P.LENGTH*P.HEIGHT) AS VOLUME
FROM 
                WAREHOUSE W 
     INNER JOIN PRODUCTS P
                ON (W.PRODUCT_ID=P.PRODUCT_ID)
GROUP BY
        W.NAME;
