package com.example.demo.dto;

import com.example.demo.domain.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
public class SaleDto {


    private UUID id;
    private Boolean isOpen;



}
