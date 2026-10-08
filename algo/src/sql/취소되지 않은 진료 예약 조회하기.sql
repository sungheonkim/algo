-- 코드를 입력하세요
SELECT
    a.apnt_no,
    p.pt_name,
    p.pt_no,
    a.mcdp_cd,
    d.dr_name,
    a.apnt_ymd
from appointment a
         join doctor d on a.mddr_id= d.dr_id
         join patient p on a.pt_no=p.pt_no
where
    a.apnt_cncl_yn ='N' and
    d.mcdp_cd='CS' and
    date_format(a.apnt_ymd,'%Y-%m-%d') ='2022-04-13'
order by a.apnt_ymd asc

-- 1. 2022-04-13 취소되지 않은 cs 진료 예약 조회
--