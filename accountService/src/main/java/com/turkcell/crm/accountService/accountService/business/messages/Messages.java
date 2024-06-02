package com.turkcell.crm.accountService.accountService.business.messages;

public class Messages {

    public static class AccountErrors {

        public static final String ACCOUNT_NOT_FOUND = "Account does not exist";
        public static final String ACCOUNT_HAS_PRODUCTS = "Cannot delete account with associated products";
    }
}
