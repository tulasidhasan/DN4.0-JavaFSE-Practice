DECLARE
    CURSOR account_cur IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_fee CONSTANT NUMBER := 100;  -- Fixed annual fee
BEGIN
    FOR acc_rec IN account_cur LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' applied to Account ID ' || acc_rec.AccountID);
    END LOOP;

    COMMIT;
END;
/


SELECT AccountID, Balance FROM Accounts;
