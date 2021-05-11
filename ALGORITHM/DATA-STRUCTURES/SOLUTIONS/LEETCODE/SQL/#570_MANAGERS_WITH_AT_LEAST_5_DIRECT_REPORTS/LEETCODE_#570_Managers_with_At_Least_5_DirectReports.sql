/* Write your PL/SQL query statement below */
/*
2020-May-10. Oleksii Saiun.
LeetCode_#570. Managers with at Least 5 Direct Reports
https://leetcode.com/problems/managers-with-at-least-5-direct-reports/

*/
SELECT 
      e2.Name
FROM         
               Employee e1
     INNER JOIN
               Employee e2
                  ON(e1.ManagerId=e2.Id)
GROUP BY   
        e2.Name
HAVING COUNT(*) >=5;
