package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product printer = new Product("printer");
        Product fax = new Product("fax");
        Product telephone = new Product("telephone");

        Invoice invoice = new Invoice("1");

        //When
        invoiceDao.save(invoice);
        productDao.save(printer);
        productDao.save(fax);
        productDao.save(telephone);

        Item printers = new Item(BigDecimal.valueOf(100), 1, printer, invoice);
        Item faxes = new Item(BigDecimal.valueOf(200), 2, fax, invoice);
        Item telephones = new Item(BigDecimal.valueOf(300), 3, telephone, invoice);

        itemDao.save(printers);
        itemDao.save(faxes);
        itemDao.save(telephones);


        //Then
        Optional<Invoice> actualInvoice = invoiceDao.findById(invoice.getId());
        Assert.assertTrue(actualInvoice.isPresent());
        Assert.assertEquals(3, actualInvoice.get().getItems().size());

        //CleanUp
        invoiceDao.deleteById(invoice.getId());
        productDao.deleteById(printer.getId());
        productDao.deleteById(fax.getId());
        productDao.deleteById(telephone.getId());
    }
}
