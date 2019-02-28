package fr.macbill.invoiceservice;

import fr.macbill.invoiceservice.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerDtoServiceTests {

    private final CustomerService customerService;

    public CustomerDtoServiceTests(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void test () {

    }
}
