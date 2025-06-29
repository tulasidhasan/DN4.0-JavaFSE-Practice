CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hiredate   IN DATE
    );

    PROCEDURE UpdateEmployeeDetails (
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER
    );

    FUNCTION CalculateAnnualSalary (
        p_emp_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hiredate   IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_emp_id, p_name, p_position, p_salary, p_department, p_hiredate);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee already exists.');
    END;

    PROCEDURE UpdateEmployeeDetails (
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Position = p_position,
            Salary = p_salary
        WHERE EmployeeID = p_emp_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Employee details updated.');
        END IF;
    END;

    FUNCTION CalculateAnnualSalary (
        p_emp_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_emp_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;

END EmployeeManagement;
/


EXEC EmployeeManagement.HireEmployee(3, 'Sunil Mehta', 'Analyst', 45000, 'Finance', TO_DATE('2022-02-15','YYYY-MM-DD'));

EXEC EmployeeManagement.UpdateEmployeeDetails(3, 'Sunil Mehta', 'Senior Analyst', 50000);

SELECT EmployeeManagement.CalculateAnnualSalary(3) AS AnnualSalary FROM DUAL;
