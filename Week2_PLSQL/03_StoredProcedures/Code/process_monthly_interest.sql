CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (acc.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID ' || acc.AccountID ||
                             '. Old Balance: ' || acc.Balance ||
                             ', New Balance: ' || (acc.Balance + (acc.Balance * 0.01)));
    END LOOP;

    COMMIT;
END;
/

EXEC ProcessMonthlyInterest;

SELECT * FROM Accounts WHERE AccountType = 'Savings';
