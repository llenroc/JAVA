/* Write your PL/SQL query statement below */
/*
2021-May-28. Oleksii Saiun.
LeetCode_#262. Trips and Users
https://leetcode.com/problems/second-degree-follower/
*/

with 
    cte_calendar as
(
  select  
        distinct Request_at as date_of_calendar 
  from Trips
             where 
                    (Request_at between '2013-10-01' and '2013-10-03' )
                 and client_id not in (select Users_Id from Users where Banned = 'Yes')    
                 and driver_id not in (select Users_Id from Users where Banned = 'Yes')    
),
    cte_main as
(    
select distinct
        t.Request_at
       ,count(*)  over(partition by t.Request_at) as total_count_per_day
       ,count(*)  over(partition by t.Request_at, status) as total_count_by_status_per_day
       ,status
from 
               Trips t 
    inner join 
               users cl
              on (t.client_id=cl.users_id)
    inner join 
               users dr
              on (t.driver_id=dr.users_id)              
where 
       cl.banned='No'
      and dr.banned='No'
)
select 
      c.date_of_calendar as Day        
     ,round(nvl(m.total_count_by_status_per_day/m.total_count_per_day,0),2) as "Cancellation Rate"
from    
             cte_calendar c
    left join 
             cte_main m
             on (c.date_of_calendar = m.Request_at and (m.status = 'cancelled_by_driver' or m.status = 'cancelled_by_client'))                    
