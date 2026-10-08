-- 코드를 입력하세요
SELECT
    b.author_id,
    a.author_name,
    b.category,
    sum(b.price*s.sales) as total_sales
from book b
         join book_sales s on b.book_id=s.book_id
         join author a on a.author_id=b.author_id
where s.sales_date like '2022-01%'
group by b.author_id,a.author_name,b.category
order by b.author_id asc, b.category desc

-- 1. 2022년 1월  2. total_sales= 판매량 *판매가
-- 2. 저자 id asc, 카테고리 desc