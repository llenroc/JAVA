/* Write your PL/SQL query statement below */
/*
2020-Oct-03. Oleksii Saiun.
LeetCode_#577. Employee Bonus
https://leetcode.com/problems/employee-bonus/
*/

SELECT
      E.NAME, B.BONUS AS BONUS
FROM  
               Employee E 
     LEFT JOIN BONUS B
               ON(E.EMPID=B.EMPID)     
WHERE B.BONUS IS NULL OR B.BONUS <1000;   
