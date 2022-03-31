package br.com.example.payrollapi.services;

import br.com.example.payrollapi.domain.Payroll;

public interface PayrollService {

    public Payroll getPayroll(long workerId, Payroll request);

}
