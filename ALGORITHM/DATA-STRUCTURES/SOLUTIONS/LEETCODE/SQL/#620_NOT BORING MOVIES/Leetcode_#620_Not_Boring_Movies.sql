# Write your MySQL query statement below

/*
2020-Oct-04. Oleksii Saiun.
LeetCode_620. Not Boring Movies
https://leetcode.com/problems/not-boring-movies/
*/

SELECT id, movie, description, rating  
FROM
    cinema C
WHERE id%2!=0 AND  
    NOT EXISTS
    (SELECT 1 FROM cinema C2 WHERE C2.id=C.id AND description ='boring')
order by rating desc 
    
