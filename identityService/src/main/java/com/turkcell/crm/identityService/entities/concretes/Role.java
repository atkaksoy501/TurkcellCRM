package com.turkcell.crm.identityService.entities.concretes;

import com.turkcell.crm.identityService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;


}
