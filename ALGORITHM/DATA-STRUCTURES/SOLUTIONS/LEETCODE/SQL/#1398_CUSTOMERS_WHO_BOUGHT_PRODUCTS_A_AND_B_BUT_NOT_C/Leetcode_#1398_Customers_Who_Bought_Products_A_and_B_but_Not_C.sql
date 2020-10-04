/* Write your PL/SQL query statement below */

/*
2020-Oct-04. Oleksii Saiun.
LeetCode_1398. Customers Who Bought Products A and B but Not C
https://leetcode.com/problems/customers-who-bought-products-a-and-b-but-not-c/
*/

SELECT
     DISTINCT C.CUSTOMER_ID, C.CUSTOMER_NAME
FROM 
               CUSTOMERS C
     INNER JOIN ORDERS O
            ON (C.CUSTOMER_ID=O.CUSTOMER_ID)
WHERE 
     EXISTS
     (
       SELECT 1 FROM ORDERS O2 WHERE O2.CUSTOMER_ID=O.CUSTOMER_ID  AND 
          O2.PRODUCT_NAME='A'
     )
     AND 
          EXISTS
     (
       SELECT 1 FROM ORDERS O2 WHERE O2.CUSTOMER_ID=O.CUSTOMER_ID  AND 
          O2.PRODUCT_NAME='B'
     )
     AND
        NOT  EXISTS
     (
       SELECT 1 FROM ORDERS O2 WHERE O2.CUSTOMER_ID=O.CUSTOMER_ID  AND 
          O2.PRODUCT_NAME='C'
     );
     
ORDER BY CUSTOMER_ID;     
