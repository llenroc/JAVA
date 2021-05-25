/* Write your PL/SQL query statement below */
/*
2021-May-18. Oleksii Saiun.
LeetCode_#597. Friend Requests I: Overall Acceptance Rate
https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/
*/


with 
 cte_requests as (
    select 
          distinct sender_id, send_to_id
    from FriendRequest),

  cte_accepted as (
    select 
          distinct requester_id, accepter_id
    from RequestAccepted),
  cte_total as (
    select
       (select count(*) from cte_accepted) as amt_accepted
      ,(select count(*) from cte_requests) as amt_requests
    from dual      
)
select 
      case 
           when amt_requests=0 then 0
           else round(amt_accepted/amt_requests,2)
      end   accept_rate
from cte_total;
