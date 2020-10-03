/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#596. Classes More Than 5 Students
https://leetcode.com/problems/classes-more-than-5-students/
*/

SELECT 
      class
FROM courses 
GROUP BY
      class
HAVING COUNT(DISTINCT STUDENT) >= 5;      
