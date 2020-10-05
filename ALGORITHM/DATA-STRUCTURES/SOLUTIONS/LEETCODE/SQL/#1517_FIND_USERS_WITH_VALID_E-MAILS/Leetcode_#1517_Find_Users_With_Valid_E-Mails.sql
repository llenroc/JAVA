# Write your MySQL query statement below

/*
2020-Oct-04. Oleksii Saiun.
LeetCode_1517. Find Users With Valid E-Mails
https://leetcode.com/problems/find-users-with-valid-e-mails/
*/

select * from Users
where mail regexp '^[A-Za-z][A-Za-z0-9_.-]*@leetcode.com$';
