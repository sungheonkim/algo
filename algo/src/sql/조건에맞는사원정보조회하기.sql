-- 코드를 작성해주세요

select a.score,a.emp_no,a.emp_name,a.position,a.email
from(
        select
            sum(g.score) as score,
            e.emp_no,
            e.emp_name,
            e.position,
            e.email,
            rank() over(order by sum(g.score) desc) as rnk
        from HR_EMPLOYEES e
                 join HR_GRADE g
                      on e.emp_no=g.emp_no
        group by e.emp_no,e.emp_name,e.position,e.email
    ) as a
where rnk=1