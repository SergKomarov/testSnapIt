package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "organization")
@Getter
@Setter
public class Organization {

    @Id
    @Column(name = "inn")
    private String inn;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sale> salelist = new ArrayList<>();

    public List<Sale> getSalelist() {
        return salelist;
    }

    public void setSalelist(List<Sale> salelist) {
        this.salelist = salelist;
    }
}
