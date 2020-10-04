/*
2020-Oct-03. Oleksii Saiun.
LeetCode_1280. Students and Examinations
https://leetcode.com/problems/students-and-examinations/
*/

SELECT  T.STUDENT_ID, T.STUDENT_NAME, T.SUBJECT_NAME, COUNT(E.STUDENT_ID) AS attended_exams
FROM
(
SELECT  S.STUDENT_ID, S.STUDENT_NAME, B.SUBJECT_NAME
FROM 
	         Students S
    CROSS JOIN
             Subjects B         
)
 T             
   LEFT JOIN                      
               Examinations E
                            ON (T.STUDENT_ID=E.STUDENT_ID AND T.SUBJECT_NAME=E.SUBJECT_NAME)
GROUP BY
		T.STUDENT_ID, T.STUDENT_NAME, T.SUBJECT_NAME
ORDER BY T.STUDENT_ID, T.STUDENT_NAME;  
