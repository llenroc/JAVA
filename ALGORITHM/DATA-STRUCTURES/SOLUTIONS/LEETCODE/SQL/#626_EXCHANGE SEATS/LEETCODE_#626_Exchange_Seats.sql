/* Write your PL/SQL query statement below */
/*
2020-May-10. Oleksii Saiun.
LeetCode_#626. Exchange Seats
https://leetcode.com/problems/exchange-seats/
*/


select 
     id
    ,nvl(
        case 
              when mod(id,2)=0 then lag(student) over( order by id)
              when mod(id,2)!=0 then lead(student) over( order by id)
        end
           ,student) as student 
from seat;
