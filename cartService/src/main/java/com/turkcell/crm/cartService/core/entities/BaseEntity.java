package com.turkcell.crm.cartService.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor

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
    private boolean active;

}
