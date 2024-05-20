package com.turkcell.crm.invoiceService.invoiceService.core.crossCuttingConcerns.exceptions.types;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
