/* Write your PL/SQL query statement below */
/*
2021-May-24. Oleksii Saiun.
LeetCode_#1113. Reported Posts
https://leetcode.com/problems/reported-posts/
*/

SELECT
       extra   as report_reason 
      ,count(distinct post_id) as report_count 
FROM 
    Actions 
WHERE  
      to_char(action_date,'YYYY-MM-DD')='2019-07-04' AND action='report'
GROUP BY  
       extra  
HAVING count(distinct post_id) > 0   and  extra is not null
