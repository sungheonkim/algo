# -- 코드를 입력하세요
# SELECT MONTH(START_DATE) AS MONTH,CAR_ID,COUNT(HISTORY_ID) AS RECORDS
      # FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      # WHERE (DATE_FORMAT(START_DATE,'%Y-%m') BETWEEN '2022-08' AND '2022-10')
      # AND CAR_ID IN
      # (
      #     SELECT CAR_ID
      #     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      #     WHERE (DATE_FORMAT(START_DATE,'%Y-%m') BETWEEN '2022-08' AND '2022-10')
      #     GROUP BY CAR_ID
      #     HAVING COUNT(*) >= 5
      # )
      # GROUP BY MONTH, CAR_ID
      # HAVING RECORDS>0
      # ORDER BY MONTH ASC,CAR_ID DESC





select
    month(start_date) as month, car_id, count(history_id) as records

from car_rental_company_rental_history
where(date_format(start_date,"%Y-%m") between '2022-08' and '2022-10')
  and car_id in (
    select car_id
    from car_rental_company_rental_history
    where (date_format(start_date,"%Y-%m") between '2022-08' and '2022-10')
    group by car_id
    having count(*)>=5
    )
group by month,car_id
having records>0
order by month asc,car_id desc
