DECLARE
    CURSOR loan_cur IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

BEGIN
    FOR loan_rec IN loan_cur LOOP
        IF loan_rec.LoanAmount > 5000 THEN
            UPDATE Loans
            SET InterestRate = InterestRate + 0.5
            WHERE LoanID = loan_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Increased interest for Loan ID ' || loan_rec.LoanID ||
                                 ' | New Rate: ' || (loan_rec.InterestRate + 0.5));
        ELSE
            UPDATE Loans
            SET InterestRate = InterestRate - 0.25
            WHERE LoanID = loan_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Decreased interest for Loan ID ' || loan_rec.LoanID ||
                                 ' | New Rate: ' || (loan_rec.InterestRate - 0.25));
        END IF;
    END LOOP;

    COMMIT;
END;
/

SELECT * FROM Loans;
