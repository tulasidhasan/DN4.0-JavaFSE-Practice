CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Update a customer's balance
UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

-- Check LastModified
SELECT CustomerID, Balance, LastModified FROM Customers WHERE CustomerID = 1;
