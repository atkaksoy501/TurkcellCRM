package com.turkcell.crm.invoiceService.invoiceService.core.business.abstracts;

public interface MessageService {

    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}
