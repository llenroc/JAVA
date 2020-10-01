# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1148. Article Views I
https://leetcode.com/problems/article-views-i/
*/

SELECT DISTINCT author_id AS ID
FROM Views
WHERE author_id=viewer_id 
ORDER BY 1 ASC;     
