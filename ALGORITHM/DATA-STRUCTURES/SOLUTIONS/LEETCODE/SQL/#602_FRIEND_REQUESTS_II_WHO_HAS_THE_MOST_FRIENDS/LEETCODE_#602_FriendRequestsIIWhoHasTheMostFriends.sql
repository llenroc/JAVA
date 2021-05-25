/* Write your PL/SQL query statement below */
/*
2021-May-24. Oleksii Saiun.
LeetCode_#602. Friend Requests II: Who Has the Most Friends
https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/
*/

with 
   cte as (
  select 
         distinct 
         requester_id as id
        ,count(accepter_id) over(partition by requester_id) as num --amt_friends_of_requester
  from 
      request_accepted
  union all
  select 
         distinct
         accepter_id as id
        ,count(requester_id) over(partition by accepter_id) as num --amt_friends_of_accepter
  from 
      request_accepted
), 
  cte_total as (
  select 
        id
       ,sum(num) over(partition by id) as num
  from 
      cte
  order by 2 desc
)
 select 
       id,num 
 from cte_total 
 where rownum=1;
