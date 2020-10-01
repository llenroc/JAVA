# Write your MySQL query statement below
/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1050. Actors and Directors Who Cooperated At Least Three Times
https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/
*/
SELECT ACTOR_ID, DIRECTOR_ID   
FROM 
    ActorDirector
GROUP BY ACTOR_ID, DIRECTOR_ID
HAVING COUNT(*) >= 3;
