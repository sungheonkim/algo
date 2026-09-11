-- 코드를 입력하세요
-- ID 별로 날짜 조건으로 더했을 때 0이상이면 누군가 대여하고 있는 상태
-- 큰 범위 WEHN - END는 더한 값이 0이상인지 판단, 작은범위는 날짜 판단



select
    car_id,
    case when sum(
                      case when '2022-10-16' between start_date and end_date then 1 else 0 end
              )>0 then '대여중' else '대여 가능' end as availbility

from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc
