# Write your MySQL query statement below

Select D.Name AS 'Department',E.Name AS 'Employee',E.Salary from 
 Employee E join Department D on E.DepartmentId=D.Id 
 where (E.DepartmentId,Salary) in 
 (Select DepartmentId,max(Salary) from Employee group by DepartmentId );