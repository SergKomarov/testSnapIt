package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(schema = "public", name = "sale")
@Getter
@Setter
public class Sale {

    @Id
    @Column
    private UUID id;

    @ManyToOne
    private Organization organization;

    @Column(name ="is_open")
    private Boolean isOpen;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
