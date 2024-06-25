package com.example.demo.repository;

import com.example.demo.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organization, String> {

    Organization findOrganizationByInn(String inn);

}
