# Write your MySQL query statement below
/*
2020-Sep-29. Oleksii Saiun.
LeetCode_#1587. Bank Account Summary II
https://leetcode.com/problems/bank-account-summary-ii/
*/
SELECT NAME, BALANCE
FROM (
SELECT U.NAME, T.ACCOUNT, SUM(T.AMOUNT) AS BALANCE
FROM
    USERS U INNER JOIN TRANSACTIONS T
            ON (U.ACCOUNT=T.ACCOUNT)
GROUP BY U.NAME, T.ACCOUNT     
HAVING SUM(T.AMOUNT)>10000
) T;    
    
