SELECT 
    e.EMP_NO,
    e.EMP_NAME,
    CASE 
        WHEN AVG(g.SCORE) >= 96 THEN 'S'
        WHEN AVG(g.SCORE) >= 90 THEN 'A'
        WHEN AVG(g.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE 
        WHEN AVG(g.SCORE) >= 96 THEN e.SAL * 0.20
        WHEN AVG(g.SCORE) >= 90 THEN e.SAL * 0.15
        WHEN AVG(g.SCORE) >= 80 THEN e.SAL * 0.10
        ELSE 0
    END AS BONUS
FROM 
    HR_EMPLOYEES e
JOIN 
    HR_GRADE g ON e.EMP_NO = g.EMP_NO
WHERE 
    g.YEAR = 2022
GROUP BY 
    e.EMP_NO, e.EMP_NAME, e.SAL
ORDER BY 
    e.EMP_NO;