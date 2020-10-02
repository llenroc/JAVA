/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1083. Sales Analysis II
https://leetcode.com/problems/sales-analysis-ii/
*/

SELECT
      DISTINCT S.BUYER_ID
FROM SALES S INNER JOIN PRODUCT P
             ON (S.PRODUCT_ID=P.PRODUCT_ID)
WHERE
        P.PRODUCT_NAME='S8'
    AND S.BUYER_ID 
                  NOT IN (SELECT 
                                BUYER_ID 
                          FROM 
                               SALES S INNER JOIN PRODUCT P
                                       ON (S.PRODUCT_ID=P.PRODUCT_ID)
                          WHERE
                               P.PRODUCT_NAME='iPhone'
                          );
