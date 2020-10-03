/* Write your PL/SQL query statement below */

/*
2020-Oct-03. Oleksii Saiun.
LeetCode_1607. Sellers With No Sales
https://leetcode.com/problems/sellers-with-no-sales/
*/

SELECT 
      S.seller_name
FROM 
    Seller S
            LEFT JOIN
(
SELECT seller_id
FROM Orders 
WHERE TO_CHAR(sale_date,'YYYY') ='2020' 
) T    
     ON (S.seller_id=T.seller_id)
WHERE              
     T.seller_id IS NULL
ORDER BY 1 ASC;     
