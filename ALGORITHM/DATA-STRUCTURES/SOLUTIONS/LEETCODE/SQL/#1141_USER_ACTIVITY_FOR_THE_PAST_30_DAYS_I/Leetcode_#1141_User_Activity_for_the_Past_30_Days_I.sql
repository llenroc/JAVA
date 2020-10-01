/* Write your PL/SQL query statement below */

/*
2020-Oct-01. Oleksii Saiun.
LeetCode_#1141. 1141. User Activity for the Past 30 Days I
https://leetcode.com/problems/user-activity-for-the-past-30-days-i/
*/

SELECT TO_CHAR(A.ACTIVITY_DATE, 'YYYY-MM-DD') AS DAY, COUNT(DISTINCT A.USER_ID) AS ACTIVE_USERS
FROM 
     Activity A
 WHERE 
        A.ACTIVITY_DATE BETWEEN TO_DATE('2019-07-27','YYYY-MM-DD') - 29 AND TO_DATE('2019-07-27','YYYY-MM-DD')
GROUP BY  TO_CHAR(A.ACTIVITY_DATE, 'YYYY-MM-DD');

ORDER BY 1
     
