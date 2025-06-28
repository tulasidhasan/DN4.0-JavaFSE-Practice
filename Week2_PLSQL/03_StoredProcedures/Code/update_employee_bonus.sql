CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department     IN VARCHAR2,
    p_bonus_percent  IN NUMBER
) AS
BEGIN
    FOR emp IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (emp.Salary * p_bonus_percent / 100)
        WHERE EmployeeID = emp.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID ' || emp.EmployeeID ||
                             '. Old Salary: ' || emp.Salary ||
                             ', New Salary: ' || (emp.Salary + (emp.Salary * p_bonus_percent / 100)));
    END LOOP;

    COMMIT;
END;
/

EXEC UpdateEmployeeBonus('IT', 10);

SELECT * FROM Employees WHERE Department = 'IT';
