구매기록이 다음과 같은 테이블로 존재한다. (해당일의 구매액의 합계만 존재하는 테이블이라고 가정한다.)

MEM_NO : 회원 번호 (int)
SALES_DATE : 구입 날짜 (date)
SALES_AMOUNT : 구매액 (int)

지난달에 구매한 회원 중 이번달에 구매하지 않은 회원의 지난달  구매 총액을 구하여 총액이 많은 순으로 정렬하라.
(지난달 : 2018년 6월, 이번달 : 2018년 7월)

결과 예시)

MEM_NO SALES_SUM

1    16700
2    11890

주의 : 주어진 샘플데이터로만 정답이 나오면 안됩니다.
4개의 테스트케이스 데이터셋이 별도로 존재합니다.

SELECT 
  MEM_NO,
  SUM(SALES_AMOUNT) AS TOTAL_AMOUNT 
FROM
  SALES_DATA 
WHERE SALES_DATE LIKE '2018-06%' 
  AND MEM_NO NOT IN 
  (SELECT 
    MEM_NO 
  FROM
    SALES_DATA 
  WHERE SALES_DATE LIKE '2018-07%') 
GROUP BY MEM_NO 
ORDER BY TOTAL_AMOUNT DESC ;