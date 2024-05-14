package com.turkcell.crm.common.events.identity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerIdentityEvent {
    private String email;
    private String password;
}
