package com.turkcell.crm.invoiceService.invoiceService.dataAccess.abstracts;

import com.turkcell.crm.invoiceService.invoiceService.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
