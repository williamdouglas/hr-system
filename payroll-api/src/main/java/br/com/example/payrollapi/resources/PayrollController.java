package br.com.example.payrollapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.payrollapi.domain.Payroll;
import br.com.example.payrollapi.services.PayrollService;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollController {

    @Autowired
    PayrollService payrollService;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll request) {
        return ResponseEntity.ok().body(payrollService.getPayroll(workerId, request));
    }

}
