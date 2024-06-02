package com.turkcell.crm.customerService.business.messages;

public class Messages {
    public static class IndividualCustomerErrors {
        public static final String CUSTOMER_ALREADY_EXISTS = "CustomerAlreadyExists";
        public static final String CUSTOMER_NOT_FOUND = "CustomerNotFound";
        public static final String CITIZEN_NOT_FOUND="CitizenNotFound";

    }

    public static class AddressErrors{
        public static final String INVALID_CITY ="Invalid city";
        public static final String CANNOT_BE_EMPTY ="cannot be empty";
        public static final String  ADDRESS_NOT_FOUND ="address not found";
        public static final String CUSTOMER_SHOULD_HAVE_AT_LEAST_ONE_ADDRESS = "Customer should have at least one address.";
        public static final String CANNOT_DELETE_DEFAULT_ADDRESS = "The address that you want to delete is a default address. Please, change default address then try again.";

    }
}
