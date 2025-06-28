CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount     IN NUMBER,
    p_annual_rate     IN NUMBER,
    p_duration_years  IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / 12 / 100;
    v_months := p_duration_years * 12;

    IF v_monthly_rate = 0 THEN
        v_emi := p_loan_amount / v_months;
    ELSE
        v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) /
                 (POWER(1 + v_monthly_rate, v_months) - 1);
    END IF;

    RETURN ROUND(v_emi, 2);
END;
/

-- Example: 5000 loan, 5% interest, 5 years
SELECT CalculateMonthlyInstallment(5000, 5, 5) AS EMI FROM DUAL;
