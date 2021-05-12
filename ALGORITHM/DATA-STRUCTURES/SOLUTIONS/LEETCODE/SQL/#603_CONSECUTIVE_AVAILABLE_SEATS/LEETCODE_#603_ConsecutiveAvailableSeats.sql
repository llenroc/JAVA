/* Write your PL/SQL query statement below */
/*
2020-May-11. Oleksii Saiun.
LeetCode_#603. Consecutive Available Seats
https://leetcode.com/problems/consecutive-available-seats/
*/

SELECT
      seat_id
FROM (
SELECT 
       seat_id
      ,free
      ,nvl(lead(free) over(order by SEAT_ID),0) as flag_lead
      ,nvl(lag(free) over(order by SEAT_ID),0) as flag_lag  
FROM
    cinema
) T    
WHERE 
         (free=1 and flag_lead=1) 
      or (free=1 and flag_lag=1);
