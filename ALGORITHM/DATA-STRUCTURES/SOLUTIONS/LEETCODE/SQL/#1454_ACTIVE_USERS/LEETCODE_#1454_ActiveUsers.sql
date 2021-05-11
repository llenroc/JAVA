/* Write your PL/SQL query statement below */
/*
2020-May-11. Oleksii Saiun.
LeetCode_#1454. Active Users
https://leetcode.com/problems/active-users/
*/

WITH cte1 as
(
  SELECT 
       distinct  id
      ,login_date
 FROM Logins
)
,
cte2 as
(
SELECT 
       id
      ,login_date
      ,lead(login_date,4) over(partition by id order by login_date) as login_nextdate5
FROM cte1
)
SELECT DISTINCT
      c.id
     ,a.name
FROM cte2 c INNER JOIN Accounts a
          ON(c.id=a.id)
WHERE to_number(c.login_nextdate5-c.login_date) = 4
ORDER BY  c.id;
