package fr.macbill.invoiceservice;

import fr.macbill.invoiceservice.resources.InvoiceResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = InvoiceResource.class)
public class InvoiceResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInvoiceTemplateIsOk () throws Exception {
        mockMvc.perform(get("/invoice")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
}
