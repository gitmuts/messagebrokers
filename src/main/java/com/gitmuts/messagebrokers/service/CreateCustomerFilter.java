package com.gitmuts.messagebrokers.service;

import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
@Slf4j
public class CreateCustomerFilter {

    @Filter(inputChannel = "customerFilter", outputChannel = "transformCustomer")
    public boolean checkIfCustomerIsOver18(Customer customer) {

        log.info("Received Filter request {}", customer);

        Date d = new Date();
        Calendar today = getCalender(new Date());
        Calendar dob = getCalender(customer.getDob());
        // not entirely correct, should check month
        int diff = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        return diff >= 18 ? true : false;
    }

    private Calendar getCalender(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
