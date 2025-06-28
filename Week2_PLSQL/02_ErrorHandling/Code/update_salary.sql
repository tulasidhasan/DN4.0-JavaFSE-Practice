CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id     IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_old_salary Employees.Salary%TYPE;
BEGIN
    -- Get current salary
    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID ' || p_emp_id ||
                         '. Old Salary: ' || v_old_salary ||
                         ', New Salary: ' || (v_old_salary + (v_old_salary * p_percentage / 100)));
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/


-- Valid update
EXEC UpdateSalary(1, 10);

-- Invalid employee ID
EXEC UpdateSalary(99, 10);
