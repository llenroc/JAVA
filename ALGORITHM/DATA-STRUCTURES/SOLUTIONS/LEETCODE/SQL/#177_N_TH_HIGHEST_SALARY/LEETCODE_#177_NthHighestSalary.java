/* Write your Oracle query statement below */
/*
2020-May-07. Oleksii Saiun.
LeetCode_#177. Nth Highest Salary
https://leetcode.com/problems/nth-highest-salary/
*/

CREATE FUNCTION getNthHighestSalary(N IN NUMBER)
RETURN NUMBER IS
v_count number;
result NUMBER;
BEGIN
   select count(*) into v_count from Employee;

   IF N > v_count THEN
      result := null;
   ELSE      
      SELECT
            max(salary) as salary /* i take max to avoid dups if there are a few the same results*/
      INTO result
      FROM (
        SELECT 
              salary
             ,dense_rank() over(order by salary desc) as rn
        FROM
             Employee
      ) T
      WHERE rn=N;
                 
   END IF;
    
    RETURN result;
END;

 
