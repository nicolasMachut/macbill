package fr.macbill.invoiceservice;

import fr.macbill.invoiceservice.resources.InvoiceResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = InvoiceResource.class)
public class InvoiceResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInvoiceTemplateIsOk () throws Exception {
        mockMvc.perform(get("/invoice")
                .param("customerId", "1")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("invoice"))
                .andExpect(model().attribute("customer", hasProperty("id", is("1"))))
                .andExpect(model().attribute("customer", hasProperty("firstName", is("Nicolas"))));
    }
}
