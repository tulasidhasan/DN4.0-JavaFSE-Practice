DECLARE
    CURSOR monthly_txn_cur IS
        SELECT c.CustomerID, c.Name, a.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY c.CustomerID, t.TransactionDate;

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Monthly Transaction Statements ---');

    FOR rec IN monthly_txn_cur LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name ||
                             ' | Account: ' || rec.AccountID ||
                             ' | Date: ' || TO_CHAR(rec.TransactionDate, 'DD-Mon-YYYY') ||
                             ' | Type: ' || rec.TransactionType ||
                             ' | Amount: ' || rec.Amount);
    END LOOP;
END;
/
-- To execute this script, ensure that the DBMS_OUTPUT is enabled in your SQL client.
-- For example, in SQL Developer, you can enable it by clicking on the "DBMS Output" tab.   