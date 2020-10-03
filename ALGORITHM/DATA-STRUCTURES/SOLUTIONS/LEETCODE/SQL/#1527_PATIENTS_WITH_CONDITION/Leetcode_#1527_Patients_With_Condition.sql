/* Write your PL/SQL query statement below */
/*
2020-Oct-02. Oleksii Saiun.
LeetCode_#1527. Patients With a Condition
https://leetcode.com/problems/patients-with-a-condition/
*/

SELECT
       patient_id, patient_name, conditions 
FROM
    Patients
WHERE 
     conditions LIKE '%DIAB1%'  
