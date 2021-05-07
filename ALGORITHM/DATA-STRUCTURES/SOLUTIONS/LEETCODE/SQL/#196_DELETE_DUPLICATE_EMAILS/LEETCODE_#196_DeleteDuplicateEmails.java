/* Write your MySQl query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#196. Delete Duplicate Emails
https://leetcode.com/problems/delete-duplicate-emails/
*/

WITH CTE 
AS
(
SELECT 
      ID
	 ,ROW_NUMBER() OVER(PARTITION BY EMAIL ORDER BY ID ) AS RN
FROM       
    Person
)
DELETE FROM Person
WHERE EXISTS (SELECT 1 FROM CTE WHERE CTE.ID=Person.ID AND CTE.RN>1)
