/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#1142. User Activity for the Past 30 Days II
https://leetcode.com/problems/user-activity-for-the-past-30-days-ii/
*/

SELECT 
     CASE 
	     WHEN COUNT(*) = 0 THEN 0.00
     ELSE ROUND(SUM(COUNT_PER_USER)/COUNT(*),2)
END AVERAGE_SESSIONS_PER_USER
FROM(
     SELECT USER_ID, COUNT(DISTINCT SESSION_ID) AS COUNT_PER_USER
     FROM 
          ACTIVITY A
      WHERE 
             A.ACTIVITY_DATE BETWEEN TO_DATE('2019-07-27','YYYY-MM-DD') - 29 AND TO_DATE('2019-07-27','YYYY-MM-DD')
     GROUP BY USER_ID
)
T;
