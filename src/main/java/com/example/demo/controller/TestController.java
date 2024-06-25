package com.example.demo.controller;

import com.example.demo.domain.Organization;
import com.example.demo.domain.Sale;
import com.example.demo.dto.SaleDto;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.SaleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class TestController {

    final SaleRepository saleRepository;

    final OrganisationRepository organisationRepository;

    public TestController(SaleRepository saleRepository, OrganisationRepository organisationRepository) {
        this.saleRepository = saleRepository;
        this.organisationRepository = organisationRepository;
    }


    @GetMapping(value = "/v1/{inn}")
    @Operation(summary = "Получить по ИНН организации все" +
            " магазины sales, которые открыты на данный момент")
    public ResponseEntity<List<SaleDto>> oneSale(
            @PathVariable("inn") String inn,
            @RequestParam(defaultValue = "false", required = false) Boolean isOpen
    ) {

        Organization organisation = organisationRepository.findOrganizationByInn(inn);

        List<Sale> saleList = organisation.getSalelist().stream()
                .filter(element -> element.getIsOpen().equals(isOpen)).toList();

        List<SaleDto> saleDtoList = new ArrayList<>();

        //dto convert
        saleList.stream().forEach(
                element -> {
                    SaleDto saleDto = new SaleDto();
                    saleDto.setId(element.getId());
                    saleDto.setIsOpen(element.getIsOpen());

                    saleDtoList.add(saleDto);
                }

        );

        return ResponseEntity.ok(saleDtoList);
    }


}
