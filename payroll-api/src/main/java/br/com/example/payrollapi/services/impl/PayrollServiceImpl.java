package br.com.example.payrollapi.services.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.example.payrollapi.client.user.UserClientService;
import br.com.example.payrollapi.domain.Payroll;
import br.com.example.payrollapi.domain.User;
import br.com.example.payrollapi.services.PayrollService;
import br.com.example.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;

@Service
public class PayrollServiceImpl implements PayrollService {

    private static final Logger logger = LoggerFactory.getLogger(PayrollServiceImpl.class);

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private Environment env;

    @Override
    public Payroll getPayroll(long workerId, Payroll request) {
        logger.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port.");

        try {
            User user = userClientService.findById(workerId).getBody();

            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        request.getDescription(),
                        user.getHourlyPrice(),
                        request.getWorkedHours(),
                        user.getHourlyPrice() * request.getWorkedHours());
            }
        } catch (FeignException.NotFound e) {
            throw new ObjectNotFoundException("Object not found.");
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal argument exception.");
        }

        return null;
    }

}
