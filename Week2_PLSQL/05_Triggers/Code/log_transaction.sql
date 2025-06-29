CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AccountID, TransactionDate, Amount, TransactionType
    ) VALUES (
        :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType
    );
END;
/

-- Insert a sample transaction
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (Transactions_seq.NEXTVAL, 1, SYSDATE, 250, 'Deposit');

-- Check AuditLog
SELECT * FROM AuditLog;
