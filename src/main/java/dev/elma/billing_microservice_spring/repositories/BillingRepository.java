package dev.elma.billing_microservice_spring.repositories;

import dev.elma.billing_microservice_spring.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillingRepository extends JpaRepository<Bill,Long> {
}
