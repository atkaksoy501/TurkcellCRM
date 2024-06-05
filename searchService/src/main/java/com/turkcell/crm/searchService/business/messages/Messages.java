package com.turkcell.crm.searchService.business.messages;

public class Messages {
    public static class IndividualCustomerErrors {
        public static final String CUSTOMER_ALREADY_EXISTS = "CustomerAlreadyExists";
        public static final String CUSTOMER_NOT_FOUND = "CustomerNotFound";
        public static final String NATIOANLITY_ID_MUST_11_DIGITS = "NationalityIdMustBe11Digits";
        public static final String CUSTOMER_ID_MUST_BETWEEN_1_AND_7_DIGITS = "CustomerIdMustBeBetween1And7Digits";
        public static final String ACCOUNT_NUMBER_MUST_BE_8_DIGITS = "AccountNumberMustBe8Digits";
        public static final String GSM_NUMBER_MUST_BE_11_DIGITS = "GSMNumberMustBe11Digits";
        public static final String ORDER_NUMBER_MUST_BE_8_DIGITS = "OrderNumberMustBe8Digits";
    }
}
