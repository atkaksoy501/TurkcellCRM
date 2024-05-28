package com.turkcell.crm.cartService.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntity<T extends Serializable> {

    private T id;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;

    private boolean active;

}
