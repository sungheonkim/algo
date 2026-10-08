-- 코드를 입력하세요


select
    category,
    price as max_price,
    product_name
from
    (
        select
            category,
            price,
            product_name,
            rank() over(partition by category order by price desc) as rk
        from food_product
    ) as a
where rk=1 and category in ('과자','국','김치','식용유')
order by max_price desc
-- rank() over로 연습하자