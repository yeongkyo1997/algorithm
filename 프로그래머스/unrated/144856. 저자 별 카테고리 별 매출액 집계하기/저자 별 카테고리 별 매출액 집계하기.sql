SELECT BO.AUTHOR_ID, AU.AUTHOR_NAME, BO.CATEGORY, SUM(BO.PRICE * BS.SALES) AS TOTAL_SALES
FROM BOOK BO
JOIN AUTHOR AU
ON BO.AUTHOR_ID = AU.AUTHOR_ID
JOIN BOOK_SALES BS
ON BO.BOOK_ID = BS.BOOK_ID
WHERE DATE_FORMAT(BS.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY BO.CATEGORY, BO.AUTHOR_ID
ORDER BY 1, 3 DESC