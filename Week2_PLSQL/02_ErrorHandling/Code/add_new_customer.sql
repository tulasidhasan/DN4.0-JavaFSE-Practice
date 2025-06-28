CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id   IN NUMBER,
    p_name          IN VARCHAR2,
    p_dob           IN DATE,
    p_balance       IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully. ID: ' || p_customer_id);
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

-- Valid new customer
EXEC AddNewCustomer(3, 'David Miller', TO_DATE('1988-10-22', 'YYYY-MM-DD'), 1200);

-- Duplicate customer (ID already exists)
EXEC AddNewCustomer(1, 'Duplicate John', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 999);
