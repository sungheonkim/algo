-- 코드를 입력하세요
SELECT
    ai.name,
    ai.datetime
from animal_ins ai
         left join animal_outs ao
                   on ao.animal_id= ai.animal_id
where ao.animal_id is null
order by ai.datetime asc
    limit 3;