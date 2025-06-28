CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/


-- Test with DOB
SELECT CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD')) AS Age FROM DUAL;

-- Check for all customers
SELECT CustomerID, Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;
