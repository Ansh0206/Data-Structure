# Write your MySQL query statement below
select Department,Employee,Salary
from (
    select e.name as Employee,
    e.salary as Salary,
    d.name as Department,
    dense_rank() over (partition by d.name order by e.salary desc) as rnk
    from Employee as e
    left join Department as d
    on e.departmentId=d.id

) temp
where rnk<=3
