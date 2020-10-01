/* Write your PL/SQL query statement below */
/*
2020-Sep-29. Oleksii Saiun.
LeetCode_#627. Swap Salary
https://leetcode.com/problems/swap-salary/
*/
update salary
set sex
       =
        case 
             when sex='m' then 'f'
             when sex='f' then 'm'
        end;
