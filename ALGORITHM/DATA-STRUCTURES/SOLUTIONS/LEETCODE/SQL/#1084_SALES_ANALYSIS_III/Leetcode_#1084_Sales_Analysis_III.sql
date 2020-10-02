/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1084. Sales Analysis III
https://leetcode.com/problems/sales-analysis-iii/
*/
SELECT
      DISTINCT 
              P.PRODUCT_ID, P.PRODUCT_NAME 
FROM      
    PRODUCT P INNER JOIN SALES S
              ON (P.PRODUCT_ID=S.PRODUCT_ID)
WHERE  TO_CHAR(SALE_DATE,'YYYY-MM-DD') BETWEEN '2019-01-01' AND '2019-03-31'
       AND P.PRODUCT_ID NOT IN 
          (SELECT 
                  P.PRODUCT_ID 
           FROM
                PRODUCT P INNER JOIN SALES S
                    ON (P.PRODUCT_ID=S.PRODUCT_ID)
           WHERE TO_CHAR(SALE_DATE,'YYYY-MM-DD') NOT BETWEEN '2019-01-01' AND '2019-03-31'         
          )
