/* Write your PL/SQL query statement below */
/*
2020-May-11. Oleksii Saiun.
LeetCode_#178. Rank Scores
https://leetcode.com/problems/rank-scores/
*/

SELECT
       score
      ,dense_rank() over(order by score desc) as Rank
FROM
    Scores;
