DECLARE
    CURSOR senior_customers_cur IS
        SELECT c.CustomerID, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;

BEGIN
    FOR rec IN senior_customers_cur LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Discount applied to Loan ID: ' || rec.LoanID || ' | New Rate: ' || (rec.InterestRate - 1));
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.CustomerID || ' is not eligible (Age: ' || rec.Age || ')');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/

SELECT * FROM Loans;
