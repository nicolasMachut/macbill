package fr.macbill.backend.services;

import fr.macbill.backend.models.Invoice;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    //private static final String logo_path = "/jasper/images/stackextend-logo.png";
    private final String invoice_template_path = "/jasper/invoice.jrxml";

    Logger log = LogManager.getLogger(InvoiceService.class);

    @Override
    public void generateInvoiceFor(Invoice invoice, Locale locale, ServletOutputStream outputStream) throws IOException {
        // Create a temporary PDF file
        File pdfFile = File.createTempFile("my-invoice", ".pdf");

        // Initiate a FileOutputStream
        try {
            // Load the invoice jrxml template.
            final JasperReport report = loadTemplate();

            // Create parameters map.
            final Map<String, Object> parameters = parameters(invoice, locale);

            // Create an empty datasource.
            final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));
            JasperReportsUtils.renderAsPdf(report, parameters, dataSource, outputStream);
            System.out.println(pdfFile.getAbsolutePath());
        } catch (final Exception e) {
            log.error(String.format("An error occured during PDF creation: %s", e));
        }
    }

    private JasperReport loadTemplate() throws JRException {

        log.info(String.format("Invoice template path : %s", invoice_template_path));

        final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template_path);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        return JasperCompileManager.compileReport(jasperDesign);
    }

    private Map<String, Object> parameters(Invoice invoice, Locale locale) {
        final Map<String, Object> parameters = new HashMap<>();

        //parameters.put("logo", getClass().getResourceAsStream(logo_path));
        parameters.put("invoice",  invoice);
        parameters.put("REPORT_LOCALE", locale);

        return parameters;
    }
}
