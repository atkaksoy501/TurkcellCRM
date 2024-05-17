package com.turkcell.crm.common.events.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountEvent {

    private int customerId;

    private int addressId;

}
