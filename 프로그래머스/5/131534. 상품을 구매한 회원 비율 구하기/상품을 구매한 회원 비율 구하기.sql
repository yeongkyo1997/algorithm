WITH total_users AS (
    SELECT COUNT(*) AS total
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
),
purchased_users AS (
    SELECT 
        YEAR(O.SALES_DATE) AS YEAR, 
        MONTH(O.SALES_DATE) AS MONTH, 
        COUNT(DISTINCT O.USER_ID) AS PURCHASED_USERS
    FROM ONLINE_SALE O
    JOIN USER_INFO U ON O.USER_ID = U.USER_ID
    WHERE YEAR(U.JOINED) = 2021
    GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
)
SELECT 
    p.YEAR, 
    p.MONTH,
    p.PURCHASED_USERS,
    ROUND(p.PURCHASED_USERS / t.total, 1) AS PURCHASED_RATIO
FROM purchased_users p
CROSS JOIN total_users t
ORDER BY p.YEAR ASC, p.MONTH ASC;