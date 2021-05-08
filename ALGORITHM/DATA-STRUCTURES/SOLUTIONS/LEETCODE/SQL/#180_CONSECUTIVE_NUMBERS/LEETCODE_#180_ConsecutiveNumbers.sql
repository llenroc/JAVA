/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#180. Consecutive Numbers
https://leetcode.com/problems/consecutive-numbers/
*/

SELECT 
      DISTINCT
      num as ConsecutiveNums 
FROM
(
SELECT
       num
      ,LEAD(num,1) OVER(ORDER BY id asc) as num_next
      ,LEAD(num,2) OVER(ORDER BY id asc) num_next_next
FROM
    Logs
) T
   WHERE 
        num=num_next and num=num_next_next;
