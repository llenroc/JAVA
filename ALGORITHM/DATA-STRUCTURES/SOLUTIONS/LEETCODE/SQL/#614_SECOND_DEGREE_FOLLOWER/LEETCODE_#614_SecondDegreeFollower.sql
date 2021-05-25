
/* Write your PL/SQL query statement below */
/*
2021-May-24. Oleksii Saiun.
LeetCode_#614. Second Degree Follower
https://leetcode.com/problems/second-degree-follower/
*/

with cte as
(
select distinct
      followee
     ,count(distinct follower) over(partition by followee) as num
from (select * from follow where followee != follower) t
)
select 
       c.followee as follower
      ,c.num
from 
               cte c
where  
      exists
            (select 1 from follow f where f.follower=c.followee)
order by follower;  
