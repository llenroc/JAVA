/* Write your PL/SQL query statement below */

/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#615. Average Salary: Departments VS Company
https://leetcode.com/problems/average-salary-departments-vs-company/
*/

SELECT DISTINCT
       TO_CHAR(pay_date,'YYYY-MM') AS pay_month 
     ,department_id
     ,CASE
          WHEN AVG_OF_DEP/AVG_ALL >1 THEN 'higher'
          WHEN AVG_OF_DEP/AVG_ALL = 1 THEN 'same'
          ELSE 'lower'
      END comparison  
     
FROM 
(
SELECT
      S.pay_date
     ,E.department_id
     ,AVG(S.AMOUNT) OVER(PARTITION BY E.department_id, TO_CHAR(S.pay_date,'YYYY-MM')) AS AVG_OF_DEP
     ,AVG(S.AMOUNT) OVER(PARTITION BY TO_CHAR(S.pay_date,'YYYY-MM')) AS AVG_ALL
FROM 
               salary S 
    INNER JOIN employee E
               ON (S.employee_id=E.employee_id)
    ) T;
