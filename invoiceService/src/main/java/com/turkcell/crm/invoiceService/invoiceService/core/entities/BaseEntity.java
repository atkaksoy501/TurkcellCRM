package com.turkcell.crm.invoiceService.invoiceService.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity<T extends Serializable> {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "base_sequence_generator" //generator name
    )
    @Column(name = "id")
    private T id;

    @Column(name = "createDate")
    private LocalDateTime createdDate;

    @Column(name = "updateDate")
    private LocalDateTime updatedDate;

    @Column(name = "deleteDate")
    private LocalDateTime deletedDate;

    @Column(name = "active")
    private Boolean active;
}
