/* Write your PL/SQL query statement below */
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1581. Customer Who Visited but Did Not Make Any Transactions
https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
*/

SELECT V.CUSTOMER_ID, COUNT(*) AS COUNT_NO_TRANS
      FROM 
                VISITS V 
      LEFT JOIN TRANSACTIONS T 
                 ON (V.VISIT_ID =T.VISIT_ID)
 WHERE T.VISIT_ID IS NULL
 GROUP BY V.CUSTOMER_ID;
                 
      
